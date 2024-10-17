package org.acczg.DAO

import org.acczg.connection.Connect
import org.acczg.models.Empresa

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class EmpresaDAO {

    private Connection connection

    EmpresaDAO() {
        Connect connectInstance = new Connect()
        this.connection = connectInstance.connect()
    }

    List<Empresa> listar() {
        String query = "SELECT * FROM empresa ORDER BY id"
        List<Empresa> empresas = new ArrayList<>()
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                Empresa empresa = new Empresa()
                empresa.setId(resultado.getInt("id"))
                empresa.setNome(resultado.getString("nome"))
                empresa.setCnpj(resultado.getString("cnpj"))
                empresa.setEmail(resultado.getString("email"))
                empresa.setDescricao(resultado.getString("descricao"))
                empresa.setSenha(resultado.getString("senha"))
                empresa.setPais(resultado.getString("pais_id"))
                empresa.setCep(resultado.getString("cep"))
                empresa.setEstado(resultado.getString("estado_id"))
                empresas.add(empresa)
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar as empresas: " + e.getMessage(), e)
        }
        return empresas
    }

    void inserir(Empresa empresa) {
        String query = "INSERT INTO empresa(nome, descricao, cnpj, email, pais_id, cep, senha, estado_id) VALUES (?,?,?,?,?,?,?,?)"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getDescricao())
            stmt.setString(3, empresa.getCnpj())
            stmt.setString(4, empresa.getEmail())
            stmt.setInt(5, Integer.parseInt(empresa.getPais()))
            stmt.setString(6, empresa.getCep())
            stmt.setString(7, empresa.getSenha())
            stmt.setInt(8, Integer.parseInt(empresa.getEstado()))
            stmt.execute()
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir empresa: " + e.getMessage(), e)
        }
    }

    void alterar(Empresa empresa) {
        String query = "UPDATE empresa SET nome=?, descricao=?, cnpj=?, email=?, pais_id=?, cep=?, senha=?, estado_id=? WHERE id=?"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getDescricao())
            stmt.setString(3, empresa.getCnpj())
            stmt.setString(4, empresa.getEmail())
            stmt.setInt(5, Integer.parseInt(empresa.getPais()))
            stmt.setString(6, empresa.getCep())
            stmt.setString(7, empresa.getSenha())
            stmt.setInt(8, Integer.parseInt(empresa.getEstado()))
            stmt.setInt(9, empresa.getId())
            stmt.execute()
        } catch (Exception e) {
            throw new RuntimeException("Erro ao alterar empresa: " + e.getMessage(), e)
        }
    }

    void remover(Integer id) {
        String query = "DELETE FROM empresa WHERE id=?"
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id)
            stmt.execute()
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover empresa: " + e.getMessage(), e)
        }
    }
}
