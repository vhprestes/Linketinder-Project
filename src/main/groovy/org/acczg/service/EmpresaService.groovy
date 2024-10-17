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

//    List<Empresa> obterEmpresasCadastradas() {
//        EmpresaDAO empresaDAO = new EmpresaDAO()
//        return empresaDAO.listar()
//    }

    static void cadastrarEmpresa(Empresa empresa) {
        EmpresaDAO empresaDAO = new EmpresaDAO()

        try {
            empresaDAO.inserir(empresa)
            println "Empresa cadastrada com sucesso"
        } catch (Exception e) {
            println "Erro no cadastro de empresa ${e.message}"
        }
    }

    static void alterarEmpresa(Empresa empresa) {
        EmpresaDAO empresaDAO = new EmpresaDAO()

        try {
            empresaDAO.alterar(empresa)
            println "Empresa alterada com sucesso"
        } catch (Exception e) {
            println "Erro na alteração de empresa ${e.message}"
        }
    }

    static void deletarEmpresa(Integer id) {
        EmpresaDAO empresaDAO = new EmpresaDAO()

        try {
            empresaDAO.remover(id)
            println "Empresa deletada com sucesso"
        } catch (Exception e) {
            println "Erro ao deletar empresa ${e.message}"
        }
    }
}