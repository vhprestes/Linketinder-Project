package org.acczg.views.menus


import org.acczg.utils.DivisorLinha
import org.acczg.views.UI.CandidatoView

class MenuCandidatos {

    static menuCandidato() {
        CandidatoView candidatoView = new CandidatoView()
        Boolean menuON = true
        String menuCandidato = "Por favor escolha uma opção:\n" +
                "1. Listar Candidatos\n" +
                "2. Cadastrar Candidato\n" +
                "3. Alterar Candidato\n" +
                "4. Excluir Candidato\n" +
                "0. Voltar ao menu anterior"


        Scanner scanner = new Scanner(System.in)
        while (menuON) {
            println(DivisorLinha.linha)
            println (menuCandidato)
            String input = scanner.nextLine()
            try {
                int opcao = Integer.parseInt(input)

                switch (opcao) {
                    case 0:
                        menuON = false
                        break
                    case 1:
                        candidatoView.listarCandidatos()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 2:
                        candidatoView.cadastrarCandidato()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 3:
                        candidatoView.alterarCandidato()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 4:
                        candidatoView.deletarCandidato()
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
