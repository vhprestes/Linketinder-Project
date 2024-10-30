package org.acczg.views.menus

import org.acczg.utils.DivisorLinha
import org.acczg.views.UI.CompetenciaView

class MenuCompetencias {

    static menuCompetencia() {
        CompetenciaView competenciaView = new CompetenciaView()
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
            println(menuCompetencia)
            String input = scanner.nextLine()
            try {
                int opcao = Integer.parseInt(input)

                switch (opcao) {
                    case 0:
                        menuON = false
                        break
                    case 1:
                        competenciaView.listarCompetencias()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 2:
                        competenciaView.cadastrarCompetencia()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 3:
                        competenciaView.alterarCompetencia()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 4:
                        competenciaView.deletarCompetencia()
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
                System.err.println("Erro no menu competências: " + e.getMessage())
            }
        }
    }
}