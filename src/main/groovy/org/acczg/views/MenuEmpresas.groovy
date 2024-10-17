package org.acczg.views

import org.acczg.controller.ControllerEmpresa
import org.acczg.utils.DivisorLinha

class MenuEmpresas {

    static boolean menuEmpresa() {
        ControllerEmpresa controllerEmpresa = new ControllerEmpresa()
        Boolean menuON = true
        String menuEmpresa = "Por favor escolha uma opção:\n" +
                "1. Listar Empresas\n" +
                "2. Cadastrar Empresa\n" +
                "3. Alterar Empresa\n" +
                "4. Excluir Empresa\n" +
                "0. Voltar ao menu anterior"

        Scanner scanner = new Scanner(System.in)
        while (menuON) {
            println(DivisorLinha.linha)
            println menuEmpresa
            String input = scanner.nextLine()

            try {
                int opcao = Integer.parseInt(input)

                switch (opcao) {
                    case 0:
                        menuON = false
                        break
                    case 1:
                        controllerEmpresa.listarEmpresas()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 2:
                        controllerEmpresa.cadastrarEmpresa()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 3:
                        controllerEmpresa.alterarEmpresa()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 4:
                        controllerEmpresa.deletarEmpresa()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    default:
                        println("Erro: opção inválida!")
                        break
                }

            } catch (NumberFormatException e) {
                System.err.println("Erro: entrada inválida! Por favor, insira um número.")
            } catch (IOException e) {
                System.err.println("Erro no menu empresas: " + e.getMessage())
            }
        }
        return menuON
    }
}