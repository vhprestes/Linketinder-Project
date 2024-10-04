package org.acczg.service

import org.acczg.DAO.EmpresaDAO
import org.acczg.models.Empresa

class EmpresaService {

    static void listarEmpresas() {
        EmpresaDAO empresaDAO = new EmpresaDAO()
        empresaDAO.listar().each { empresa ->
            println empresa.toString()
        }
    }

    List<Empresa> obterEmpresasCadastradas() {
        EmpresaDAO empresaDAO = new EmpresaDAO()
        return empresaDAO.listar()
    }

    static void cadastrarEmpresa(Empresa empresa) {
        EmpresaDAO empresaDAO = new EmpresaDAO()
        boolean sucesso = empresaDAO.inserir(empresa)

        if (sucesso) {
            println "Empresa cadastrada com sucesso"
        } else {
            println "Erro no cadastro de empresa"
        }
    }

    static void alterarEmpresa(Empresa empresa) {
        EmpresaDAO empresaDAO = new EmpresaDAO()
        boolean sucesso = empresaDAO.alterar(empresa)

        if (sucesso) {
            println "Empresa alterada com sucesso"
        } else {
            println "Erro na alteração de empresa"
        }
    }

    static void deletarEmpresa(Integer id) {
        EmpresaDAO empresaDAO = new EmpresaDAO()
        boolean sucesso = empresaDAO.remover(id)

        if (sucesso) {
            println "Empresa deletada com sucesso"
        } else {
            println "Erro ao deletar empresa"
        }
    }
}