import {Vagas} from "../../data/Vagas";

export class ListagemVagas {

  public static renderTableVagas() {
    const vagas = Vagas.vagas;
    const tableBody = document.getElementById('corpoTabelaVagas');

    if (!tableBody) {
      console.error('Elemento corpoTabelaVagas não encontrado.');
      return;
    }

    tableBody.innerHTML = '';

    for (const vaga of vagas) {
      const row = document.createElement('tr');

      row.innerHTML = `
        <td>${vaga.nome}</td>
        <td>${vaga.estado}</td>
        <td>${vaga.descricao}</td>
        <td>${vaga.competencias.join(', ')}</td>
      `;

      tableBody.appendChild(row);
    }
  }
}