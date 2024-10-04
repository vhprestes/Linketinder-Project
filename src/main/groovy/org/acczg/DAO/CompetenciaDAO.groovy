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
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage())
        }
    }

    List<Competencia> listar() {
        String query = "SELECT * FROM competencias ORDER BY id"
        List<Competencia> competencias = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                Competencia competencia = new Competencia()
                competencia.setId(resultado.getInt("id"))
                competencia.setCompetencia(resultado.getString("competencia"))
                competencias.add(competencia)
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
        return competencias
    }

    boolean inserir(Competencia competencia) {
        String query = "INSERT INTO competencias(competencia) VALUES (?)"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, competencia.getCompetencia())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }

    boolean alterar(Competencia competencia) {
        String query = "UPDATE competencias SET competencia=? WHERE id=?"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, competencia.getCompetencia())
            stmt.setInt(2, competencia.getId())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }

    boolean remover(Integer id) {
        String deleteReferencesQuery = "DELETE FROM competencias_candidatos WHERE id_competencias=?"
        String deleteCompetenciaQuery = "DELETE FROM competencias WHERE id=?"
        try {
            connection.setAutoCommit(false)

            try (PreparedStatement stmtReferences = connection.prepareStatement(deleteReferencesQuery)) {
                stmtReferences.setInt(1, id)
                stmtReferences.execute()
            }

            try (PreparedStatement stmt = connection.prepareStatement(deleteCompetenciaQuery)) {
                stmt.setInt(1, id)
                stmt.execute()
            }

            connection.commit()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            try {
                connection.rollback()
            } catch (Exception rollbackException) {
                rollbackException.printStackTrace()
            }
            return false
        } finally {
            try {
                connection.setAutoCommit(true)
            } catch (Exception e) {
                e.printStackTrace()
            }
        }
    }
}