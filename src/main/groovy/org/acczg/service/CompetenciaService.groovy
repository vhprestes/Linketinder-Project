package org.acczg.service

import org.acczg.DAO.CompetenciaDAO
import org.acczg.models.Competencia

class CompetenciaService {

    private CompetenciaDAO competenciaDAO

    CompetenciaService(CompetenciaDAO competenciaDAO) {
        this.competenciaDAO = competenciaDAO
    }

    void listarCompetencias() {
        competenciaDAO.listar().each { competencia ->
            println competencia.toString()
        }
    }

    List<Competencia> obterCompetenciasCadastradas() {
        return competenciaDAO.listar()
    }

    void cadastrarCompetencia(Competencia competencia) {
        try {
            competenciaDAO.inserir(competencia)
            println "Competência cadastrada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro no cadastro de competência" + e.getMessage(), e )
        }
    }

    void alterarCompetencia(Competencia competencia) {
        try {
            competenciaDAO.alterar(competencia)
            println "Competência alterada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro na alteração de competência" + e.getMessage(), e )
        }
    }

    void deletarCompetencia(Integer id) {
        try {
            competenciaDAO.remover(id)
            println "Competência deletada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro ao deletar competência" + e.getMessage(), e )

        }
    }
}