import {CadastroButtonBehavior} from "./service/cadastroButtonBehavior";
import {CriaCandidatoToLocalStorage} from "./service/cadastroCandidato";

console.log('AOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO');

const formCandidatoON = document.getElementById('formCandidato');
const formEmpresaON = document.getElementById('formEmpresa');


CadastroButtonBehavior.CadastroButtonBehavior()

if (formCandidatoON?.getAttribute('hidden') == null) {
    console.log('entrou no na condicional do indes.ts');
  CriaCandidatoToLocalStorage.CriaCandidatoToLocalStorage();
}



