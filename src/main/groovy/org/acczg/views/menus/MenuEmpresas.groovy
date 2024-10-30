package org.acczg.views.menus

import org.acczg.utils.DivisorLinha
import org.acczg.views.UI.EmpresaView

class MenuEmpresas {

    static menuEmpresa() {
        EmpresaView empresaView = new EmpresaView()
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
            println(menuEmpresa)
            String input = scanner.nextLine()
            try {
                int opcao = Integer.parseInt(input)

                switch (opcao) {
                    case 0:
                        menuON = false
                        break
                    case 1:
                        empresaView.listarEmpresas()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 2:
                        empresaView.cadastrarEmpresa()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 3:
                        empresaView.alterarEmpresa()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 4:
                        empresaView.deletarEmpresa()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    default:
                        println("Erro: opção inválida!")
                        break
                }

                if (opcao == 0) {
                    break
                }

            } catch (IOException e) {
                System.err.println("Erro no menu empresas: " + e.getMessage())
            }
        }
    }
}