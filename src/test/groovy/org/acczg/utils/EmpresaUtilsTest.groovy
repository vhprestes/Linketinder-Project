package org.acczg.utils

import org.acczg.DAO.EmpresaDAO
import org.acczg.models.Empresa
import org.acczg.service.EmpresaService
import spock.lang.Specification

class EmpresaUtilsTest extends Specification {
    EmpresaDAO empresaDAO = Mock()
    EmpresaService empresaService = new EmpresaService(empresaDAO)
    PrintStream printStream = Mock()

    def setup() {
        System.setOut(printStream)
    }

    def "Cadastrar Empresa should print success message"() {
        given:
        Empresa empresa = new Empresa(id: 1, nome: "Empresa X", cnpj: "12345678000100", email: "x@y.com", senha: "senha", pais: "1", estado: "17", cep: "12345678", descricao: "Empresa X")

        when:
        empresaService.cadastrarEmpresa(empresa)

        then:
        1 * empresaDAO.inserir(empresa)
        1 * printStream.println("Empresa cadastrada com sucesso")
    }

    def "Cadastrar Empresa should throw exception on failure"() {
        given:
        Empresa empresa = null

        when:
        empresaService.cadastrarEmpresa(empresa)

        then:
        0 * printStream.println("Empresa cadastrada com sucesso")
        1 * printStream.println("Erro no cadastro de empresa Empresa não pode ser nula")
    }

    def "Alterar Empresa should print success message"() {
        given:
        Empresa empresa = new Empresa(id: 1, nome: "Empresa X", cnpj: "12345678000100", email: "x@y.com", senha: "senha", pais: "1", estado: "17", cep: "12345678", descricao: "Empresa X")

        when:
        empresaService.alterarEmpresa(empresa)

        then:
        1 * empresaDAO.alterar(empresa)
        1 * printStream.println("Empresa alterada com sucesso")
    }

    def "Deletar Empresa should print success message"() {
        given:
        Integer id = 1

        when:
        empresaService.deletarEmpresa(id)

        then:
        1 * empresaDAO.remover(id)
        1 * printStream.println("Empresa deletada com sucesso")
    }

    def "Deletar Empresa should throw exception on failure"() {
        given:
        Integer id = 1
        empresaDAO.remover(id) >> { throw new Exception("Erro ao tentar remover a empresa. Erro: erro") }

        when:
        empresaService.deletarEmpresa(id)

        then:
        thrown(Exception)
        0 * printStream.println("Empresa removida com sucesso")
    }
}