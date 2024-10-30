package org.acczg.views.menus

import org.acczg.utils.DivisorLinha
import org.acczg.views.UI.VagaView

class MenuVagas {

    static menuVaga() {
        VagaView vagaView = new VagaView()
        Boolean menuON = true
        String menuVaga = "Por favor escolha uma opção:\n" +
                "1. Listar Vagas\n" +
                "2. Cadastrar Vaga\n" +
                "3. Alterar Vaga\n" +
                "4. Excluir Vaga\n" +
                "0. Voltar ao menu anterior"

        Scanner scanner = new Scanner(System.in)
        while (menuON) {
            println(DivisorLinha.linha)
            println(menuVaga)
            String input = scanner.nextLine()
            try {
                int opcao = Integer.parseInt(input)

                switch (opcao) {
                    case 0:
                        menuON = false
                        break
                    case 1:
                        vagaView.listarVagas()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 2:
                        vagaView.cadastrarVaga()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 3:
                        vagaView.alterarVaga()
                        println(DivisorLinha.linha)
                        menuON = false
                        break
                    case 4:
                        vagaView.deletarVaga()
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
                System.err.println("Erro no menu vagas: " + e.getMessage())
            }
        }
    }
}