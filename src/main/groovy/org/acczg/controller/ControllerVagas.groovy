package org.acczg.controller

import org.acczg.models.Competencia
import org.acczg.models.Vaga
import org.acczg.service.CompetenciaService
import org.acczg.service.EmpresaService
import org.acczg.service.VagaService

class ControllerVagas {
    private Vaga novaVaga = new Vaga()
    private String nomeVaga
    private String descricao
    private String cidade
    private String empresa
    private int qtdCompetencias


    int opcao
    Scanner ler = new Scanner(System.in)

    void listarVagas() {
        VagaService.listarVagas()
    }

    void cadastrarVaga() {

        CompetenciaService competenciaService = new CompetenciaService()
        VagaService vagaService = new VagaService()
        List<Competencia> competenciasDB
        Competencia novaCompetencia = new Competencia()
        int idCompetencia

        println "Digite o nome da vaga:"
        this.nomeVaga = ler.nextLine()

        println "Faça a descrição da vaga:"
        this.descricao = ler.nextLine()

        println "Digite a cidade da vaga:"
        this.cidade = ler.nextLine()

        EmpresaService.listarEmpresas()
        println("Selecione o código(id) da empresa que ofertou a vaga:")
        this.empresa = Integer.parseInt(ler.nextLine())

        this.novaVaga.setNome(this.nomeVaga)
        this.novaVaga.setDescricao(this.descricao)
        this.novaVaga.setCidade(this.cidade)
        this.novaVaga.setEmpresa(this.empresa)

        VagaService.cadastrarVaga(this.novaVaga)

        println "Digite a quantidade de competências a vaga exigirá:"
        this.qtdCompetencias = Integer.parseInt(ler.nextLine());

        List<Vaga> vagas = vagaService.obterVagasCadastradas()

        for (int i = 0; i < qtdCompetencias; i++) {
            competenciasDB = competenciaService.obterCompetenciasCadastradas()

            println "1. Utilizar competências cadastradas.\n" +
                    "2. Cadastrar nova competência"
            this.opcao = Integer.parseInt(ler.nextLine())

            switch (opcao) {
                case 1:
                    competenciaService.listarCompetencias()
                    println "Selecione o id da competência ${i + 1}:"
                    idCompetencia = Integer.parseInt(ler.nextLine())
                    VagaService.cadastrarCompetenciaVaga(vagas[-1].getId(), idCompetencia)
                    break
                case 2:
                    println "Digite a competência:"
                    String competencia = ler.nextLine()
                    competencia.capitalize()
                    novaCompetencia.setCompetencia(competencia)
                    competenciaService.cadastrarCompetencia(novaCompetencia)
                    competenciasDB = competenciaService.obterCompetenciasCadastradas()
                    VagaService.cadastrarCompetenciaVaga(vagas[-1].getId(), competenciasDB[-1].getId())
                    break
                default:
                    println "Opção inválida!!!"

            }
        }
    }

    void alterarVaga() {

        VagaService.listarVagas()

        println("Escolha qual vaga você deseja alterar:")
        this.opcao = Integer.parseInt(ler.nextLine())

        println "Altere o nome da vaga:"
        this.nomeVaga = ler.nextLine()

        println "Altere a descrição da vaga:"
        this.descricao = ler.nextLine()

        println "Altere a cidade da vaga:"
        this.cidade = ler.nextLine()

        EmpresaService.listarEmpresas()
        println("Altere a empresa que ofertou a vaga:")
        this.empresa = Integer.parseInt(ler.nextLine())

        this.novaVaga.setId(opcao)
        this.novaVaga.setNome(this.nomeVaga)
        this.novaVaga.setDescricao(this.descricao)
        this.novaVaga.setCidade(this.cidade)
        this.novaVaga.setEmpresa(this.empresa)

        VagaService.alterarVaga(this.novaVaga)

    }

    void deletarVaga() {

        VagaService.listarVagas()

        println("Escolha o código(id) de qual vaga você deseja deletar:")
        this.opcao = Integer.parseInt(ler.nextLine())

        VagaService.deletarVaga(this.opcao)

    }


}
