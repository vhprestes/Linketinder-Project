import {CadastroButtonBehavior} from "./service/cadastroButtonBehavior";
import {CriaCandidatoToLocalStorage} from "./service/cadastroCandidato";
import {Candidato} from "./Interfaces/Candidato";
import {ListaUser} from "../data/ListaUser";
import {GraficosCandidatos} from "./service/grafico";
import {CriaEmpresaToLocalStorage} from "./service/cadastroEmpresa";
import {ListagemCandidatos} from "./service/listagemCandidatos";
import {ListagemVagas} from "./service/listagemVagas";

console.log('AOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO');

const formCandidatoON = document.getElementById('formCandidato');
const formEmpresaON = document.getElementById('formEmpresa');


CadastroButtonBehavior.CadastroButtonBehavior()
// Ensure candidates are loaded from localStorage when the page loads
window.onload = function() {
  ListaUser.loadCandidatosFromLocalStorage();
  console.log('Candidatos carregados:', ListaUser.candidatos);
};

if (document.getElementById('competenciasChart')) {
  GraficosCandidatos.gerarGrafico();
}


if (document.getElementById('formCandidato')) {
    console.log('entrou no na condicional do index.ts');
  CriaCandidatoToLocalStorage.CriaCandidatoToLocalStorage();
}

if (document.getElementById('formEmpresa')) {
  CriaEmpresaToLocalStorage.CriaEmpresaToLocalStorage();
}

if (document.getElementById('candidatosTableBody')) {
  ListagemCandidatos.renderTable().then(r => console.log('Tabela de candidatos renderizada.'));
}

if(document.getElementById('tabelaVagas')) {
  ListagemVagas.renderTableVagas();
}

// let newCant = new Candidato('nome', 'email', 'estado', 'descricao', ['competencia'], 'cep', 'cpf', 'idade');
// console.log('newCant', newCant.nome, newCant.email, newCant.estado, newCant.descricao, newCant.competencias, newCant.cep, newCant.cpf, newCant.idade);
//
//
//


