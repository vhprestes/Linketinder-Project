package org.acczg

import org.acczg.entities.PessoaFisica
import org.acczg.entities.PessoaJuridica

static void main(String[] args) {


    List<PessoaFisica> candidatos = []
    PessoaFisica pessoaFisica = new PessoaFisica(nome:"João", email:"joao@email.com", descricao:"Desenvolvedor", CEP:"16600000", estado:"SP", competencias:["Java", "Groovy"], cpf:"12345678900", idade:30)
    candidatos.add(pessoaFisica)
    PessoaFisica pessoaFisica2 = new PessoaFisica(nome:"Elis", email:"elis@elis.com", descricao:"Analista de Sistemas", CEP:"54321000", estado:"RJ", competencias:["Java", "C"], cpf:"09876543211", idade:28)
    candidatos.add(pessoaFisica2)
    PessoaFisica pessoaFisica3 = new PessoaFisica(nome:"Victor", email:"victor@lindo.com", descricao:"Desenvolvedor", CEP:"26600000", estado:"RJ", competencias:["Javascript", "Java", "Groovy", "C#", "Python"], cpf:"11223344556", idade:35)
    candidatos.add(pessoaFisica3)
    PessoaFisica pessoaFisica4 = new PessoaFisica(nome:"Brenda", email:"brenda@bonita.com", descricao:"Professora", CEP:"46600000", estado:"RJ", competencias:["Java", "Groovy"], cpf:"22334455667", idade:32)
    candidatos.add(pessoaFisica4)
    PessoaFisica pessoaFisica5 = new PessoaFisica(nome:"Leandro", email:"leleco@email.com", descricao:"Desenvolvedor", CEP:"56600000", estado:"RJ", competencias:["Unity", "C++"], cpf:"33445566778", idade:29)
    candidatos.add(pessoaFisica5)
    List<String> empresas = []
    PessoaJuridica empresa = new PessoaJuridica(nome:"Empresa 1", email:"empresa@empresa.com", descricao:"Empresa de TI", CEP:"16600000", estado:"SP", competencias:["Java", "Groovy"], cnpj:"12345678900", pais:"Brasil")
    empresas.add(empresa)
    PessoaJuridica empresa2 = new PessoaJuridica(nome:"Supresa", email:"supresa@rh.com", descricao:"Empresa de RH", CEP:"54321000", estado:"RJ", competencias:["SCRUM", "KANBAN"], cnpj:"09876543211", pais:"Brasil")
    empresas.add(empresa2)
    PessoaJuridica empresa3 = new PessoaJuridica(nome:"Nopresa", email:"nopresa@travels.com", descricao:"Empresa de Turismo", CEP:"26600000", estado:"RJ", competencias:["Java", "Groovy"], cnpj:"11223344556", pais:"Brasil")
    empresas.add(empresa3)
    PessoaJuridica empresa4 = new PessoaJuridica(nome:"Cobresa", email:"cobresa@steel.com", descricao:"Empresa de Metalurgia", CEP:"46600000", estado:"RJ", competencias:["Java", "Ruby"], cnpj:"22334455667", pais:"Brasil")
    empresas.add(empresa4)
    PessoaJuridica empresa5 = new PessoaJuridica(nome:"Lopresa", email:"lopresa@tech.com", descricao:"Empresa de TI", CEP:"56600000", estado:"RJ", competencias:["Python", "Unity"], cnpj:"33445566778", pais:"Brasil")
    empresas.add(empresa5)


    Boolean menuON = true

while (menuON) {
    menu()
    println "Escolha uma opção: "
    Integer option = System.in.newReader().readLine().toInteger()
    switch (option) {
        case 1:
            listarCandidatos(candidatos)
            println "chamou candidato"
//            println candidatos
            break
        case 2:
            listarEmpresas(empresas)
            println "chamou empresas"
            break
        case 3:
            cadastroCandidatos(candidatos)
            println "chamou cadastrar candidatos"
            break
        case 4:
            cadastroEmpresas(empresas)
            println "chamou cadastro de empresas"
            break
        case 0:
            println "Saindo do programa"
            menuON = false
            break
    }
    }

}


void listarCandidatos(List<PessoaFisica> candidatos) {
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

void listarEmpresas(List<PessoaJuridica> empresas) {
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

void cadastroCandidatos(candidatos) {
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
    List<String> competencias = System.in.newReader().readLine().split(",")
    println "Digite o CPF do candidato: "
    String cpf = System.in.newReader().readLine()
    println "Digite a idade do candidato: "
    Integer idade = System.in.newReader().readLine().toInteger()

    PessoaFisica candidato = new PessoaFisica(nome:nome, email:email, descricao:descricao, CEP:CEP, estado:estado, competencias:competencias, cpf:cpf, idade:idade)
    candidatos.add(candidato)
    println "Deseja cadastrar outro candidato? (S/N)"
    String resposta = System.in.newReader().readLine()
    if (resposta == "S") {
        cadastroCandidatos(candidatos)
    } else {
        println "Candidato cadastrado com sucesso! Voltando ao menu principal..."
    }
}

void cadastroEmpresas(empresas) {
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


void menu() {
    println "1. Listar Candidatos"
    println "2. Listar Empresas"
    println "3. Cadastrar Candidatos"
    println "4. Cadastrar Empresas"
    println "0. Sair"
}


