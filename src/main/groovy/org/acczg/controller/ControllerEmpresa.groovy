package org.acczg.controller

import org.acczg.models.Empresa
import org.acczg.service.EmpresaService
import org.acczg.utils.Estados

class ControllerEmpresa {

    private Empresa novaEmpresa = new Empresa()
    private String nomeEmpresa
    private String cnpj
    private String email
    private String cep
    private String descricao
    private String senha
    private String pais
    private String estado

    int opcao
    Scanner ler = new Scanner(System.in)

    void listarEmpresas() {
        EmpresaService.listarEmpresas()
    }

    void cadastrarEmpresa() {

        println("Digite o nome da empresa:")
        this.nomeEmpresa = ler.nextLine()

        println("Digite o cnpj da empresa:")
        this.cnpj = ler.nextLine()

        println("Digite o email da empresa:")
        this.email = ler.nextLine()

        println("Digite o cep da empresa:")
        this.cep = ler.nextLine()

        println("Faça uma descrição da empresa:")
        this.descricao = ler.nextLine()

        println("Selecione o pais:\n1. Brasil")
        this.pais = Integer.parseInt(ler.nextLine())

        println("Selecione o estado:")
        println(Estados.estados)
        this.estado = Integer.parseInt(ler.nextLine())

        println("Digite uma senha:")
        this.senha = ler.nextLine()

        this.novaEmpresa.setNome(this.nomeEmpresa)
        this.novaEmpresa.setCnpj(this.cnpj)
        this.novaEmpresa.setEmail(this.email)
        this.novaEmpresa.setCep(this.cep)
        this.novaEmpresa.setDescricao(this.descricao)
        this.novaEmpresa.setPais(this.pais)
        this.novaEmpresa.setEstado(this.estado)
        this.novaEmpresa.setSenha(this.senha)

        EmpresaService.cadastrarEmpresa(this.novaEmpresa)

    }

    void alterarEmpresa() {
        Scanner ler = new Scanner(System.in)

        EmpresaService.listarEmpresas()

        println "Escolha o código(id) da empresa a ser alterada:"
        this.opcao = Integer.parseInt(ler.nextLine())

        println("Altere o nome da empresa:")
        this.nomeEmpresa = ler.nextLine()

        println("Altere o cnpj da empresa:")
        this.cnpj = ler.nextLine()

        println("Altere email da empresa:")
        this.email = ler.nextLine()

        println("Altere o cep da empresa:")
        this.cep = ler.nextLine()

        println("Altere a descrição da empresa:")
        this.descricao = ler.nextLine()

        println("Altere o pais:")
        println("1. Brasil")
//       add: outros paises
        this.pais = Integer.parseInt(ler.nextLine())

        println("Altere o estado. Para isso, digite o código referente ao Estado novo:")
        println(Estados.estados)
        this.estado = Integer.parseInt(ler.nextLine())

        println("Altere a senha:")
        this.senha = ler.nextLine()

        this.novaEmpresa.setId(opcao)
        this.novaEmpresa.setNome(this.nomeEmpresa)
        this.novaEmpresa.setCnpj(this.cnpj)
        this.novaEmpresa.setEmail(this.email)
        this.novaEmpresa.setCep(this.cep)
        this.novaEmpresa.setDescricao(this.descricao)
        this.novaEmpresa.setPais(this.pais)
        this.novaEmpresa.setEstado(this.estado)
        this.novaEmpresa.setSenha(this.senha)

        EmpresaService.alterarEmpresa(this.novaEmpresa)
    }

    void deletarEmpresa() {

        EmpresaService.listarEmpresas()
        println "Escolha o código(id) da empresa a ser deletada:"
        this.opcao = Integer.parseInt(ler.nextLine())

        EmpresaService.deletarEmpresa(this.opcao)
    }

}
