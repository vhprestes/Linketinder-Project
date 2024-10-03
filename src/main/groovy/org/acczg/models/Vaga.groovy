package org.acczg.models

class Vaga {
    int id
    String nome
    String descricao
    List<String> competencias
    String cidade
    String empresa


    String toString() {
        "Vaga(id: ${id}, nome: ${nome}, descricao: ${descricao}, competencias: ${competencias}, cidade: ${cidade}, empresa: ${empresa})"
    }
}
