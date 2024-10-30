package org.acczg.factory

import org.acczg.models.Empresa
import org.acczg.models.Candidato

class EntityFactory {


    static Empresa createEmpresa(String nome, String cnpj, String email, String senha, String pais, String estado, String cep, String descricao) {
        Empresa empresa = new Empresa()
        empresa.setNome(nome)
        empresa.setCnpj(cnpj)
        empresa.setEmail(email)
        empresa.setSenha(senha)
        empresa.setPais(pais)
        empresa.setEstado(estado)
        empresa.setCep(cep)
        empresa.setDescricao(descricao)
        return empresa
    }


    static Candidato createCandidato(String nome, String sobrenome, String cpf, String dataNascimento, String email, String senha, String pais, String estado, String cep, String descricao, List<String> competencias) {
        Candidato candidato = new Candidato()
        candidato.setNome(nome)
        candidato.setSobrenome(sobrenome)
        candidato.setCpf(cpf)
        candidato.setDataNascimento(dataNascimento)
        candidato.setEmail(email)
        candidato.setSenha(senha)
        candidato.setPais(pais)
        candidato.setEstado(estado)
        candidato.setCep(cep)
        candidato.setDescricao(descricao)
        candidato.setCompetencias(competencias)
        return candidato
    }
}
