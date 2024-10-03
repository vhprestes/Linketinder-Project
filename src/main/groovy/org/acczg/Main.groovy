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
//      menu empresas
                break
            case 3:
//       menu competencias
                break
            case 4:
//        menu vaga
                break
            case 0:
                println "Saindo do programa"
                menuON = false
                break
        }
    }

}

void menu() {
    println "Bem vindo ao menu inicial!"
    println "1. Menu Candidatos"
    println "2. Menu Empresas"
    println "3. Menu Vagas"
    println "4. Menu Competencias"
    println "0. Sair"
}


