import { Candidato} from "../scripts/Interfaces/Candidato";
import { Empresa} from "../scripts/Interfaces/Empresa";

export class ListaUser {

  public static candidatos: Candidato[] = [
    new Candidato(
        "José da Silva",
        "jose@gmail.com",
        "RJ",
        "Pessoa super comunicativa e empolgante",
        ["Java", "Groovy", "Python"],
        "26600000",
        "11122233344",
        "20"
    ),
    new Candidato(
        "Julia Marias",
        "julia@maria.com",
        "PE",
        "gente boa",
        ["TypeScript", "JavaScript"],
        "23812-310",
        "22233344455",
        "25"
    ),
    new Candidato(
        "Ana Helena",
        "ana@helena.com",
        "BA",
        "Pessoa empolgante, calma e comunicativa",
        ["JavaScript", "Angular"],
        "44700000",
        "33344455566",
        "40"
    ),
    new Candidato(
        "Renato Russo",
        "renato@russo.com",
        "DF",
        "Cantor e compositor, super antenado em tecnologia",
        ["Java", "Angular", "Javascript"],
        "70040010",
        "44455566677",
        "41"
    ),
    new Candidato(
        "Airton Senna",
        "seninha@fast.com",
        "SP",
        "Piloto de formula 1, super rapido e eficiente",
        ["Angular", "Python"],
        "11533400",
        "55566677788",
        "38"
    ),
  ];

    public static empresas: Empresa[] = [
    new Empresa(
        "RC PERFORMANCE LTDA",
        "rcperformance@email.com",
        "RJ",
        "Empresa de tecnologia, com foco em desenvolvimento de software de alta performance",
        ["Java", "Python"],
        "26600000",
        "Brasil",
        "11222333000999"
    ),
    new Empresa(
        "WEBUDDIES LTDA",
        "contado@webuddies.com",
        "RJ",
        "startup focada em web",
        ["TypeScript", "JavaScript"],
        "2660000",
        "Brasil",
        "22233344000111"
    ),
    new Empresa(
        "Pereira LTDAH",
        "pereira@ltdah.com",
        "RJ",
        "Focada em tecnologias no combate ao TDAH",
        ["JavaScript", "TypeScript", "Groovy", "Java"],
        "95044000",
        "Brasil",
        "33344455000222"
    ),
    new Empresa(
        "Paracatech",
        "contato@paraca.tech",
        "RJ",
        "Empresa regional de tecnologia",
        ["Java", "TypeScript", "Angular"],
        "26600000",
        "Brasil",
        "44455566000333"
    ),
    new Empresa(
        "Teclabs",
        "oi@teclabs.com",
        "GO",
        "Empresa de testes de software e hardware",
        ["Angular", "Python", "TypeScript"],
        "72000000",
        "Brasil",
        "55666777000188"
    ),
  ];


  public static loadCandidatosFromLocalStorage() {
    const savedCandidatos = JSON.parse(localStorage.getItem('CandidadosAtualizados') || '[]');
    if (savedCandidatos.length > 4) {
      this.candidatos = savedCandidatos.map((c: any) => new Candidato(
          c._nome,
          c._email,
          c._estado,
          c._descricao,
          c._competencias,
          c._cep,
          c._cpf,
          c._idade
      ));
    }
  }


  public static loadEmpresasFromLocalStorage() {
    const savedEmpresas = JSON.parse(localStorage.getItem('EmpresasAtualizadas') || '[]');
    if (savedEmpresas.length > 0) {
      this.empresas = savedEmpresas.map((e: any) => new Empresa(
          e._nome,
          e._email,
          e._estado,
          e._descricao,
          e._competencias,
          e._cep,
          e._pais,
          e._cnpj
      ));
    }
  }
}