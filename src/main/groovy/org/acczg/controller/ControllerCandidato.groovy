package org.acczg.controller

import org.acczg.models.Candidato
import org.acczg.models.Competencia
import org.acczg.service.CandidatoService
import org.acczg.service.CompetenciaService
import org.acczg.utils.Estados

class ControllerCandidato {

    private Candidato novoCandidato = new Candidato()
    private String nomeCandidato
    private String sobreNomeCandidato
    private String cpf
    private String dataNascimento
    private String email
    private String cep
    private String descricao
    private String senha
    private String pais
    private String estado
    private int qtdCompetencias


    int opcao
    Scanner ler = new Scanner(System.in)


    static void listarCandidatos(){
        CandidatoService.listarCandidatos()
    }

    void cadastrarCandidato(){


        CompetenciaService competenciaService = new CompetenciaService()
        CandidatoService candidatoService = new CandidatoService()
        List<Competencia> competenciasDB
        Competencia novaCompetencia = new Competencia()
        int idCompetencia

        println("Digite o nome do candidato:")
        this.nomeCandidato = ler.nextLine()

        println("Digite o sobrenome do candidato:")
        this.sobreNomeCandidato = ler.nextLine()

        println("Digite o cpf do candidato:")
        this.cpf = ler.nextLine()

        println("Digite a data de nascimento do candidato no formato dd/mm/aaaa:")
        this.dataNascimento = ler.nextLine()

        println("Digite o email do candidato:")
        this.email = ler.nextLine()

        println("Digite o cep do candidato:")
        this.cep = ler.nextLine()

        println("Faça uma descrição do candidato:")
        this.descricao = ler.nextLine()

        println("Selecione o pais:\n1. Brasil")
        this.pais = Integer.parseInt(ler.nextLine())

        println("Selecione o estado:")
        println(Estados.estados)
        this.estado = Integer.parseInt(ler.nextLine())

        println("Digite uma senha:")
        this.senha = ler.nextLine()

        this.novoCandidato.setNome(this.nomeCandidato)
        this.novoCandidato.setSobrenome(this.sobreNomeCandidato)
        this.novoCandidato.setCpf(this.cpf)
        this.novoCandidato.setDataNascimento(this.dataNascimento)
        this.novoCandidato.setEmail(this.email)
        this.novoCandidato.setCep(this.cep)
        this.novoCandidato.setDescricao(this.descricao)
        this.novoCandidato.setPais(this.pais)
        this.novoCandidato.setEstado(this.estado)
        this.novoCandidato.setSenha(this.senha)

        CandidatoService.cadastrarCandidato(this.novoCandidato)

        Scanner ler = new Scanner(System.in)

        println "Digite quantas competências o candidato possuí:"
        this.qtdCompetencias = Integer.parseInt(ler.nextLine())

        List<Candidato> candidatos = candidatoService.obterCandidatosCadastrados()

        for (int i = 0; i < qtdCompetencias; i++){

            competenciasDB = competenciaService.obterCompetenciasCadastradas()

            println "1. Utilizar competências cadastradas"
            println "2. Cadastrar nova competência"
            this.opcao = Integer.parseInt(ler.nextLine())

            switch (opcao){
                case 1:
                    competenciaService.listarCompetencias()
                    println "Selecione o id da competência ${i+1}:"
                    idCompetencia = Integer.parseInt(ler.nextLine())
                    CandidatoService.cadastrarCompetenciaCandidato(candidatos[-1].getId(), idCompetencia)
                    break
                case 2:
                    println "Digite a competência a ser cadastrada:"
                    String competencia = ler.nextLine()
                    competencia.capitalize()
                    novaCompetencia.setCompetencia(competencia)
                    competenciaService.cadastrarCompetencia(novaCompetencia)
                    competenciasDB = competenciaService.obterCompetenciasCadastradas()
//                  LAST ID
                    CandidatoService.cadastrarCompetenciaCandidato(candidatos[-1].getId(), competenciasDB[-1].getId())
                    break
                default:
                    println "Erro: opção inválida!"
            }
        }

    }

    void alterarCandidato() {
        CandidatoService.listarCandidatos()

        println ("Escolha o código (id) do candidato a ser alterado:")
        this.opcao = Integer.parseInt(ler.nextLine())

        println("Altere o nome do candidato:")
        this.nomeCandidato = ler.nextLine()

        println("Altere o sobrenome do candidato:")
        this.sobreNomeCandidato = ler.nextLine()

        println("Altere o cpf do candidato:")
        this.cpf = ler.nextLine()

        println("Altere a data de nascimento do candidato no formato dd/mm/aaaa:")
        this.dataNascimento = ler.nextLine()

        println("Altere o email do candidato:")
        this.email = ler.nextLine()

        println("Altere o cep do candidato:")
        this.cep = ler.nextLine()

        println("Altere a descrição do candidato:")
        this.descricao = ler.nextLine()

        println("Altere o pais:")
        println("1. Brasil")
        this.pais = Integer.parseInt(ler.nextLine())

        println("Altere o estado. Para isso, digite o código referente ao Estado novo:")
        println(Estados.estados)
        this.estado = Integer.parseInt(ler.nextLine())

        println("Altere a senha:")
        this.senha = ler.nextLine()

        this.novoCandidato.setId(this.opcao)
        this.novoCandidato.setNome(this.nomeCandidato)
        this.novoCandidato.setSobrenome(this.sobreNomeCandidato)
        this.novoCandidato.setCpf(this.cpf)
        this.novoCandidato.setDataNascimento(this.dataNascimento)
        this.novoCandidato.setEmail(this.email)
        this.novoCandidato.setCep(this.cep)
        this.novoCandidato.setDescricao(this.descricao)
        this.novoCandidato.setPais(this.pais)
        this.novoCandidato.setEstado(this.estado)
        this.novoCandidato.setSenha(this.senha)

        println "Digite a quantidade de competências que o candidato terá:"
        Integer qtdCompetencias = Integer.parseInt(ler.nextLine())

        List<Integer> novasCompetencias = new ArrayList<>()
        for (int i = 0; i < qtdCompetencias; i++) {
            println "1. Utilizar competências cadastradas"
            println "2. Cadastrar nova competência"
            int num = Integer.parseInt(ler.nextLine())

            switch (num) {
                case 1:
                    CompetenciaService competenciaService = new CompetenciaService()
                    competenciaService.listarCompetencias()
                    println "Selecione o id da competência ${i + 1}:"
                    Integer idCompetencia = Integer.parseInt(ler.nextLine())
                    novasCompetencias.add(idCompetencia)
                    break
                case 2:
                    CompetenciaService competenciaService = new CompetenciaService()
                    println "Digite a competência a ser cadastrada:"
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
                    i-- // Decrementa o contador para repetir a iteração
            }
        }

        CandidatoService.alterarCandidato(novoCandidato, novasCompetencias)
    }

    void deletarCandidato(){

        CandidatoService.listarCandidatos()
        println "Escolha o id do candidato a ser deletado:"
        this.opcao = Integer.parseInt(ler.nextLine())

        CandidatoService.deletarCandidato(this.opcao)
    }
}
