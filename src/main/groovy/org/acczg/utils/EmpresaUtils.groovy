package org.acczg.utils

import org.acczg.entities.PessoaJuridica

class EmpresaUtils {

    static void listarEmpresas(List<PessoaJuridica> empresas) {
        empresas.each { empresa ->
            println "Nome: ${empresa.nome}"
            println "Email: ${empresa.email}"
            println "Descrição: ${empresa.descricao}"
            println "CEP: ${empresa.CEP}"
            println "Estado: ${empresa.estado}"
            println "Competências: ${empresa.competencias}"
            println "CNPJ: ${empresa.cnpj}"
            println "País: ${empresa.pais}"
            println "---------------------------------"
        }
    }

    static void cadastroEmpresas(List<PessoaJuridica> empresas) {
        println "Digite o nome da empresa: "
        String nome = System.in.newReader().readLine()
        println "Digite o email da empresa: "
        String email = System.in.newReader().readLine()
        println "Digite a descrição da empresa: "
        String descricao = System.in.newReader().readLine()
        println "Digite o CEP da empresa: "
        String CEP = System.in.newReader().readLine()
        println "Digite o estado da empresa: "
        String estado = System.in.newReader().readLine()
        println "Digite as competências da empresa, separadas por virgula: "
        List<String> competencias = System.in.newReader().readLine().split(",")
        println "Digite o CNPJ da empresa: "
        String cnpj = System.in.newReader().readLine()
        println "Digite o país da empresa: "
        String pais = System.in.newReader().readLine()

        PessoaJuridica empresa = new PessoaJuridica(nome:nome, email:email, descricao:descricao, CEP:CEP, estado:estado, competencias:competencias, cnpj:cnpj, pais:pais)
        empresas.add(empresa)
        println "Deseja cadastrar outra empresa? (S/N)"
        String resposta = System.in.newReader().readLine()
        if (resposta == "S") {
            cadastroEmpresas(empresas)
        } else {
            println "Empresa cadastrada com sucesso! Voltando ao menu principal..."
        }
    }
}