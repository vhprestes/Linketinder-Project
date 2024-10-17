package org.acczg.service

import org.acczg.DAO.CandidatoDAO
import org.acczg.models.Candidato

class CandidatoService {

    static listarCandidatos() {
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        candidatoDAO.listar().each { candidato ->
            println candidato
        }
    }

    static cadastrarCandidato(Candidato candidato) {
        CandidatoDAO candidatoDAO = new CandidatoDAO()

        try {
            candidatoDAO.inserir(candidato)
            println "Candidato cadastrado com sucesso"
        } catch (Exception e) {
            println "Erro ao tentar cadastrar o candidato. Erro: ${e}"
        }
    }

    static cadastrarCompetenciaCandidato(int candidato_id, int competencia_id) {
        CandidatoDAO candidatoDAO = new CandidatoDAO()

        try {
            candidatoDAO.inserirCompetenciaCandidato(candidato_id, competencia_id)
            println "Competência cadastrada com sucesso"
        } catch (Exception e) {
            println "Erro ao tentar cadastrar a nova competência. Erro: ${e}"
        }
    }

    static alterarCandidato(Candidato candidato, List<Integer> novasCompetencias) {
        CandidatoDAO candidatoDAO = new CandidatoDAO()

        try {
            candidatoDAO.alterar(candidato, novasCompetencias)
            println "Candidato alterado com sucesso"
        } catch (Exception e) {
            println "Erro ao tentar alterar o candidato. Erro: ${e}"
        }
    }

    static deletarCandidato(Integer id) {
        CandidatoDAO candidatoDAO = new CandidatoDAO()

        try {
            candidatoDAO.remover(id)
            println "Candidato removido com sucesso"
        } catch (Exception e) {
            println "Erro ao tentar remover o candidato. Erro: ${e}"
        }
    }

    List<Candidato> obterCandidatosCadastrados() {

        List<Candidato> candidatosList
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        candidatosList = candidatoDAO.listar()
        return candidatosList
    }

}
