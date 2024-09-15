import { ListaUser } from "../../data/ListaUser";
import { Empresa } from "../Interfaces/Empresa";
import {regexValidation} from "./regexValidation";

export class CriaEmpresaToLocalStorage {

  public static CriaEmpresaToLocalStorage() {

    // test it first
    ListaUser.loadEmpresasFromLocalStorage();


    const formEmpresa: any = document.getElementById('formEmpresa');

    if (formEmpresa != formEmpresa.getAttribute('hidden')) {

      formEmpresa.addEventListener('submit', function (event: { preventDefault: () => void; }) {
        event.preventDefault();
        localStorage.removeItem('EmpresasAtualizadas');

        let competencias: any = document.querySelectorAll('#empresaCompetencias input[type="checkbox"]:checked');
        let empresaNome: any = document.getElementById('empresaNome');
        let pais: any = document.getElementById('pais');
        let estado: any = document.getElementById('empresaEstado');
        let cep: any = document.getElementById('empresaCep');
        let cnpj: any = document.getElementById('cnpj');
        let email: any = document.getElementById('empresaEmail');
        let descricao: any = document.getElementById('empresaDescricao');
        let competenciasSelecionadas: any[] = [];

        if (competencias.length === 0) {
          alert('Selecione pelo menos uma competência.');
        } else {
          competencias.forEach(function (checkbox: any) {
            competenciasSelecionadas.push(checkbox.getAttribute('value'));
          });


          if(!regexValidation.validateCEP(cep.value)) {
            event.preventDefault();
            return;
          }
          if(!regexValidation.validateCnpj(cnpj.value)) {
            event.preventDefault();
            return;
          }
          if(!regexValidation.validateEmail(email.value)) {
            event.preventDefault();
            return;
          }
          if(!regexValidation.validateEstado(estado.value.trim())) {
            event.preventDefault();
            return;
          }
          if(!regexValidation.validateDescricao(descricao.value)) {
            event.preventDefault();
            return;
          }
          if(!regexValidation.validateNomeEmpresa(empresaNome.value)) {
            event.preventDefault();
            return;
          }
          if(!regexValidation.validatePais(pais.value.trim())) {
            event.preventDefault();
            return;
          }

          const empresaData = {
            nome: empresaNome.value,
            cnpj: cnpj.value,
            email: email.value,
            estado: estado.value,
            cep: cep.value,
            pais: pais.value,
            descricao: descricao.value,
            competencias: competenciasSelecionadas
          };

          localStorage.setItem('empresaData', JSON.stringify(empresaData));
          const storedEmpresaData = JSON.parse(localStorage.getItem('empresaData') || '{}');

          const emp = new Empresa(
              storedEmpresaData.nome,
              storedEmpresaData.email,
              storedEmpresaData.estado,
              storedEmpresaData.descricao,
              storedEmpresaData.competencias,
              storedEmpresaData.pais,
              storedEmpresaData.cep,
              storedEmpresaData.cnpj
          );

          ListaUser.empresas.push(emp);
          console.log('emp', emp);

          localStorage.setItem('EmpresasAtualizadas', JSON.stringify(ListaUser.empresas));

          alert('Empresa cadastrada com sucesso!');
          console.log('ListaUser empresas:', ListaUser.empresas);
        }
      });
    }
  }
}