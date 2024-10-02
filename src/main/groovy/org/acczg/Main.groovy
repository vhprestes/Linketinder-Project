package org.acczg


import org.acczg.views.MenuCandidatos

static void main(String[] args) {

    Boolean menuON = true

    while (menuON) {
        menu()
        println "Escolha uma opção: "
        Integer option = System.in.newReader().readLine().toInteger()
        switch (option) {
            case 1:
                MenuCandidatos.menuCandidato()
                break
            case 2:
//      Listar empresas funcao
                break
            case 3:
//       Cadastrar candidatos funcao
                break
            case 4:
//                Cadastrar empresas funcao
                break
            case 0:
                println "Saindo do programa"
                menuON = false
                break
        }
    }

}

void menu() {
    println "1. Menu Candidatos"
    println "2. Menu Empresas"
    println "3. Menu Vagas"
    println "4. Menu Competencias"
    println "0. Sair"
}


