import { ListaUser } from "../../data/ListaUser";
import { Candidato } from "../Interfaces/Candidato";
import {regexValidation} from "./regexValidation";

export class CriaCandidatoToLocalStorage {

  public static CriaCandidatoToLocalStorage() {

    const formCandidato: any = document.getElementById('formCandidato');

    if (formCandidato != formCandidato.getAttribute('hidden')) {

      formCandidato.addEventListener('submit', function (event: { preventDefault: () => void; }) {
        event.preventDefault();
        localStorage.removeItem('CandidadosAtualizados');

        let competencias: any = document.querySelectorAll('#candidatoCompetencias input[type="checkbox"]:checked');
        let candidatoNome: any = document.getElementById('candidatoNome');
        let cpf: any = document.getElementById('cpf');
        let idade: any = document.getElementById('idade');
        let email: any = document.getElementById('candidatoEmail');
        let estado: any = document.getElementById('candidatoEstado');
        let cep: any = document.getElementById('candidatoCep');
        let descricao: any = document.getElementById('candidatoDescricao');
        let competenciasSelecionadas: any[] = [];

        if (competencias.length === 0) {
          alert('Selecione pelo menos uma competência.');
        } else {
          competencias.forEach(function (checkbox: any) {
            competenciasSelecionadas.push(checkbox.getAttribute('value'));
          });

          if (!regexValidation.validarCandidatoFormData(candidatoNome.value, cpf.value, idade.value, email.value, estado.value, cep.value, descricao.value)) {
            event.preventDefault();
          }

          const candidatoData = {
            nome: candidatoNome.value,
            cpf: cpf.value,
            idade: idade.value,
            email: email.value,
            estado: estado.value,
            cep: cep.value,
            descricao: descricao.value,
            competencias: competenciasSelecionadas
          };

          localStorage.setItem('candidatoData', JSON.stringify(candidatoData));

          const storedCandidatoData = JSON.parse(localStorage.getItem('candidatoData') || '{}');

          const cand = new Candidato(
              storedCandidatoData.nome,
              storedCandidatoData.email,
              storedCandidatoData.estado,
              storedCandidatoData.descricao,
              storedCandidatoData.competencias,
              storedCandidatoData.cep,
              storedCandidatoData.cpf,
              storedCandidatoData.idade
          );

          ListaUser.candidatos.push(cand);
          console.log('cand', cand);
          localStorage.setItem('saved', JSON.stringify(cand));

          alert('Candidato cadastrado com sucesso!');
          console.log('ListaUser candidatos:', ListaUser.candidatos);
          localStorage.setItem('CandidadosAtualizados', JSON.stringify(ListaUser.candidatos));
        }
      });
    }
  }
}