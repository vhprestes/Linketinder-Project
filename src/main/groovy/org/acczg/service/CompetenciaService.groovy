package org.acczg.service

import org.acczg.DAO.CompetenciaDAO
import org.acczg.models.Competencia

class CompetenciaService {
    static listarCompetencias() {

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        competenciaDAO.listar().each { competencia ->
            println competencia
        }
    }

    static cadastrarCompetencia(Competencia competencia) {

        boolean retornoDB

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        retornoDB = competenciaDAO.inserir(competencia)

        if (retornoDB) {
            println "Competencia cadastrada com sucesso"
        } else {
            println "Erro no cadastro"
        }
    }

    static alterarCompetencia(Competencia competencia) {

        boolean retornoDB

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        retornoDB = competenciaDAO.alterar(competencia)

        if (retornoDB) {
            println "Competência alterada com sucesso"
        } else {
            println "Erro na alteração"
        }
    }

    static deletarCompetencia(Integer id) {

        boolean retornoDB

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        retornoDB = competenciaDAO.remover(id)

        if (retornoDB) {
            println "Competência deletada com sucesso"
        } else {
            println "Erro ao tentar deletar a competência"
        }

    }

    List<Competencia> competenciasCadastradas() {

        List<Competencia> listaCompetencias
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()

        listaCompetencias = competenciaDAO.listar()
        return listaCompetencias

    }

}
