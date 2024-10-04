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
        boolean sucesso = vagaDAO.inserir(vaga)

        if (sucesso) {
            println "Vaga cadastrada com sucesso"
        } else {
            println "Erro no cadastro de vaga"
        }
    }

    static void cadastrarCompetenciaVaga(int vagaId, int competenciaId) {
        VagaDAO vagaDAO = new VagaDAO()
        boolean sucesso = vagaDAO.inserirCompetenciaVaga(vagaId, competenciaId)

        if (sucesso) {
            println "Competência cadastrada com sucesso"
        } else {
            println "Erro no cadastro de vaga"
        }
    }

    static boolean alterarVaga(Vaga vaga, List<Integer> novasCompetencias) {
        VagaDAO vagaDAO = new VagaDAO()
        boolean sucesso = vagaDAO.alterar(vaga, novasCompetencias)

        if (sucesso) {
            println "Vaga alterada com sucesso"
        } else {
            println "Erro na alteração de vaga"
        }
    }

    static void deletarVaga(Integer id) {
        VagaDAO vagaDAO = new VagaDAO()
        boolean sucesso = vagaDAO.remover(id)

        if (sucesso) {
            println "Vaga deletada com sucesso"
        } else {
            println "Erro ao deletar vaga"
        }
    }
}