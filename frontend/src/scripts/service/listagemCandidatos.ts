import { Candidato } from "../Interfaces/Candidato";
import { ListaUser } from "../../data/ListaUser";

export class ListagemCandidatos {

  public static async fetchRandomName(): Promise<string> {
    try {
      const response = await fetch('https://randomuser.me/api/');
      const data = await response.json();
      const name = data.results[0].name.first;
      return `Anonimo ${name}`;
    } catch (error) {
      console.error('Erro ao buscar nome aleatório:', error);
      return 'Anonimo';
    }
  }

  public static async renderTable() {
    ListaUser.loadCandidatosFromLocalStorage();
    const savedCandidatos = ListaUser.candidatos;
    console.log('savedCandidatos', savedCandidatos);
    const tableBody = document.getElementById('candidatosTableBody');

    if (!tableBody) {
      console.error('Elemento candidatosTableBody não encontrado.');
      return;
    }

    tableBody.innerHTML = '';

    for (const candidato of savedCandidatos) {
      const anonimoNome = await ListagemCandidatos.fetchRandomName();
      const row = document.createElement('tr');

      row.innerHTML = `
        <td>${anonimoNome}</td>
        <td>${candidato.email}</td>
        <td>${candidato.estado}</td>
        <td>${candidato.descricao}</td>
        <td>${candidato.competencias.join(', ')}</td>
        <td>${candidato.cep}</td>
        <td>${candidato.cpf}</td>
        <td>${candidato.idade}</td>
      `;

      tableBody.appendChild(row);
    }
  }
}