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
        try {
        def scanner = new Scanner(System.in)
        println "Digite o nome do candidato: "
        String nome = scanner.nextLine()
        println "Digite o email do candidato: "
        String email = scanner.nextLine()
        println "Digite a descrição do candidato: "
        String descricao = scanner.nextLine()
        println "Digite o CEP do candidato: "
        String CEP = scanner.nextLine()
        println "Digite o estado do candidato: "
        String estado = scanner.nextLine()
        println "Digite as competências do candidato, separadas por virgula: "
        String competenciasInput = scanner.nextLine()
        List<String> competencias = competenciasInput ? competenciasInput.split(",") : []
        println "Digite o CPF do candidato: "
        String cpf = scanner.nextLine()
        println "Digite a idade do candidato: "
        String idadeInput = scanner.nextLine()
        Integer idade = idadeInput?.toInteger() ?: 0 // Convert to Integer OR default is 0
        return new PessoaFisica(nome: nome, email: email, descricao: descricao, CEP: CEP, estado: estado, competencias: competencias, cpf: cpf, idade: idade)
        } catch (Exception e) {
            println "Erro ao obter inputs do usuário: ${e.message}"
            return null
        }
    }

    static void cadastroCandidatos(List<PessoaFisica> candidatos) {
        PessoaFisica candidato = getInputs()
        addCandidato(candidatos, candidato)
        println "Candidato(s) cadastrado(s) com sucesso! Voltando ao menu principal..."
    }

    static void addCandidato(List<PessoaFisica> candidatos, PessoaFisica candidato) {
        candidatos.add(candidato)
    }
}

