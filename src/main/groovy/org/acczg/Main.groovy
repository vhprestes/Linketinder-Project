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
    empresas.add(empresa as String)
    PessoaJuridica empresa2 = new PessoaJuridica(nome:"Supresa", email:"supresa@rh.com", descricao:"Empresa de RH", CEP:"54321000", estado:"RJ", competencias:["SCRUM", "KANBAN"], cnpj:"09876543211", pais:"Brasil")
    empresas.add(empresa2)
    PessoaJuridica empresa3 = new PessoaJuridica(nome:"Nopresa", email:"nopresa@travels.com", descricao:"Empresa de Turismo", CEP:"26600000", estado:"RJ", competencias:["Java", "Groovy"], cnpj:"11223344556", pais:"Brasil")
    empresas.add(empresa3)
    PessoaJuridica empresa4 = new PessoaJuridica(nome:"Cobresa", email:"cobresa@steel.com", descricao:"Empresa de Metalurgia", CEP:"46600000", estado:"RJ", competencias:["Java", "Ruby"], cnpj:"22334455667", pais:"Brasil")
    empresas.add(empresa4)
    PessoaJuridica empresa5 = new PessoaJuridica(nome:"Lopresa", email:"lopresa@tech.com", descricao:"Empresa de TI", CEP:"56600000", estado:"RJ", competencias:["Python", "Unity"], cnpj:"33445566778", pais:"Brasil")
    empresas.add(empresa5)


    println "Escolha uma opção: "
    menu()
    Integer option = System.in.newReader().readLine().toInteger()


    switch (option) {
        case 1:
//        listarCandidatos(candidatos)
            println "chamou candidato"
//            println candidatos
            break
        case 2:
            println "chamou empresas"
            println empresas.toString()
            break
        case 3:
//            cadastrarCandidatos()
            println "chamou cadastrar candidatos"
            break
        case 4:
//            cadastrarEmpresas()
            println "chamou cadastro de empresas"
        case 0:
            println "Saindo do programa"
            break
        default:
            menu()
    }

}





def menu() {
    println "1. Listar Candidatos"
    println "2. Listar Empresas"
    println "3. Cadastrar Candidatos"
    println "4. Cadastrar Empresas"
    println "0. Sair"
}


