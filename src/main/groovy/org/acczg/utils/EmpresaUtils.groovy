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
        try {
        def scanner = new Scanner(System.in)
        println "Digite o nome da empresa: "
        String nome = scanner.nextLine()
        println "Digite o email da empresa: "
        String email = scanner.nextLine()
        println "Digite a descrição da empresa: "
        String descricao = scanner.nextLine()
        println "Digite o CEP da empresa: "
        String CEP = scanner.nextLine()
        println "Digite o estado da empresa: "
        String estado = scanner.nextLine()
        println "Digite as competências da empresa, separadas por virgula: "
        String competenciasInput = scanner.nextLine()
        List<String> competencias = competenciasInput ? competenciasInput.split(",") : []
        println "Digite o CNPJ da empresa: "
        String cnpj = scanner.nextLine()
        println "Digite o país da empresa: "
        String pais = scanner.nextLine()

        PessoaJuridica empresa = new PessoaJuridica(nome:nome, email:email, descricao:descricao, CEP:CEP, estado:estado, competencias:competencias, cnpj:cnpj, pais:pais)
        empresas.add(empresa)
        println "Empresa cadastrada com sucesso! Voltando ao menu principal..."
        } catch (Exception e) {
            println "Erro ao cadastrar empresa: ${e.message}"
        }
    }
}