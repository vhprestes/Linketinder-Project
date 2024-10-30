package org.acczg.views.UI

import org.acczg.DAO.CompetenciaDAO
import org.acczg.DAO.EmpresaDAO
import org.acczg.DAO.VagaDAO
import org.acczg.controller.VagasController
import org.acczg.models.Competencia
import org.acczg.models.Vaga
import org.acczg.service.CompetenciaService
import org.acczg.service.EmpresaService
import org.acczg.service.VagaService

class VagaView {

    private Scanner ler = new Scanner(System.in)
    private VagasController controllerVaga = new VagasController()
    private EmpresaDAO empresaDAO = new EmpresaDAO()
    private CompetenciaDAO competenciaDAO = new CompetenciaDAO()
    private EmpresaService empresaService = new EmpresaService(empresaDAO)


    void listarVagas() {
        controllerVaga.listarVagas()
    }

    void cadastrarVaga() {
        CompetenciaService competenciaService = new CompetenciaService(competenciaDAO)
        VagaService vagaService = new VagaService(new VagaDAO())
        List<Competencia> competenciasDB
        Competencia novaCompetencia = new Competencia()
        int idCompetencia

        println "Digite o nome da vaga:"
        String nomeVaga = ler.nextLine()

        println "Faça a descrição da vaga:"
        String descricao = ler.nextLine()

        println "Digite a cidade da vaga:"
        String cidade = ler.nextLine()

        empresaService.listarEmpresas()
        println("Selecione o código(id) da empresa que ofertou a vaga:")
        int empresa = Integer.parseInt(ler.nextLine())

        Vaga novaVaga = new Vaga()
        novaVaga.setNome(nomeVaga)
        novaVaga.setDescricao(descricao)
        novaVaga.setCidade(cidade)
        novaVaga.setEmpresa(empresa.toString())

        controllerVaga.cadastrarVaga(novaVaga)

        println "Digite a quantidade de competências a vaga exigirá:"
        int qtdCompetencias = Integer.parseInt(ler.nextLine())

        List<Vaga> vagas = vagaService.obterVagasCadastradas()

        for (int i = 0; i < qtdCompetencias; i++) {
            competenciasDB = competenciaService.obterCompetenciasCadastradas()

            println "1. Utilizar competências cadastradas.\n" +
                    "2. Cadastrar nova competência"
            int opcao = Integer.parseInt(ler.nextLine())

            switch (opcao) {
                case 1:
                    competenciaService.listarCompetencias()
                    println "Selecione o id da competência ${i + 1}:"
                    idCompetencia = Integer.parseInt(ler.nextLine())
                    vagaService.cadastrarCompetenciaVaga(vagas[-1].getId(), idCompetencia)
                    break
                case 2:
                    println "Digite a competência:"
                    String competencia = ler.nextLine()
                    competencia.capitalize()
                    novaCompetencia.setCompetencia(competencia)
                    competenciaService.cadastrarCompetencia(novaCompetencia)
                    competenciasDB = competenciaService.obterCompetenciasCadastradas()
                    vagaService.cadastrarCompetenciaVaga(vagas[-1].getId(), competenciasDB[-1].getId())
                    break
                default:
                    println "Opção inválida!!!"
            }
        }
    }

    void alterarVaga() {
        controllerVaga.listarVagas()

        println("Escolha o id de qual vaga você deseja alterar:")
        int opcao = Integer.parseInt(ler.nextLine())

        println "Altere o nome da vaga:"
        String nomeVaga = ler.nextLine()

        println "Altere a descrição da vaga:"
        String descricao = ler.nextLine()

        println "Altere a cidade da vaga:"
        String cidade = ler.nextLine()

        EmpresaService.listarEmpresas()
        println("Altere a empresa que ofertou a vaga:")
        int empresa = Integer.parseInt(ler.nextLine())

        Vaga novaVaga = new Vaga()
        novaVaga.setId(opcao)
        novaVaga.setNome(nomeVaga)
        novaVaga.setDescricao(descricao)
        novaVaga.setCidade(cidade)
        novaVaga.setEmpresa(empresa.toString())

        println "Digite a quantidade de competências a vaga exigirá:"
        int qtdCompetencias = Integer.parseInt(ler.nextLine())

        List<Integer> novasCompetencias = new ArrayList<>()
        for (int i = 0; i < qtdCompetencias; i++) {
            println "1. Utilizar competências cadastradas"
            println "2. Cadastrar nova competência"
            int num = Integer.parseInt(ler.nextLine())

            switch (num) {
                case 1:
                    CompetenciaService.listarCompetencias()
                    println "Selecione o id da competência ${i + 1}:"
                    int idCompetencia = Integer.parseInt(ler.nextLine())
                    novasCompetencias.add(idCompetencia)
                    break
                case 2:
                    println "Digite a competência a ser cadastrada:"
                    CompetenciaService competenciaService = new CompetenciaService()
                    String competencia = ler.nextLine()
                    competencia.capitalize()
                    Competencia novaCompetencia = new Competencia()
                    novaCompetencia.setCompetencia(competencia)
                    competenciaService.cadastrarCompetencia(novaCompetencia)
                    List<Competencia> competenciasDB = competenciaService.obterCompetenciasCadastradas()
                    novasCompetencias.add(competenciasDB[-1].getId())
                    break
                default:
                    println "Erro: opção inválida!"
                    i--
            }
        }

        controllerVaga.alterarVaga(novaVaga, novasCompetencias)
    }

    void deletarVaga() {
        controllerVaga.listarVagas()
        println("Escolha o código(id) de qual vaga você deseja deletar:")
        int opcao = Integer.parseInt(ler.nextLine())
        controllerVaga.deletarVaga(opcao)
    }
}