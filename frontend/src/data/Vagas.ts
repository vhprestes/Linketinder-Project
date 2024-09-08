export class Vagas {

  constructor(
      nome: string,
      estado: string,
      descricao: string,
      competencias: string[]){
  }

  get nome(): string {
    return this.nome;
  }

  set nome(value: string) {
    this.nome = value;
  }

  get estado(): string {
    return this.estado;
  }

  set estado(value: string) {
    this.estado = value;
  }

  get descricao(): string {
    return this.descricao;
  }

  set descricao(value: string) {
    this.descricao = value;
  }

  get competencias(): string[] {
    return this.competencias;
  }

  set competencias(value: string[]) {
    this.competencias = value;
  }


  // mockzinho
  public static vagas: Vagas[] = [
    {
      nome: "Desenvolvedor front-end",
      estado: "GO",
      descricao: "Desenvolvimento front end focado em UI/UX",
      competencias: [],
    },
    {
      nome: "Desenvolvedor backend",
      estado: "RJ",
      descricao: "Desenvolvedor backend focado em performance",
      competencias: [],
    },
    {
      nome: "Desenvolvedor fullstack",
      estado: "PR",
      descricao: "Desenvolvedor fullstack generalista",
      competencias: [],
    },
    {
      nome: "Desenvolvedor Front-End",
      estado: "MG",
      descricao: "Dev Front-End focado em integrações",
      competencias: [],
    },
    {
      nome: "Desenvolvedor Full-Stack",
      estado: "RJ",
      descricao: "Preferencia por Front-End mas também trabalho com Back-End",
      competencias: [],
    },
  ];

}