package org.acczg.service

import org.acczg.DAO.VagaDAO
import org.acczg.models.Vaga

class VagaService {

    private VagaDAO vagaDAO

    VagaService(VagaDAO vagaDAO) {
        this.vagaDAO = vagaDAO
    }


    void listarVagas() {
        vagaDAO.listar().each { vaga ->
            println vaga.toString()
        }
    }

    List<Vaga> obterVagasCadastradas() {
        return vagaDAO.listar()
    }

    void cadastrarVaga(Vaga vaga) {
        try {
            vagaDAO.inserir(vaga)
            println "Vaga cadastrada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro no cadastro de vaga" + e.getMessage(), e)
        }
    }

    void cadastrarCompetenciaVaga(int vagaId, int competenciaId) {
        try {
            vagaDAO.inserirCompetenciaVaga(vagaId, competenciaId)
            println "Competência cadastrada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro no cadastro de vaga" + e.getMessage(), e)
        }
    }

    void alterarVaga(Vaga vaga, List<Integer> novasCompetencias) {
        try {
            vagaDAO.alterar(vaga, novasCompetencias)
            println "Vaga alterada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro na alteração de vaga" + e.getMessage(), e)
        }
    }

    void deletarVaga(Integer id) {
        try {
            vagaDAO.remover(id)
            println "Vaga deletada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro ao deletar vaga" + e.getMessage(), e)
        }
    }
}
