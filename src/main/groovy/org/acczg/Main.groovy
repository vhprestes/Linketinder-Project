package org.acczg

//import org.acczg.entities.PessoaFisica

static void main(String[] args) {


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
//        listarEmpresas(empresas)
            println "chamou empresas"
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


