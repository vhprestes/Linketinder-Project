package org.acczg.views.UI

import org.acczg.controller.CandidatoController
import org.acczg.models.Candidato
import org.acczg.utils.Estados

class CandidatoView {

    private Scanner ler = new Scanner(System.in)
    private CandidatoController controllerCandidato = new CandidatoController()

    void listarCandidatos() {
        controllerCandidato.listarCandidatos()
    }

    void cadastrarCandidato() {
        Candidato novoCandidato = new Candidato()

        println("Digite o nome do candidato:")
        novoCandidato.setNome(ler.nextLine())

        println("Digite o sobrenome do candidato:")
        novoCandidato.setSobrenome(ler.nextLine())

        println("Digite o cpf do candidato:")
        novoCandidato.setCpf(ler.nextLine())

        println("Digite a data de nascimento do candidato no formato dd/MM/yyyy:")
        novoCandidato.setDataNascimento(ler.nextLine())

        println("Digite o email do candidato:")
        novoCandidato.setEmail(ler.nextLine())

        println("Digite o cep do candidato:")
        novoCandidato.setCep(ler.nextLine())

        println("Faça uma descrição do candidato:")
        novoCandidato.setDescricao(ler.nextLine())

        println("Selecione o país:\n1. Brasil")
        novoCandidato.setPais(Integer.parseInt(ler.nextLine()))

        println("Selecione o estado:")
        println(Estados.estados)
        novoCandidato.setEstado(Integer.parseInt(ler.nextLine()))

        println("Digite uma senha:")
        novoCandidato.setSenha(ler.nextLine())

        controllerCandidato.cadastrarCandidato(novoCandidato)

        println "Digite quantas competências o candidato possui:"
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
    }

    void alterarCandidato() {
        controllerCandidato.listarCandidatos()

        println("Escolha o código (id) do candidato a ser alterado:")
        int id = Integer.parseInt(ler.nextLine())

        Candidato candidato = new Candidato()
        candidato.setId(id)

        println("Altere o nome do candidato:")
        candidato.setNome(ler.nextLine())

        println("Altere o sobrenome do candidato:")
        candidato.setSobrenome(ler.nextLine())

        println("Altere o cpf do candidato:")
        candidato.setCpf(ler.nextLine())

        println("Altere a data de nascimento do candidato no formato dd/MM/yyyy:")
        candidato.setDataNascimento(ler.nextLine())

        println("Altere o email do candidato:")
        candidato.setEmail(ler.nextLine())

        println("Altere o cep do candidato:")
        candidato.setCep(ler.nextLine())

        println("Altere a descrição do candidato:")
        candidato.setDescricao(ler.nextLine())

        println("Altere o país:\n1. Brasil")
        candidato.setPais(Integer.parseInt(ler.nextLine()))

        println("Altere o estado:")
        println(Estados.estados)
        candidato.setEstado(Integer.parseInt(ler.nextLine()))

        println("Altere a senha:")
        candidato.setSenha(ler.nextLine())

        println "Digite a quantidade de competências que o candidato terá:"
        int qtdCompetencias = Integer.parseInt(ler.nextLine())

        List<Integer> novasCompetencias = new ArrayList<>()
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
                    controllerCandidato.cadastrarNovaCompetencia(candidato.getId(), competencia)
                    break
                default:
                    println "Erro: opção inválida!"
                    i-- // Decrementa o contador para repetir a iteração
            }
        }

        controllerCandidato.alterarCandidato(candidato, novasCompetencias)
    }

    void deletarCandidato() {
        controllerCandidato.listarCandidatos()
        println "Escolha o id do candidato a ser deletado:"
        int id = Integer.parseInt(ler.nextLine())
        controllerCandidato.deletarCandidato(id)
    }
}