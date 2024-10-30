package org.acczg.controller

import org.acczg.models.Competencia
import org.acczg.service.CompetenciaService


class CompetenciaController {

    Competencia competencia = new Competencia()
    String novaCompetencia = ""

    int opcao
    Scanner ler = new Scanner(System.in)

    void listarCompetencias() {
        CompetenciaService.listarCompetencias()
    }


    void cadastrarCompetencia() {

        println("Digite a nova competência:")
        this.novaCompetencia = ler.nextLine()

        this.competencia.setCompetencia(this.novaCompetencia)
        CompetenciaService.cadastrarCompetencia(this.competencia)

    }

    void alterarCompetencia() {

        CompetenciaService.listarCompetencias()

        println "Escolha o código(id) da competência que deseja alterar:"
        this.opcao = Integer.parseInt(ler.nextLine())

        println("Digite a nova competência:")
        this.novaCompetencia = ler.nextLine()

        this.competencia.setId(this.opcao)
        this.competencia.setCompetencia(this.novaCompetencia)
        CompetenciaService.alterarCompetencia(this.competencia)

    }

    void deletarCompetencia() {

        CompetenciaService.listarCompetencias()

        println("Escolha o código(id) da competência que deseja excluir:")
        this.opcao = Integer.parseInt(ler.nextLine())
        CompetenciaService.deletarCompetencia(this.opcao)
    }
}
