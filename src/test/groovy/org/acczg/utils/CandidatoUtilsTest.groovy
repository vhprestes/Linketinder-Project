package org.acczg.utils

import org.acczg.DAO.CandidatoDAO
import org.acczg.models.Candidato
import org.acczg.service.CandidatoService
import spock.lang.Specification

class CandidatoUtilsTest extends Specification {
    CandidatoDAO candidatoDAO = Mock()
    CandidatoService candidatoService = new CandidatoService(candidatoDAO)
    PrintStream printStream = Mock()

    def setup() {
        System.setOut(printStream)
    }

    def "Cadastrar Candidato should print success message"() {
        given:
        Candidato candidato = new Candidato(id: 1, nome: "João", sobrenome: "Do Gás", cpf: "12345678900", dataNascimento: "01/01/2000", email: "a@b.com", descricao: "gente boa", pais: "1", estado: "17", cep: "12345678", senha: "senha")

        when:
        candidatoService.cadastrarCandidato(candidato)

        then:
        1 * candidatoDAO.inserir(candidato)
        1 * printStream.println("Candidato cadastrado com sucesso")
    }

    def "CadastrarCompetenciaCandidato should print success message"() {
        given:
        Integer candidatoId = 1
        Integer competenciaId = 1

        when:
        candidatoService.cadastrarCompetenciaCandidato(candidatoId, competenciaId)

        then:
        1 * printStream.println("Competência cadastrada com sucesso")
    }

    def "Cadastrar Candidato should throw exception on failure"() {
        given:
        def candidato = new Candidato(id: 5, nome: "alfredo")

        when:
        candidatoService.cadastrarCandidato(candidato)

        then:
        thrown(IllegalArgumentException)
        0 * printStream.println("Candidato cadastrado com sucesso")
        1 * printStream.println("Erro ao tentar cadastrar o candidato. Erro: Existem campos nulos")


    }

    def "deleteCandidato should print success message"() {
        given:
        Integer id = 1

        when:
        candidatoService.deletarCandidato(id)

        then:
        1 * candidatoDAO.remover(id)
        1 * printStream.println("Candidato removido com sucesso")
    }
}