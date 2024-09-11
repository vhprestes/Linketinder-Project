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
