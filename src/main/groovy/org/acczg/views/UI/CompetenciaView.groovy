package org.acczg.views.UI

import org.acczg.controller.CompetenciaController
import org.acczg.models.Competencia

class CompetenciaView {

    private Scanner ler = new Scanner(System.in)
    private CompetenciaController controllerCompetencia = new CompetenciaController()

    void listarCompetencias() {
        controllerCompetencia.listarCompetencias()
    }

    void cadastrarCompetencia() {
        println("Digite a nova competência:")
        String novaCompetencia = ler.nextLine()

        Competencia competencia = new Competencia()
        competencia.setCompetencia(novaCompetencia)

        controllerCompetencia.cadastrarCompetencia(competencia)
    }

    void alterarCompetencia() {
        controllerCompetencia.listarCompetencias()

        println "Escolha o código (id) da competência a ser alterada:"
        int id = Integer.parseInt(ler.nextLine())

        println("Digite a nova competência:")
        String novaCompetencia = ler.nextLine()

        Competencia competencia = new Competencia()
        competencia.setId(id)
        competencia.setCompetencia(novaCompetencia)

        controllerCompetencia.alterarCompetencia(competencia)
    }

    void deletarCompetencia() {
        controllerCompetencia.listarCompetencias()
        println "Escolha o id da competência a ser deletada:"
        int id = Integer.parseInt(ler.nextLine())
        controllerCompetencia.deletarCompetencia(id)
    }
}