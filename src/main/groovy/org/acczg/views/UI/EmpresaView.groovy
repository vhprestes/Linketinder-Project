package org.acczg.views.UI

import org.acczg.controller.EmpresaController
import org.acczg.models.Empresa
import org.acczg.utils.Estados

class EmpresaView {

    private Scanner ler = new Scanner(System.in)
    private EmpresaController controllerEmpresa = new EmpresaController()

    void listarEmpresas() {
        controllerEmpresa.listarEmpresas()
    }

    void cadastrarEmpresa() {
        Empresa novaEmpresa = new Empresa()

        println("Digite o nome da empresa:")
        novaEmpresa.setNome(ler.nextLine())

        println("Digite o CNPJ da empresa:")
        novaEmpresa.setCnpj(ler.nextLine())

        println("Digite o email da empresa:")
        novaEmpresa.setEmail(ler.nextLine())

        println("Digite o CEP da empresa:")
        novaEmpresa.setCep(ler.nextLine())

        println("Faça uma descrição da empresa:")
        novaEmpresa.setDescricao(ler.nextLine())

        println("Altere o país:\n1. Brasil")
        String pais = Integer.parseInt(ler.nextLine())
        novaEmpresa.setPais(pais)

        println("Altere o estado:")
        println(Estados.estados)
        String estado = Integer.parseInt(ler.nextLine())
        novaEmpresa.setEstado(estado)

        println("Digite uma senha:")
        novaEmpresa.setSenha(ler.nextLine())

        controllerEmpresa.cadastrarEmpresa(novaEmpresa)
    }

    void alterarEmpresa() {
        controllerEmpresa.listarEmpresas()

        println("Escolha o código (id) da empresa a ser alterada:")
        int id = Integer.parseInt(ler.nextLine())

        Empresa empresa = new Empresa()
        empresa.setId(id)

        println("Altere o nome da empresa:")
        empresa.setNome(ler.nextLine())

        println("Altere o CNPJ da empresa:")
        empresa.setCnpj(ler.nextLine())

        println("Altere o email da empresa:")
        empresa.setEmail(ler.nextLine())

        println("Altere o CEP da empresa:")
        empresa.setCep(ler.nextLine())

        println("Altere a descrição da empresa:")
        empresa.setDescricao(ler.nextLine())

        println("Altere o país:\n1. Brasil")
        String pais = Integer.parseInt(ler.nextLine())
        empresa.setPais(pais)

        println("Altere o estado:")
        println(Estados.estados)
        String estado = Integer.parseInt(ler.nextLine())
        empresa.setEstado(estado)

        println("Altere a senha:")
        empresa.setSenha(ler.nextLine())

        controllerEmpresa.alterarEmpresa(empresa)
    }

    void deletarEmpresa() {
        controllerEmpresa.listarEmpresas()
        println "Escolha o id da empresa a ser deletada:"
        int id = Integer.parseInt(ler.nextLine())
        controllerEmpresa.deletarEmpresa(id)
    }
}