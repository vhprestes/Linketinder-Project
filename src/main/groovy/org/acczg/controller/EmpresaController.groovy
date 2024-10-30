package org.acczg.controller

import org.acczg.DAO.EmpresaDAO
import org.acczg.models.Empresa
import org.acczg.service.EmpresaService

class EmpresaController {

    private EmpresaService empresaService

    EmpresaController() {
        EmpresaDAO empresaDAO = new EmpresaDAO()
        this.empresaService = new EmpresaService(empresaDAO)
    }

    void listarEmpresas() {
        empresaService.listarEmpresas()
    }

    void cadastrarEmpresa(Empresa empresa) {
        empresaService.cadastrarEmpresa(empresa)
    }

    void alterarEmpresa(Empresa empresa) {
        empresaService.alterarEmpresa(empresa)
    }

    void deletarEmpresa(int id) {
        empresaService.deletarEmpresa(id)
    }
}