package org.acczg.views

import org.acczg.controller.ControllerCandidato
import org.acczg.utils.DivisorLinha

class MenuCandidatos {

    static menuCandidato() {
        ControllerCandidato controllerCandidato = new ControllerCandidato()
        Boolean menuON = true
        String menuCandidato = "Por favor escolha uma opção:\n" +
                "1. Listar Candidatos\n" +
                "2. Cadastrar Candidato\n" +
                "3. Alterar Candidato\n" +
                "4. Excluir Candidato\n" +
                "0. Voltar ao menu anterior"


        Scanner scanner = new Scanner(System.in)
        while (menuON) {
            println menuCandidato
//            parsa pra garantir e trata dps se der ruim
            String input = scanner.nextLine()

            try {
                int opcao = Integer.parseInt(input)

                switch (opcao) {
                    case 0:
                        menuON = false
                        break
                    case 1:
                        controllerCandidato.listarCandidatos()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 2:
                        controllerCandidato.cadastrarCandidato()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 3:
                        controllerCandidato.alterarCandidato()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 4:
                        controllerCandidato.deletarCandidato()
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

            }
            catch (IOException e) {
                System.err.println("Erro no meu candidatos: " + e.getMessage())
            }
        }
    }
}
