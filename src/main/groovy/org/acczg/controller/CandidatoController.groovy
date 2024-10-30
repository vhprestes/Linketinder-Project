package org.acczg.controller

import org.acczg.DAO.CandidatoDAO
import org.acczg.models.Candidato
import org.acczg.models.Competencia
import org.acczg.service.CandidatoService
import org.acczg.service.CompetenciaService

class CandidatoController {

    private CandidatoService candidatoService
    private CompetenciaService competenciaService

    CandidatoController() {
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        this.candidatoService = new CandidatoService(candidatoDAO)
        this.competenciaService = new CompetenciaService()
    }

    void listarCandidatos() {
        candidatoService.listarCandidatos()
    }

    void cadastrarCandidato(Candidato candidato) {
        candidatoService.cadastrarCandidato(candidato)
    }

    void listarCompetencias() {
        competenciaService.listarCompetencias()
    }

    void cadastrarCompetenciaCandidato(int candidatoId, int competenciaId) {
        candidatoService.cadastrarCompetenciaCandidato(candidatoId, competenciaId)
    }

    void cadastrarNovaCompetencia(int candidatoId, String competencia) {
        Competencia novaCompetencia = new Competencia()
        novaCompetencia.setCompetencia(competencia)
        competenciaService.cadastrarCompetencia(novaCompetencia)
        List<Competencia> competenciasDB = competenciaService.obterCompetenciasCadastradas()
        cadastrarCompetenciaCandidato(candidatoId, competenciasDB[-1].getId())
    }

    void alterarCandidato(Candidato candidato, List<Integer> novasCompetencias) {
        candidatoService.alterarCandidato(candidato, novasCompetencias)
    }

    void deletarCandidato(int id) {
        candidatoService.deletarCandidato(id)
    }
}