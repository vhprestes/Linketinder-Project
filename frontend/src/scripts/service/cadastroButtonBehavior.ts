import {ListaUser} from "../../data/ListaUser";
import {Candidato} from "../Interfaces/Candidato";


export class CadastroButtonBehavior {


  public static CadastroButtonBehavior() {
    const mostrarFormularioEmpresa = document.getElementById('mostrarFormularioEmpresa');
    const mostrarFormularioCandidato = document.getElementById('mostrarFormularioCandidato');
    const formEmpresa = document.getElementById('formEmpresa');
    const formCandidato = document.getElementById('formCandidato');
    console.log('ListaUser.candidatos no cadastrobuttonBehavior', ListaUser.candidatos);

    if (formEmpresa && formCandidato && mostrarFormularioEmpresa && mostrarFormularioCandidato) {
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


    // let candidatoNome = localStorage.getItem('candidatoNome');
    // let email = localStorage.getItem('email');
    // let estado = localStorage.getItem('estado');
    // let descricao = localStorage.getItem('descricao');
    // let competencias = localStorage.getItem('competencias');
    // let cep = localStorage.getItem('cep');
    // let cpf = localStorage.getItem('cpf');
    // let idade = localStorage.getItem('idade');
    //
    //
    // if(candidatoNome && email && estado && descricao && competencias && cep && cpf && idade) {
    //   ListaUser.candidatos.push(new Candidato(
    //       candidatoNome,
    //       email,
    //       estado,
    //       descricao,
    //       competencias.split(', '),
    //       cep,
    //       cpf,
    //       idade))
    //
    //
    //   localStorage.removeItem('candidatoNome');
    //   localStorage.removeItem('email');
    //   localStorage.removeItem('estado');
    //   localStorage.removeItem('descricao');
    //   localStorage.removeItem('competencias');
    //   localStorage.removeItem('cep');
    //   localStorage.removeItem('cpf');
    //   localStorage.removeItem('idade');
    // }



  }}
