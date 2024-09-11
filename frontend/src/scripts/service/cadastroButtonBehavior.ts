import {ListaUser} from "../../data/ListaUser";
import {Candidato} from "../Interfaces/Candidato";


export class CadastroButtonBehavior {


  public static CadastroButtonBehavior() {
    const mostrarFormularioEmpresa = document.getElementById('mostrarFormularioEmpresa');
    const mostrarFormularioCandidato = document.getElementById('mostrarFormularioCandidato');
    const formEmpresa = document.getElementById('formEmpresa');
    const formCandidato = document.getElementById('formCandidato');
    console.log('entrou no cadastroButtonBehavior')
    if (formEmpresa && formCandidato && mostrarFormularioEmpresa && mostrarFormularioCandidato) {
      console.log('entrou no if')
      mostrarFormularioEmpresa.addEventListener('click', function () {
        formEmpresa.removeAttribute('hidden');
        mostrarFormularioEmpresa.setAttribute('hidden', 'true');
        mostrarFormularioCandidato.setAttribute('hidden', 'true');
      });

      mostrarFormularioCandidato.addEventListener('click', function () {
        formCandidato.removeAttribute('hidden');
        mostrarFormularioEmpresa.setAttribute('hidden', 'true');
        mostrarFormularioCandidato.setAttribute('hidden', 'true');
      });
    }

  }}


export class CriaCandidatoToLocalStorage {

  public static CriaCandidatoToLocalStorage() {

    const nomeCandidato :any = document.getElementById('candidatoNome');
    const cpfCandidato :any = document.getElementById('cpf');
    const idadeCandidato :any = document.getElementById('idade');
    const emailCandidato :any = document.getElementById('candidatoEmail');
    const estadoCandidato :any = document.getElementById('candidatoEstado');
    const CEPcandidato :any = document.getElementById('candidatoCep');
    const competenciasCandidato :any = document.querySelectorAll('#candidatoCompetencias input[type="checkbox"]:checked');
    const descricaoCandidato :any = document.getElementById('candidatoDescricao')
    let checkedComp: any = [];

    console.log(checkedComp)

    if (competenciasCandidato.length == 0) {
      event?.preventDefault();
      alert('Pelo menos uma competência deve ser selecionada!');
    } else {
      checkedComp = CriaCandidatoToLocalStorage.getCheckedCompetencias().join(', ').toString();
      console.log('checkeds', +checkedComp);

      localStorage.setItem('candidatoNome', nomeCandidato?.value || '');
      localStorage.setItem('cpf', cpfCandidato?.value || '');
      localStorage.setItem('idade', idadeCandidato?.value || '');
      localStorage.setItem('candidatoEmail', emailCandidato?.value || '');
      localStorage.setItem('candidatoEstado', estadoCandidato?.value || '');
      localStorage.setItem('candidatoCep', CEPcandidato?.value || '');
      localStorage.setItem('descricaoCandidato', descricaoCandidato?.value || '');
      localStorage.setItem('candidatoCompetencias', checkedComp.toString() || '');


      ListaUser.candidatos.push(new Candidato(
          nomeCandidato,
          emailCandidato,
          estadoCandidato,
          descricaoCandidato,
          checkedComp,
          CEPcandidato,
          cpfCandidato,
          idadeCandidato
      ));
      alert('Candidato cadastrado com sucesso!');
    }}


  static  getCheckedCompetencias() {
    let checkedCompetencias: string[] = [];
    const checkboxes = document.querySelectorAll('#candidatoCompetencias input[type="checkbox"]:checked');
    checkboxes.forEach((checkbox) => {
      checkedCompetencias.push(checkbox.getAttribute('value') || '');
    });
    return checkedCompetencias
  }
}