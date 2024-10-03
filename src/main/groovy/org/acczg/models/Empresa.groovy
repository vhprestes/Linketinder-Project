package org.acczg.models

import groovy.transform.ToString

@ToString
class Empresa extends IPessoa {

    String pais
    String cnpj
    String senha

    String toString() {
        "Empresa(" +
                " id=${id}," +
                " nome=${nome}," +
                " cnpj=${cnpj}," +
                " email=${email}," +
                " senha=${senha}," +
                " pais=${pais}," +
                " estado=${estado}," +
                " cep=${cep}," +
                " descricao=${descricao} )"

    }

}