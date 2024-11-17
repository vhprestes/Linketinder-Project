package org.acczg.service.endpoints

import com.google.gson.Gson
import org.acczg.DAO.VagaDAO
import org.acczg.models.Vaga

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = "/vaga")
class VagaServlet extends HttpServlet {
    private VagaDAO vagaDAO = new VagaDAO()
    private Gson gson = new Gson()
    private boolean retornoDB

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Vaga vaga = gson.fromJson(request.getReader(), Vaga)
            this.retornoDB = this.vagaDAO.inserir(vaga)
            List<String> competencias = vaga.getCompetencias()
            if (retornoDB) {
                for (int i = 0; i < competencias.size(); i++) {
                    this.vagaDAO.inserirCompetenciaVaga(this.vagaDAO.obterVagaId(), Integer.parseInt(competencias[i]))
                }
            }
            switch (retornoDB) {
                case true:
                    response.setStatus(HttpServletResponse.SC_CREATED)
                    response.getWriter().write(gson.toJson(vaga))
                    break
                case false:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST)
                    response.getWriter().println("Informacoes do body invalidas")
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Vaga> vagas = this.vagaDAO.listar()
            response.setStatus(HttpServletResponse.SC_OK)
            response.getWriter().write(gson.toJson(vagas))
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

}