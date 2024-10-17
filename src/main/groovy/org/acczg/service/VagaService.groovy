package org.acczg.service

import org.acczg.DAO.VagaDAO
import org.acczg.models.Vaga

class VagaService {

    static void listarVagas() {
        VagaDAO vagaDAO = new VagaDAO()
        vagaDAO.listar().each { vaga ->
            println vaga.toString()
        }
    }

    List<Vaga> obterVagasCadastradas() {
        VagaDAO vagaDAO = new VagaDAO()
        return vagaDAO.listar()
    }

    static void cadastrarVaga(Vaga vaga) {
        VagaDAO vagaDAO = new VagaDAO()

        try {
            vagaDAO.inserir(vaga)
            println "Vaga cadastrada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro no cadastro de vaga" + e.getMessage(), e)
        }
    }

    static void cadastrarCompetenciaVaga(int vagaId, int competenciaId) {
        VagaDAO vagaDAO = new VagaDAO()

        try {
            vagaDAO.inserirCompetenciaVaga(vagaId, competenciaId)
            println "Competência cadastrada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro no cadastro de vaga" + e.getMessage(), e)
        }
    }

    static void alterarVaga(Vaga vaga, List<Integer> novasCompetencias) {
        VagaDAO vagaDAO = new VagaDAO()

        try {
            vagaDAO.alterar(vaga, novasCompetencias)
            println "Vaga alterada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro na alteração de vaga" + e.getMessage(), e)
        }
    }

    static void deletarVaga(Integer id) {
        VagaDAO vagaDAO = new VagaDAO()

        try {
            vagaDAO.remover(id)
            println "Vaga deletada com sucesso"
        } catch (Exception e) {
            throw new Exception("Erro ao deletar vaga" + e.getMessage(), e)
        }
    }
}
