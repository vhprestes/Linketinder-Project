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

    List<Competencia> competenciasCadastradas() {

        List<Competencia> listaCompetencias
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()

        listaCompetencias = competenciaDAO.listar()
        return listaCompetencias

    }

    static cadastrarCompetencia(Competencia competencia) {

        boolean retornoDB

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        retornoDB = competenciaDAO.inserir(competencia)

        if (retornoDB){
            println("\nCompetência cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    static alterarCompetencia(Competencia competencia) {

        boolean retornoDB

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        retornoDB = competenciaDAO.alterar(competencia)

        if (retornoDB){
            println("\nCompetência alterada com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    static deletarCompetencia(Integer id) {

        boolean retornoDB

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        retornoDB = competenciaDAO.remover(id)

        if (retornoDB){
            println("\nCompetência deletada com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}
