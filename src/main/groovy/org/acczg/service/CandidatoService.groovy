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

        boolean retornoDB
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        retornoDB = candidatoDAO.inserir(candidato)

        if (retornoDB) {
            println("\nCandidato cadastrada com sucesso!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }
    }

    static cadastrarCompetenciaCandidato(int candidato_id, int competencia_id) {

        boolean retornoDB
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        retornoDB = candidatoDAO.inserirCompetenciaCandidato(candidato_id, competencia_id)

        if (retornoDB) {
            println("Competência cadastrada com sucesso")
        } else {
            println("Erro no cadastro da nova competência")
        }
    }

    static alterarCandidato(Candidato candidato) {

        boolean retornoDB
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        retornoDB = candidatoDAO.alterar(candidato)

        if (retornoDB) {
            println("Candidato alterado com sucesso")
        } else {
            println("Erro na alteração no candidato (service: alterarCandidato)")
        }
    }

    static deletarCandidato(Integer id) {

        boolean retornoDB
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        retornoDB = candidatoDAO.remover(id)

        if (retornoDB) {
            println("Candidato deletado com sucesso")
        } else {
            println("Erro ao tentar deletar o candidato (service: deletarCandidato)")
        }
    }




    List<Candidato> candidatosCadastrados() {

        List<Candidato> candidatosList
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        candidatosList = candidatoDAO.listar()
        return candidatosList
    }

}
