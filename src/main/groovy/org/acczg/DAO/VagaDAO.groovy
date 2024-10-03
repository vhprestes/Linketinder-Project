package org.acczg.DAO

import org.acczg.models.Vaga

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class VagaDAO {

    private Connection connection

    VagaDAO() {
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

    List<Vaga> listar() {
        String query = "SELECT * FROM vagas ORDER BY id"
        List<Vaga> vagas = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                Vaga vaga = new Vaga()
                vaga.setId(resultado.getInt("id"))
                vaga.setNome(resultado.getString("nome"))
                vaga.setDescricao(resultado.getString("descricao"))
                vaga.setCidade(resultado.getString("cidade"))
                vaga.setEmpresa(resultado.getString("empresa_id"))

                List<String> competencias = new ArrayList<>()
                String queryCompetencias = "SELECT competencia " +
                        "FROM competencias " +
                        "WHERE id IN (SELECT id_competencias " +
                        "FROM competencias_vagas " +
                        "WHERE id_vagas = ?);"
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
            e.printStackTrace()
        }
        return vagas
    }

    boolean inserir(Vaga vaga) {
        String sql = "INSERT INTO vagas(nome, descricao, cidade, empresa_id) VALUES (?,?,?,?)"
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vaga.getNome())
            stmt.setString(2, vaga.getDescricao())
            stmt.setString(3, vaga.getCidade())
            stmt.setInt(4, Integer.parseInt(vaga.getEmpresa()))
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }

    boolean inserirCompetenciaVaga(int vagaId, int competenciaId) {
        String query = "INSERT INTO competencias_vagas(id_vagas, id_competencias) VALUES (?,?)"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, vagaId)
            stmt.setInt(2, competenciaId)
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }

    boolean alterar(Vaga vaga) {
        String query = "UPDATE vagas SET nome=?, descricao=?, cidade=?, empresa_id=? WHERE id=?"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vaga.getNome())
            stmt.setString(2, vaga.getDescricao())
            stmt.setString(3, vaga.getCidade())
            stmt.setInt(4, Integer.parseInt(vaga.getEmpresa()))
            stmt.setInt(5, vaga.getId())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }

    boolean remover(Integer id) {
        String queryCompetencias = "DELETE FROM competencias_vagas WHERE id_vagas=?"
        String query = "DELETE FROM vagas WHERE id=?"
        try (PreparedStatement stmtCompetencias = connection.prepareStatement(queryCompetencias);
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmtCompetencias.setInt(1, id)
            stmtCompetencias.execute()
            stmt.setInt(1, id)
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }
}