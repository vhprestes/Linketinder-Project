package org.acczg.utils

import org.acczg.entities.PessoaJuridica
import spock.lang.Specification

class EmpresaUtilsTest extends Specification {

    def "test listarEmpresas"() {
        given:
        List<PessoaJuridica> empresas = [
                new PessoaJuridica(nome: "Mil grau", email: "mg@mg.com", descricao: "Empresa de TI", CEP: "16600000", estado: "SP", competencias: ["Java", "Groovy"], cnpj: "12345678900", pais: "Brasil")]
        when:
        EmpresaUtils.listarEmpresas(empresas)
        then:
        empresas.size() == 1
        empresas[0].nome == "Mil grau"
        empresas[0].email == "mg@mg.com";
        empresas[0].descricao == "Empresa de TI";
        empresas[0].CEP == "16600000";
        empresas[0].estado == "SP";
        empresas[0].competencias == ["Java", "Groovy"];
        empresas[0].cnpj == "12345678900";
        empresas[0].pais == "Brasil";}


    def testCadastroEmpresas() {
        given:
        List<PessoaJuridica> empresas = []
        def expectedInputs = [
                "Mil grau",
                "mil@grau.com",
                "Empresa de TI",
                "16600000",
                "SP",
                "Java,Groovy",
                "12345678900",
                "Brasil"
        ]
        def inputStream = new ByteArrayInputStream(expectedInputs.join("\n").getBytes())
        System.setIn(inputStream) // Set simulated input stream

        when:
        EmpresaUtils.cadastroEmpresas(empresas)

        then:
        empresas.size() == 1
        empresas[0].nome == expectedInputs[0]
        empresas[0].email == expectedInputs[1]
        empresas[0].descricao == expectedInputs[2]
        empresas[0].CEP == expectedInputs[3]
        empresas[0].estado == expectedInputs[4]
        empresas[0].competencias == ["Java", "Groovy"]
        empresas[0].cnpj == expectedInputs[6]
        empresas[0].pais == expectedInputs[7]


    }

    def testCadastroEmpresasError() {
        given:
        List<PessoaJuridica> empresas = []
        def expectedInputs = [
                "Mil grau"]
        def inputStream = new ByteArrayInputStream(expectedInputs.join("\n").getBytes())
        System.setIn(inputStream) // Set simulated input stream

        when:
        EmpresaUtils.cadastroEmpresas(empresas)

        then:
//        expect NoSuchElementException
        empresas.size() == 0
    }

}