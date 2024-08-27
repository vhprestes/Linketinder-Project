package org.acczg.utils

import org.acczg.entities.PessoaFisica

class CandidatoUtils {

    static void listarCandidatos(List<PessoaFisica> candidatos) {
        candidatos.each { candidato ->
            println "Nome: ${candidato.nome}"
            println "Email: ${candidato.email}"
            println "Descrição: ${candidato.descricao}"
            println "CEP: ${candidato.CEP}"
            println "Estado: ${candidato.estado}"
            println "Competências: ${candidato.competencias}"
            println "CPF: ${candidato.cpf}"
            println "Idade: ${candidato.idade}"
            println "---------------------------------"
        }
    }

    static PessoaFisica getInputs() {
        println "Digite o nome do candidato: "
        String nome = System.in.newReader().readLine()
        println "Digite o email do candidato: "
        String email = System.in.newReader().readLine()
        println "Digite a descrição do candidato: "
        String descricao = System.in.newReader().readLine()
        println "Digite o CEP do candidato: "
        String CEP = System.in.newReader().readLine()
        println "Digite o estado do candidato: "
        String estado = System.in.newReader().readLine()
        println "Digite as competências do candidato, separadas por virgula: "
        String competenciasInput = System.in.newReader().readLine()
        List<String> competencias = competenciasInput ? competenciasInput.split(",") : []
        println "Digite o CPF do candidato: "
        String cpf = System.in.newReader().readLine()
        println "Digite a idade do candidato: "
        String idadeInput = System.in.newReader().readLine()
        Integer idade = idadeInput ? idadeInput.toInteger() : 0
        PessoaFisica candidato = new PessoaFisica(nome: nome, email: email, descricao: descricao, CEP: CEP, estado: estado, competencias: competencias, cpf: cpf, idade: idade)
        return candidato
    }

    static void cadastroCandidatos(List<PessoaFisica> candidatos) {
        boolean cadastrarOutro = true
        while (cadastrarOutro) {
            PessoaFisica candidato = getInputs()
            addCandidato(candidatos, candidato)
            println "Deseja cadastrar outro candidato? (S/N)"
            String resposta = System.in.newReader().readLine()
            cadastrarOutro = resposta.toUpperCase() == "S"
        }
        println "Candidato(s) cadastrado(s) com sucesso! Voltando ao menu principal..."
    }

    static void addCandidato(List<PessoaFisica> candidatos, PessoaFisica candidato) {
        candidatos.add(candidato)
    }
}

