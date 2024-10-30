package org.acczg.DAO

import org.acczg.connection.Connect
import org.acczg.models.Vaga

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class VagaDAO {

    private Connection connection

    VagaDAO() {
        this.connection = Connect.getInstance().connect()
    }

    List<Vaga> listar() {
        String query = """
            SELECT v.id, v.nome, v.descricao, v.cidade, e.nome AS empresa_nome
            FROM vagas v
            JOIN empresa e ON v.empresa_id = e.id
            ORDER BY v.id
        """
        List<Vaga> vagas = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                Vaga vaga = new Vaga()
                vaga.setId(resultado.getInt("id"))
                vaga.setNome(resultado.getString("nome"))
                vaga.setDescricao(resultado.getString("descricao"))
                vaga.setCidade(resultado.getString("cidade"))
                vaga.setEmpresa(resultado.getString("empresa_nome"))

                List<String> competencias = new ArrayList<>()
                String queryCompetencias = """
                    SELECT c.competencia
                    FROM competencias c
                    WHERE c.id IN (
                        SELECT cv.id_competencias
                        FROM competencias_vagas cv
                        WHERE cv.id_vagas = ?
                    )
                """
                try (PreparedStatement stmtCompetencias = connection.prepareStatement(queryCompetencias)) {
                    stmtCompetencias.setInt(1, vaga.getId())
                    try (ResultSet resultadoCompetencias = stmtCompetencias.executeQuery()) {
                        while (resultadoCompetencias.next()) {
                            competencias.add(resultadoCompetencias.getString("competencia"))
                        }
                    }
                }
                vaga.setCompetencias(competencias)
                vagas.add(vaga)
            }
        } catch (Exception e) {
        throw new Exception(e.getMessage(), e)
        }
        return vagas
    }

    void inserir(Vaga vaga) {
        String sql = "INSERT INTO vagas(nome, descricao, cidade, empresa_id) VALUES (?,?,?,?)"
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vaga.getNome())
            stmt.setString(2, vaga.getDescricao())
            stmt.setString(3, vaga.getCidade())
            stmt.setInt(4, Integer.parseInt(vaga.getEmpresa()))
            stmt.execute()
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e)
        }
    }

    void inserirCompetenciaVaga(int vagaId, int competenciaId) {
        String query = "INSERT INTO competencias_vagas(id_vagas, id_competencias) VALUES (?,?)"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, vagaId)
            stmt.setInt(2, competenciaId)
            stmt.execute()
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e)
        }
    }

    boolean alterar(Vaga vaga, List<Integer> novasCompetencias) {
        String query = "UPDATE vagas SET nome=?, descricao=?, cidade=?, empresa_id=? WHERE id=?"
        String deleteCompetenciasQuery = "DELETE FROM competencias_vagas WHERE id_vagas=?"
        String insertCompetenciaQuery = "INSERT INTO competencias_vagas(id_vagas, id_competencias) VALUES (?,?)"
        try {
            connection.setAutoCommit(false)

            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, vaga.getNome())
                stmt.setString(2, vaga.getDescricao())
                stmt.setString(3, vaga.getCidade())
                stmt.setInt(4, Integer.parseInt(vaga.getEmpresa()))
                stmt.setInt(5, vaga.getId())
                stmt.execute()
            }

            try (PreparedStatement stmtDelete = connection.prepareStatement(deleteCompetenciasQuery)) {
                stmtDelete.setInt(1, vaga.getId())
                stmtDelete.execute()
            }

            try (PreparedStatement stmtInsert = connection.prepareStatement(insertCompetenciaQuery)) {
                for (Integer competenciaId : novasCompetencias) {
                    stmtInsert.setInt(1, vaga.getId())
                    stmtInsert.setInt(2, competenciaId)
                    stmtInsert.addBatch()
                }
                stmtInsert.executeBatch()
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

    void remover(Integer id) {
        String queryCompetencias = "DELETE FROM competencias_vagas WHERE id_vagas=?"
        String query = "DELETE FROM vagas WHERE id=?"
        try (PreparedStatement stmtCompetencias = connection.prepareStatement(queryCompetencias);
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmtCompetencias.setInt(1, id)
            stmtCompetencias.execute()
            stmt.setInt(1, id)
            stmt.execute()
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e)
        }
    }
}