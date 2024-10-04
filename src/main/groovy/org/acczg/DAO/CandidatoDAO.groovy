package org.acczg.DAO

import org.acczg.models.Candidato

import java.sql.Connection
import java.sql.Date
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.text.SimpleDateFormat
import java.util.Properties


class CandidatoDAO {

    private Connection connection

    CandidatoDAO() {
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

    List<Candidato> listar() {
        String query = "SELECT * FROM candidatos ORDER BY id"
        List<Candidato> candidatos = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                Candidato candidato = new Candidato()
                candidato.setId(resultado.getInt("id"))
                candidato.setNome(resultado.getString("nome"))
                candidato.setSobrenome(resultado.getString("sobrenome"))
                candidato.setCpf(resultado.getString("cpf"))
                candidato.setDataNascimento(resultado.getString("data_nascimento"))
                candidato.setEmail(resultado.getString("email"))
                candidato.setDescricao(resultado.getString("descricao"))
                candidato.setSenha(resultado.getString("senha"))
                candidato.setPais(resultado.getString("pais_id"))
                candidato.setCep(resultado.getString("cep"))
                candidato.setEstado(resultado.getString("estado_id"))

                List<String> competencias = new ArrayList<>()
                String sqlCompetencias = "SELECT competencia " +
                        "FROM competencias " +
                        "WHERE id IN (SELECT id_competencias " +
                        "FROM competencias_candidatos " +
                        "WHERE id_candidato = ?)"
                try (PreparedStatement stmtCompetencias = connection.prepareStatement(sqlCompetencias)) {
                    stmtCompetencias.setInt(1, candidato.getId())
                    try (ResultSet resultadoCompetencias = stmtCompetencias.executeQuery()) {
                        while (resultadoCompetencias.next()) {
                            competencias.add(resultadoCompetencias.getString("competencia"))
                        }
                    }
                }
                candidato.setCompetencias(competencias)
                candidatos.add(candidato)
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
        return candidatos
    }

    boolean inserir(Candidato candidato) {
        String query = "INSERT INTO candidatos(nome, sobrenome, cpf, data_nascimento, email, descricao, senha, pais_id, cep, estado_id) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy")
            java.util.Date dataUtil = formatador.parse(candidato.getDataNascimento())
            Date dataSQL = new Date(dataUtil.getTime())

            stmt.setString(1, candidato.getNome())
            stmt.setString(2, candidato.getSobrenome())
            stmt.setString(3, candidato.getCpf())
            stmt.setDate(4, dataSQL)
            stmt.setString(5, candidato.getEmail())
            stmt.setString(6, candidato.getDescricao())
            stmt.setString(7, candidato.getSenha())
            stmt.setInt(8, Integer.parseInt(candidato.getPais()))
            stmt.setString(9, candidato.getCep())
            stmt.setInt(10, Integer.parseInt(candidato.getEstado()))
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }

    boolean inserirCompetenciaCandidato(int candidatoId, int competenciaId) {
        String query = "INSERT INTO competencias_candidatos(id_candidato, id_competencias) VALUES (?,?)"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, candidatoId)
            stmt.setInt(2, competenciaId)
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }

    boolean alterar(Candidato candidato, List<Integer> novasCompetencias) {
        String query = "UPDATE candidatos SET nome=?, sobrenome=?, cpf=?, data_nascimento=?, email=?, descricao=?, senha=?, pais_id=?, cep=?, estado_id=? WHERE id=?"
        String deleteCompetenciasQuery = "DELETE FROM competencias_candidatos WHERE id_candidato=?"
        String insertCompetenciaQuery = "INSERT INTO competencias_candidatos(id_candidato, id_competencias) VALUES (?,?)"
        try {
            connection.setAutoCommit(false)

            try (PreparedStatement stmt = connection.prepareStatement(query)) {

                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy")
                java.util.Date dataUtil = formatador.parse(candidato.getDataNascimento())
                Date dataSQL = new Date(dataUtil.getTime())


                stmt.setString(1, candidato.getNome())
                stmt.setString(2, candidato.getSobrenome())
                stmt.setString(3, candidato.getCpf())
                stmt.setDate(4, dataSQL)
                stmt.setString(5, candidato.getEmail())
                stmt.setString(6, candidato.getDescricao())
                stmt.setString(7, candidato.getSenha())
                stmt.setInt(8, Integer.parseInt(candidato.getPais()))
                stmt.setString(9, candidato.getCep())
                stmt.setInt(10, Integer.parseInt(candidato.getEstado()))
                stmt.setInt(11, candidato.getId())
                stmt.execute()
            }


            try (PreparedStatement stmtDelete = connection.prepareStatement(deleteCompetenciasQuery)) {
                stmtDelete.setInt(1, candidato.getId())
                stmtDelete.execute()
            }

            try (PreparedStatement stmtInsert = connection.prepareStatement(insertCompetenciaQuery)) {
                for (Integer competenciaId : novasCompetencias) {
                    stmtInsert.setInt(1, candidato.getId())
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

    boolean remover(Integer id) {
        String sqlCompetencias = "DELETE FROM competencias_candidatos WHERE id_candidato=?"
        String query = "DELETE FROM candidatos WHERE id=?"
        try (PreparedStatement stmtCompetencias = connection.prepareStatement(sqlCompetencias);
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