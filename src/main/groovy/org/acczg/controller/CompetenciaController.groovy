package org.acczg.controller

import org.acczg.DAO.CompetenciaDAO
import org.acczg.models.Competencia
import org.acczg.service.CompetenciaService


class CompetenciaController {
    private CompetenciaService competenciaService

    CompetenciaController() {
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        this.competenciaService = new CompetenciaService(competenciaDAO)
    }

    void listarCompetencias() {
        competenciaService.listarCompetencias()
    }

    void cadastrarCompetencia(Competencia competencia) {
        competenciaService.cadastrarCompetencia(competencia)
    }

    void alterarCompetencia(Competencia competencia) {
        competenciaService.alterarCompetencia(competencia)
    }

    void deletarCompetencia(int id) {
        competenciaService.deletarCompetencia(id)
    }
}
