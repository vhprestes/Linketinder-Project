package org.acczg.DAO

import org.acczg.models.Empresa

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class EmpresaDAO {

    private Connection connection

    EmpresaDAO() {

        try {
            Properties props = new Properties()
            props.setProperty("user", "postgres")
            props.setProperty("password", "postgres")
            props.setProperty("ssl", "false")
            String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/postgres"

            this.connection = DriverManager.getConnection(URL_SERVIDOR, props)

        } catch (Exception e) {
            e.printStackTrace()
            print('erro: Exception em EmpresaDAO')
            if (e instanceof ClassNotFoundException) {
                System.err.println("Verifique o driver de conexão.")
            } else {
                System.err.println("Verifique se o servidor está ativo.")
            }
        }
    }


    List<Empresa> listar() {
        String query = "SELECT * FROM empresa ORDER BY id"
        List<Empresa> retorno = new ArrayList<>()
        try {
            PreparedStatement stmt = connection.prepareStatement(query)
            ResultSet resultado = stmt.executeQuery()
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
                retorno.add(empresa)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            connection.close()
        }
        return retorno
    }


    boolean inserir(Empresa empresa) {
        String query = "INSERT INTO empresa(nome, descricao, cnpj, email, pais_id, cep, senha, estado_id)" +
                "VALUES (?,?,?,?,?,?,?,?)"
        try {
            PreparedStatement stmt = connection.prepareStatement(query)
            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getDescricao())
            stmt.setString(3, empresa.getCnpj())
            stmt.setString(4, empresa.getEmail())
            stmt.setInt(5, Integer.parseInt(empresa.getPais()))
            stmt.setString(6, empresa.getCep())
            stmt.setString(7, empresa.getSenha())
            stmt.setInt(8, Integer.parseInt(empresa.getEstado()))
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean alterar(Empresa empresa) {
        String query = "UPDATE empresa SET nome=?, descricao=?, cnpj=?, email=?, pais_id=?, cep=?, senha=?, estado_id=? " +
                "WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(query)
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
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean remover(Integer id) {
        String query = "DELETE FROM empresa WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(query)
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
