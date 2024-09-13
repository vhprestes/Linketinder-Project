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
    {
      nome: "RC PERFORMANCE LTDA",
      email: "rcperformance@email.com",
      estado: "RJ",
      descricao: "Empresa de tecnologia, com foco em desenvolvimento de software de alta performance",
      competencias: ["Java", "Python"],
      cep: "26600000",
      pais: "Brasil",
      cnpj: "11222333000999"
    },
    {
      nome: "WEBUDDIES LTDA",
      email: "contado@webuddies.com",
      estado: "RJ",
      descricao: "startup focada em web",
      competencias: ["TypeScript", "JavaScript"],
      cep: "2660000",
      pais: "Brasil",
      cnpj: "22233344000111",
    },

    {
      nome: "Pereira LTDAH",
      email: "pereira@ltdah.com",
      estado: "RJ",
      descricao: "Focada em tecnologias no combate ao TDAH",
      competencias: ["JavaScript", "TypeScript", "Groovy", "Java"],
      cep: "95044000",
      pais: "Brasil",
      cnpj: "33344455000222",
    },

    {
      nome: "Paracatech",
      email: "contato@paraca.tech",
      estado: "RJ",
      descricao: "Empresa regional de tecnologia",
      competencias: ["Java", "TypeScript", "Angular"],
      cep: "26600000",
      pais: "Brasil",
      cnpj: "44455566000333",
    },

    {
      nome: "Teclabs",
      email: "oi@teclabs.com",
      estado: "GO",
      descricao: "Empresa de testes de software e hardware",
      competencias: ["Angular", "Python", "TypeScript"],
      cep: "72000000",
      pais: "Brasil",
      cnpj: "55666777000188",
    },
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
}