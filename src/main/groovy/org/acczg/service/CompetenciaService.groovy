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
        try {
            competenciaDAO.inserir(competencia)
            println "Competência cadastrada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro no cadastro de competência" + e.getMessage(), e )
        }
    }

    static void alterarCompetencia(Competencia competencia) {
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()

        try {
            competenciaDAO.alterar(competencia)
            println "Competência alterada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro na alteração de competência" + e.getMessage(), e )
        }
    }

    static void deletarCompetencia(Integer id) {
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        try {
            competenciaDAO.remover(id)
            println "Competência deletada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro ao deletar competência" + e.getMessage(), e )

        }
    }
}