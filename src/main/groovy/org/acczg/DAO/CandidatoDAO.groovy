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
//            jdbc:postgresql://localhost:5432/postgres from intellij

            this.connection = DriverManager.getConnection(URL_SERVIDOR, props)

        } catch (Exception e) {
            e.printStackTrace()
            print('erro: Exception em CandidatoDAO')
            if (e instanceof ClassNotFoundException) {
                System.err.println("Verifique o driver de conexão.")
            } else {
                System.err.println("Verifique se o servidor está ativo.")
            }
        }
    }

//    R
    List<Candidato> listar() {
        String sql = "SELECT * FROM candidatos ORDER BY id"
        List<Candidato> retorno = new ArrayList<>()
        try {

            PreparedStatement stmt = connection.prepareStatement(sql)
            ResultSet resultado = stmt.executeQuery()

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

                List<String> competencias = new ArrayList<>();
                String sqlCompetencias = "SELECT comp.competencia " +
                        "FROM competencias_candidatos AS comp_c " +
                        "JOIN competencias AS comp ON comp.id = comp_c.id_competencias " +
                        "WHERE comp_c.id_candidato = ?";
                PreparedStatement stmtCompetencias = connection.prepareStatement(sqlCompetencias);
                stmtCompetencias.setInt(1, candidato.getId());
                ResultSet resultadoCompetencias = stmtCompetencias.executeQuery();
                while (resultadoCompetencias.next()) {
                    competencias.add(resultadoCompetencias.getString("competencia"));
                }

                candidato.setCompetencias(competencias);

                retorno.add(candidato)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            connection.close()
        }
        return retorno
    }

    boolean inserir(Candidato candidato) {
        String sql = "INSERT INTO candidatos(nome, sobrenome, cpf, data_nascimento, email, descricao, senha, pais_id, cep, estado_id)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?)"
        try {

            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy")
            java.util.Date dataUtil = formatador.parse(candidato.getDataNascimento())
            Date dataSQL = new Date(dataUtil.getTime())

            PreparedStatement stmt = connection.prepareStatement(sql)
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
        } finally {
            connection.close()
        }
    }

    boolean inserirCompetenciaCandidato(int candidato_id, int competencia_id) {
        String sql = "INSERT INTO competencias_candidatos(id_candidato, id_competencias) VALUES (?,?)"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setInt(1, candidato_id)
            stmt.setInt(2, competencia_id)
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean alterar(Candidato candidato) {
        String sql = "UPDATE candidatos SET nome=?, sobrenome=?, cpf=?, data_nascimento=?, email=?, descricao=?, senha=?, pais_id=?, cep=?, estado_id=? " +
                "WHERE id=?"
        try {

            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy")
            java.util.Date dataUtil = formatador.parse(candidato.getDataNascimento())
            Date dataSQL = new Date(dataUtil.getTime())

            PreparedStatement stmt = connection.prepareStatement(sql)
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
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean remover(Integer id) {
        String sqlCompetencias = "DELETE FROM competencias_candidatos WHERE id_candidato=?"
        String sql = "DELETE FROM candidatos WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(sqlCompetencias)
            stmt.setInt(1, id)
            stmt.execute()

            stmt = connection.prepareStatement(sql)
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
