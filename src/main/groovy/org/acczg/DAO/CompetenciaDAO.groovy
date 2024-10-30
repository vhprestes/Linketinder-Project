package org.acczg.DAO

import org.acczg.connection.Connect
import org.acczg.models.Competencia

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class CompetenciaDAO {
    private Connection connection

    CompetenciaDAO() {
        this.connection = Connect.getInstance().connect()
    }

    List<Competencia> listar() {
        String query = "SELECT * FROM competencias ORDER BY id"
        List<Competencia> competencias = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(query)
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                Competencia competencia = new Competencia()
                competencia.setId(resultado.getInt("id"))
                competencia.setCompetencia(resultado.getString("competencia"))
                competencias.add(competencia)
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e)
        }
        return competencias
    }

    void inserir(Competencia competencia) {
        String query = "INSERT INTO competencias(competencia) VALUES (?)"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, competencia.getCompetencia())
            stmt.execute()
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e)
        }
    }

    void alterar(Competencia competencia) {
        String query = "UPDATE competencias SET competencia=? WHERE id=?"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, competencia.getCompetencia())
            stmt.setInt(2, competencia.getId())
            stmt.execute()
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e)
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
                throw new Exception(e.getMessage(), e)
            }
        }
    }
}