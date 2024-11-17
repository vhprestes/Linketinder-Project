package org.acczg.service.endpoints

import com.google.gson.Gson
import org.acczg.DAO.CandidatoDAO
import org.acczg.models.Candidato

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "/candidato", urlPatterns = "/candidato")
class CandidatoServlet extends HttpServlet {

    private CandidatoDAO candidatoDAO = new CandidatoDAO()
    private Gson gson = new Gson()
    private boolean retornoDB

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Candidato candidato = gson.fromJson(request.getReader(), Candidato)
            this.retornoDB = this.candidatoDAO.inserir(candidato)
            List<String> competencias = candidato.getCompetencias()
            println("Competencias que vieram: " + competencias)
            println("Retorno do banco: " + retornoDB)
            if (retornoDB) {
                Integer idCandidato = this.candidatoDAO.obterCandidatoId()
                println("ID do candidato inserido: " + idCandidato)
                for (String competencia : competencias) {
                    Integer comp = Integer.parseInt(competencia)
                    boolean inserido = this.candidatoDAO.inserirCompetenciaCandidato(idCandidato, comp)
                    println("Inserida competencia: " + comp + " para o candidato: " + idCandidato + " - Sucesso: " + inserido)
                }
            }
            switch (retornoDB) {
                case true:
                    response.setStatus(HttpServletResponse.SC_CREATED)
                    response.getWriter().write(gson.toJson(candidato))
                    break
                case false:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST)
                    response.getWriter().println("Informacoes do body invalidas")
            }
        } catch (Exception e) {
            e.printStackTrace()
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
            response.getWriter().println("Erro interno do servidor")
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            print("GET")
            List<Candidato> candidatos = this.candidatoDAO.listar()
            response.setStatus(HttpServletResponse.SC_OK)
            response.getWriter().write(gson.toJson(candidatos))
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
