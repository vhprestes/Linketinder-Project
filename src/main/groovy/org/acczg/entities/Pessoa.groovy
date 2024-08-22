package org.acczg.entities

import org.acczg.models.IPessoa

abstract  class Pessoa implements IPessoa {
    String nome
    String email
    String descricao
    String CEP
    String estado
    List<String> competencias
//    TODO: métodos comuns de pessoa fisica e pessoa juridica ficarão aqui
}
