package org.acczg.views

import org.acczg.controller.ControllerVagas
import org.acczg.utils.DivisorLinha

class MenuVagas {

    static boolean menuVaga() {
        ControllerVagas controllerVaga = new ControllerVagas()
        Boolean menuON = true
        String menuVaga = "Por favor escolha uma opção:\n" +
                "1. Listar Vagas\n" +
                "2. Cadastrar Vaga\n" +
                "3. Alterar Vaga\n" +
                "4. Excluir Vaga\n" +
                "0. Voltar ao menu anterior"

        Scanner scanner = new Scanner(System.in)
        while (menuON) {
            println menuVaga
            String input = scanner.nextLine()

            try {
                int opcao = Integer.parseInt(input)

                switch (opcao) {
                    case 0:
                        menuON = false
                        break
                    case 1:
                        controllerVaga.listarVagas()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 2:
                        controllerVaga.cadastrarVaga()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 3:
                        controllerVaga.alterarVaga()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 4:
                        controllerVaga.deletarVaga()
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
                System.err.println("Erro no menu vagas: " + e.getMessage())
            }
        }
        return menuON
    }
}