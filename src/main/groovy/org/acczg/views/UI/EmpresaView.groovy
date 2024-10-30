package org.acczg.views.UI

import org.acczg.controller.EmpresaController
import org.acczg.factory.EntityFactory
import org.acczg.models.Empresa
import org.acczg.utils.Estados

class EmpresaView {

    private Scanner ler = new Scanner(System.in)
    private EmpresaController controllerEmpresa = new EmpresaController()

    void listarEmpresas() {
        controllerEmpresa.listarEmpresas()
    }


    Empresa criarEmpresa() {
        println("Digite o nome da empresa:")
        String nome = ler.nextLine()

        println("Digite o CNPJ da empresa:")
        String cnpj = ler.nextLine()

        println("Digite o email da empresa:")
        String email = ler.nextLine()

        println("Digite o CEP da empresa:")
        String cep = ler.nextLine()

        println("Faça uma descrição da empresa:")
        String descricao = ler.nextLine()

        println("Altere o país:\n1. Brasil")
        String pais = Integer.parseInt(ler.nextLine())


        println("Altere o estado:")
        println(Estados.estados)
        String estado = Integer.parseInt(ler.nextLine())

        println("Digite uma senha:")
        String senha = ler.nextLine()

        Empresa novaEmpresa = EntityFactory.createEmpresa(nome, cnpj, email, senha, pais, estado, cep, descricao)
        return novaEmpresa
    }

    void cadastrarEmpresa() {
        Empresa novaEmpresa = criarEmpresa()
        controllerEmpresa.cadastrarEmpresa(novaEmpresa)
    }

    void alterarEmpresa() {
        controllerEmpresa.listarEmpresas()

        println("Escolha o código (id) da empresa a ser alterada:")
        int id = Integer.parseInt(ler.nextLine())
        Empresa empresa = criarEmpresa()
        empresa.setId(id)
        controllerEmpresa.alterarEmpresa(empresa)
    }

    void deletarEmpresa() {
        controllerEmpresa.listarEmpresas()
        println "Escolha o id da empresa a ser deletada:"
        int id = Integer.parseInt(ler.nextLine())
        controllerEmpresa.deletarEmpresa(id)
    }
}