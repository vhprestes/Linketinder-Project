package org.acczg.views.UI

import org.acczg.DAO.CompetenciaDAO
import org.acczg.controller.CandidatoController
import org.acczg.factory.EntityFactory
import org.acczg.models.Candidato
import org.acczg.utils.Estados

class CandidatoView {

    private Scanner ler = new Scanner(System.in)
    private CandidatoController controllerCandidato = new CandidatoController()

    void listarCandidatos() {
        controllerCandidato.listarCandidatos()
    }


    List<String> novoCandidato() {
        println("Digite o nome do candidato:")
        String nome = ler.nextLine()

        println("Digite o sobrenome do candidato:")
        String sobrenome = ler.nextLine()

        println("Digite o cpf do candidato:")
        String cpf = ler.nextLine()

        println("Digite a data de nascimento do candidato no formato dd/MM/yyyy:")
        String dataNascimento = ler.nextLine()

        println("Digite o email do candidato:")
        String email = ler.nextLine()

        println("Digite o cep do candidato:")
        String cep = ler.nextLine()

        println("Faça uma descrição do candidato:")
        String descricao = ler.nextLine()

        println("Selecione o país:\n1. Brasil")
        String pais = Integer.parseInt(ler.nextLine())

        println("Selecione o estado:")
        println(Estados.estados)
        String estado = Integer.parseInt(ler.nextLine())

        println("Digite uma senha:")
        String senha = ler.nextLine()

        return [nome, sobrenome, cpf, dataNascimento, email, cep, descricao, pais, estado, senha]

    }

    void cadastrarCandidato() {
        List<String> dados = novoCandidato()

        List<String> competencias = new ArrayList<>()
        println "Digite quantas competências o candidato possui:"
        int qtdCompetencias = Integer.parseInt(ler.nextLine())


        Candidato novoCandidato = EntityFactory.createCandidato(dados[0], dados[1], dados[2], dados[3], dados[4], dados[9], dados[7], dados[8], dados[5], dados[6], new ArrayList<>())

        for (int i = 0; i < qtdCompetencias; i++) {
            println "1. Utilizar competências cadastradas"
            println "2. Cadastrar nova competência"
            int opcao = Integer.parseInt(ler.nextLine())


            switch (opcao) {
                case 1:
                    controllerCandidato.listarCompetencias()
                    println "Selecione o id da competência ${i + 1}:"
                    int idCompetencia = Integer.parseInt(ler.nextLine())
                    controllerCandidato.cadastrarCompetenciaCandidato(novoCandidato.getId(), idCompetencia)
                    break
                case 2:
                    println "Digite a competência a ser cadastrada:"
                    String competencia = ler.nextLine()
                    controllerCandidato.cadastrarNovaCompetencia(novoCandidato.getId(), competencia)
                    break
                default:
                    println "Erro: opção inválida!"
            }
        }

        controllerCandidato.cadastrarCandidato(novoCandidato)

        for (String competencia : competencias) {
            controllerCandidato.cadastrarNovaCompetencia(novoCandidato.getId(), competencia)
        }
    }

    void alterarCandidato() {
        controllerCandidato.listarCandidatos()

        println("Escolha o código (id) do candidato a ser alterado:")
        int id = Integer.parseInt(ler.nextLine())
        List dados = novoCandidato()

        List<Integer> novasCompetencias = new ArrayList<>()
        println "Digite a quantidade de competências que o candidato terá:"
        int qtdCompetencias = Integer.parseInt(ler.nextLine())

        for (int i = 0; i < qtdCompetencias; i++) {
            println "1. Utilizar competências cadastradas"
            println "2. Cadastrar nova competência"
            int opcao = Integer.parseInt(ler.nextLine())

            switch (opcao) {
                case 1:
                    controllerCandidato.listarCompetencias()
                    println "Selecione o id da competência ${i + 1}:"
                    int idCompetencia = Integer.parseInt(ler.nextLine())
                    novasCompetencias.add(idCompetencia)
                    break
                case 2:
                    println "Digite a competência a ser cadastrada:"
                    String competencia = ler.nextLine()
                    controllerCandidato.cadastrarNovaCompetencia(id, competencia)
                    break
                default:
                    println "Erro: opção inválida!"
                    i-- // Decrementa o contador para repetir a iteração
            }
        }

        Candidato candidato = EntityFactory.createCandidato(dados[0], dados[1], dados[2], dados[3], dados[4], dados[9], dados[7], dados[8], dados[5], dados[6], new ArrayList<>())
        candidato.setId(id)
        controllerCandidato.alterarCandidato(candidato, novasCompetencias)
    }

    void deletarCandidato() {
        controllerCandidato.listarCandidatos()
        println "Escolha o id do candidato a ser deletado:"
        int id = Integer.parseInt(ler.nextLine())
        controllerCandidato.deletarCandidato(id)
    }
}