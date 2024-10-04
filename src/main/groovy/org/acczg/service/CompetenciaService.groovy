package org.acczg.service

import org.acczg.DAO.CompetenciaDAO
import org.acczg.models.Competencia

class CompetenciaService {

    static void listarCompetencias() {
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        competenciaDAO.listar().each { competencia ->
            println competencia.toString()
        }
    }

    List<Competencia> obterCompetenciasCadastradas() {
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        return competenciaDAO.listar()
    }

    static void cadastrarCompetencia(Competencia competencia) {
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        boolean sucesso = competenciaDAO.inserir(competencia)

        if (sucesso) {
            println "Competência cadastrada com sucesso"
        } else {
            println "Erro no cadastro de competência"
        }
    }

    static void alterarCompetencia(Competencia competencia) {
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        boolean sucesso = competenciaDAO.alterar(competencia)

        if (sucesso) {
            println "Competência alterada com sucesso"
        } else {
            println "Erro na alteração de competência"
        }
    }

    static void deletarCompetencia(Integer id) {
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        boolean sucesso = competenciaDAO.remover(id)

        if (sucesso) {
            println "Competência deletada com sucesso"
        } else {
            println "Erro ao deletar competência"
        }
    }
}