package org.acczg


import org.acczg.views.MenuCandidatos
import org.acczg.views.MenuCompetencias
import org.acczg.views.MenuEmpresas

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
                MenuEmpresas.menuEmpresa()
                break
            case 3:
                MenuCompetencias.menuCompetencia()
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
    println "3. Menu Competencias"
    println "4. Menu Vagas"
    println "0. Sair"
}


