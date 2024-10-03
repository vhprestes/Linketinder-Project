package org.acczg.DAO

import org.acczg.models.Competencia

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class CompetenciaDAO {

    private Connection connection

    CompetenciaDAO() {

        try {
            Properties props = new Properties()
            props.setProperty("user", "postgres")
            props.setProperty("password", "postgres")
            props.setProperty("ssl", "false")
            String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/postgres"

            this.connection = DriverManager.getConnection(URL_SERVIDOR, props)

        } catch (Exception e) {
            e.printStackTrace()
            if (e instanceof ClassNotFoundException) {
                System.err.println("Verifique o driver de conexão.")
            } else {
                System.err.println("Verifique se o servidor está ativo.")
            }
        }
    }

    List<Competencia> listar() {
        String sql = "SELECT * FROM competencias ORDER BY id"
        List<Competencia> retorno = new ArrayList<>()
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            ResultSet resultado = stmt.executeQuery()
            while (resultado.next()) {
                Competencia competencia = new Competencia()
                competencia.setId(resultado.getInt("id"))
                competencia.setCompetencia(resultado.getString("competencia"))
                retorno.add(competencia)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            connection.close()
        }
        return retorno
    }

    boolean inserir(Competencia competencia) {
        String sql = "INSERT INTO competencias(competencia) VALUES (?)"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setString(1, competencia.getCompetencia())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean alterar(Competencia competencia) {
        String sql = "UPDATE competencias SET competencia=? WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setString(1, competencia.getCompetencia())
            stmt.setInt(2, competencia.getId())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM competencias WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setInt(1, id)
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }
}
