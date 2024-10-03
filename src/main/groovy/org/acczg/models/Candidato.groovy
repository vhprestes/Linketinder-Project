package org.acczg.models


import groovy.transform.ToString

@ToString(includeNames = true)

class Candidato extends IPessoa {
    String sobrenome
    String dataNascimento
    String cpf
    String pais
    List<String> competencias
    String senha

    @Override
    String toString() {
        "Candidato(" +
                " id=${id}," +
                " nome=${nome}," +
                " sobrenome=${sobrenome}," +
                " cpf=${cpf}," +
                " dt_nascimento=${dataNascimento}," +
                " email=${email}," +
                " competencias=${competencias}," +
                " senha=${senha}," +
                " pais=${pais}," +
                " estado=${estado}," +
                " cep=${cep}," +
                " descricao=${descricao} )"
    }
}