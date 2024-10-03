package org.acczg.service

import org.acczg.DAO.EmpresaDAO
import org.acczg.models.Empresa

class EmpresaService {

    static listarEmpresas() {

        EmpresaDAO empresaDAO = new EmpresaDAO()
        empresaDAO.listar().each { empresa ->
            println empresa.toString()
        }
    }

    static cadastrarEmpresa(Empresa empresa) {

        boolean retornoDB
        EmpresaDAO empresaDAO = new EmpresaDAO()
        retornoDB = empresaDAO.inserir(empresa)

        if (retornoDB) {
            println "Empresa cadastrada com sucesso"
        } else {
            println "Erro no cadastro"
        }
    }

    static alterarEmpresa(Empresa empresa) {

        boolean retornoDB
        EmpresaDAO empresaDAO = new EmpresaDAO()
        retornoDB = empresaDAO.alterar(empresa)

        if (retornoDB) {
            println "Empresa alterada com sucesso"
        } else {
            println "Erro na alteração da empresa"
        }
    }

    static deletarEmpresa(Integer id) {

        boolean retornoDB
        EmpresaDAO empresaDAO = new EmpresaDAO()
        retornoDB = empresaDAO.remover(id)

        if (retornoDB) {
            println "Empresa deletada com sucesso"
        } else {
            println "Erro ao deletar empresa"
        }

    }

    List<Empresa> empresasCadastradas() {

        List<Empresa> listaEmpresa
        EmpresaDAO empresaDAO = new EmpresaDAO()
        listaEmpresa = empresaDAO.listar()
        return listaEmpresa
    }

}

