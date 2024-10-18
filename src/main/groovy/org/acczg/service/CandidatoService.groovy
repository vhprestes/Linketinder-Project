package org.acczg.service

import org.acczg.DAO.CandidatoDAO
import org.acczg.models.Candidato

class CandidatoService {

    private CandidatoDAO candidatoDAO

    CandidatoService(CandidatoDAO candidatoDAO) {
        this.candidatoDAO = candidatoDAO
    }


    void listarCandidatos() {
        candidatoDAO.listar().each { candidato ->
            println candidato
        }
    }

    void cadastrarCandidato(Candidato candidato) {
        if ([candidato.dataNascimento, candidato.nome, candidato.sobrenome, candidato.cpf, candidato.email, candidato.descricao, candidato.senha, candidato.pais, candidato.estado, candidato.cep].any { it == null }) {
            println "Erro ao tentar cadastrar o candidato. Erro: Existem campos nulos"
            throw new IllegalArgumentException("Existem campos nulos")
        }
        try {
            candidatoDAO.inserir(candidato)
            println "Candidato cadastrado com sucesso"
        } catch (Exception e) {
            println "Erro ao tentar cadastrar o candidato. Erro: ${e}"
            throw e
        }
    }

    void cadastrarCompetenciaCandidato(int candidato_id, int competencia_id) {
        try {
            candidatoDAO.inserirCompetenciaCandidato(candidato_id, competencia_id)
            println "Competência cadastrada com sucesso"
        } catch (Exception e) {
            println "Erro ao tentar cadastrar a nova competência. Erro: ${e}"
        }
    }

    void alterarCandidato(Candidato candidato, List<Integer> novasCompetencias) {
        try {
            candidatoDAO.alterar(candidato, novasCompetencias)
            println "Candidato alterado com sucesso"
        } catch (Exception e) {
            println "Erro ao tentar alterar o candidato. Erro: ${e}"
            throw e
        }
    }

    void deletarCandidato(Integer id) {
        try {
            candidatoDAO.remover(id)
            println "Candidato removido com sucesso"
        } catch (Exception e) {
            println "Erro ao tentar remover o candidato. Erro: ${e}"
            throw e
        }
    }

    List<Candidato> obterCandidatosCadastrados() {
        List<Candidato> candidatosList
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        candidatosList = candidatoDAO.listar()
        return candidatosList
    }

}
