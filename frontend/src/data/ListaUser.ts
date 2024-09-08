import { Candidato} from "../scripts/Interfaces/Candidato";
import { Empresa} from "../scripts/Interfaces/Empresa";

export class ListaUser {

  public static candidatos: Candidato[] = [
    {
      nome: "Brenda Lima e Silva",
      email: "brenda@linda",
      estado: "RJ",
      descricao: "Inteligente, responsavel, minha pessoa favorita",
      competencias: ["Java", "Groovy", "Python"],
      cep: "26600000",
      cpf: "11122233344",
      idade: "20",
    },
    {
      nome: "Julia Marias",
      email: "julia@maria.com",
      estado: "PE",
      descricao: "gente boa",
      competencias: ["TypeScript", "JavaScript"],
      cep: "23812-310",
      cpf: "22233344455",
      idade: "25",
    },

    {
      nome: "Ana Helena",
      email: "ana@helena.com",
      estado: "BA",
      descricao: "Pessoa empolgante, calma e comunicativa",
      competencias: ["JavaScript", "Angular", "Scrumban"],
      cep: "44700000",
      cpf: "33344455566",
      idade: "40",
    },

    {
      nome: "Renato Russo",
      email: "renato@russo.com",
      estado: "DF",
      descricao: "Cantor e compositor, super antenado em tecnologia",
      competencias: ["Java", "Angular", "Javascript"],
      cep: "70040010",
      cpf: "44455566677",
      idade: "41",
    },

    {
      nome: "Airton Senna",
      email: "seninha@fast.com",
      estado: "SP",
      descricao: "Piloto de formula 1, super rapido e eficiente",
      competencias: ["Angular", "Python"],
      cep: "11533400",
      cpf: "55566677788",
      idade: "38"
    },
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
}