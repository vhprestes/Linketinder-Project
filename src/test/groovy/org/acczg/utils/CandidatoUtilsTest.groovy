package org.acczg.utils

import org.acczg.entities.PessoaFisica
import spock.lang.Specification

class CandidatoUtilsTest extends Specification {

    def "test listarCandidatos"() {
        given:
        List<PessoaFisica> candidatos = [
                new PessoaFisica(nome: "João", email: "joao@email.com", descricao: "Desenvolvedor", CEP: "16600000", estado: "SP", competencias: ["Java", "Groovy"], cpf: "12345678900", idade: 30)
        ]
        when:
        CandidatoUtils.listarCandidatos(candidatos)
        then:
        candidatos.size() == 1
        candidatos[0].nome == "João"
        candidatos[0].email == "joao@email.com";
        candidatos[0].descricao == "Desenvolvedor";
        candidatos[0].CEP == "16600000";
        candidatos[0].estado == "SP";
        candidatos[0].competencias == ["Java", "Groovy"];
        candidatos[0].cpf == "12345678900";
        candidatos[0].idade == 30;
    }

    def "test addCandidato"() {
        given:
        List<PessoaFisica> candidatos = []
        PessoaFisica newCandidato = new PessoaFisica(nome: "João", email: "joao@email.com", descricao: "Desenvolvedor", CEP: "16600000", estado: "SP", competencias: ["Java", "Groovy"], cpf: "12345678900", idade: 30)
        when:
        CandidatoUtils.addCandidato(candidatos, newCandidato)
        then:
        candidatos.size() == 1
    }


    def "test getInputs do usuário"() {
        given:
        def expectedInputs = [
                "João",
                "joao@email.com",
                "Desenvolvedor",
                "16600000",
                "SP",
                "Java,Groovy",
                "12345678900",
                "30"
        ]
        def inputStream = new ByteArrayInputStream(expectedInputs.join("\n").getBytes())
        System.setIn(inputStream) // Set simulated input stream

        when:
        def candidato = CandidatoUtils.getInputs()

        then:
        candidato.nome == expectedInputs[0]
        candidato.email == expectedInputs[1]
        candidato.descricao == expectedInputs[2]
        candidato.CEP == expectedInputs[3]
        candidato.estado == expectedInputs[4]
        candidato.competencias == expectedInputs[5].split(",")
        candidato.cpf == expectedInputs[6]
        candidato.idade == expectedInputs[7].toInteger()

    }


    def "testar cadastro de candidato"() {
        given:
        def candidatos = []
        def inputStream = new ByteArrayInputStream(
                "João\njoao@email.com\nDesenvolvedor\n16600000\nSP\nJava,Groovy\n121\n30".getBytes()
        )
        System.setIn(inputStream)

        when:
        CandidatoUtils.cadastroCandidatos(candidatos)

        then:
        candidatos.size() == 1
        candidatos[0].nome == "João"
        candidatos[0].email == "joao@email.com"
        candidatos[0].descricao == "Desenvolvedor"
    }

    def "testar se da erro quando cadastra sem dados corretos"() {
        given:
        def candidatos = []
        def inputStream = new ByteArrayInputStream("João\n".getBytes())
        System.setIn(inputStream)

        when:
        def res = CandidatoUtils.cadastroCandidatos(candidatos)

        then:
        res == null
    }


}