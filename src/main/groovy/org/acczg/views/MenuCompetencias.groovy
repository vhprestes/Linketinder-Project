package org.acczg.views

import org.acczg.controller.ControllerCompetencia
import org.acczg.utils.DivisorLinha

class MenuCompetencias {

    static boolean menuCompetencia() {
        ControllerCompetencia controllerCompetencia = new ControllerCompetencia()
        Boolean menuON = true
        String menuCompetencia = "Por favor escolha uma opção:\n" +
                "1. Listar Competências\n" +
                "2. Cadastrar Competência\n" +
                "3. Alterar Competência\n" +
                "4. Excluir Competência\n" +
                "0. Voltar ao menu anterior"

        Scanner scanner = new Scanner(System.in)
        while (menuON) {
            println(DivisorLinha.linha)
            println menuCompetencia
            String input = scanner.nextLine()

            try {
                int opcao = Integer.parseInt(input)

                switch (opcao) {
                    case 0:
                        menuON = false
                        break
                    case 1:
                        controllerCompetencia.listarCompetencias()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 2:
                        controllerCompetencia.cadastrarCompetencia()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 3:
                        controllerCompetencia.alterarCompetencia()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 4:
                        controllerCompetencia.deletarCompetencia()
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
                System.err.println("Erro no menu competências: " + e.getMessage())
            }
        }
        return menuON
    }
}