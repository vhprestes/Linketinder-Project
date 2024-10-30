package org.acczg.controller

import org.acczg.DAO.VagaDAO
import org.acczg.models.Vaga
import org.acczg.service.VagaService

class VagasController {

    private VagaService vagaService

    VagasController() {
        VagaDAO vagaDAO = new VagaDAO()
        this.vagaService = new VagaService(vagaDAO)
    }

    void listarVagas() {
        vagaService.listarVagas()
    }

    void cadastrarVaga(Vaga vaga) {
        vagaService.cadastrarVaga(vaga)
    }

    void alterarVaga(Vaga vaga, List<Integer> novasCompetencias) {
        vagaService.alterarVaga(vaga, novasCompetencias)
    }

    void deletarVaga(int id) {
        vagaService.deletarVaga(id)
    }
}