package org.acczg.service

import org.acczg.DAO.EmpresaDAO
import org.acczg.models.Empresa

class EmpresaService {

    private EmpresaDAO empresaDAO

    EmpresaService(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO
    }

    void listarEmpresas() {
        empresaDAO.listar().each { empresa ->
            println empresa.toString()
        }
    }

    void cadastrarEmpresa(Empresa empresa) {
        try {
            if (empresa == null) {
                throw new Exception("Empresa não pode ser nula")
            }
            empresaDAO.inserir(empresa)
            println "Empresa cadastrada com sucesso"
        } catch (Exception e) {
            println "Erro no cadastro de empresa ${e.message}"
        }
    }

    void alterarEmpresa(Empresa empresa) {
        try {
            empresaDAO.alterar(empresa)
            println "Empresa alterada com sucesso"
        } catch (Exception e) {
            println "Erro na alteração de empresa ${e.message}"
        }
    }

    void deletarEmpresa(Integer id) {
        try {
            empresaDAO.remover(id)
            println "Empresa deletada com sucesso"
        } catch (Exception e) {
            println "Erro ao deletar empresa ${e.message}"
            throw e
        }
    }

}