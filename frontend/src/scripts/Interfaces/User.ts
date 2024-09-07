export default class User {
  constructor(
      nome: string,
      email: string,
      estado: string,
      descricao: string,
      competencias: string[],
      cep: string) {
  }

  get nome(): string {
    return this.nome;
  }

  set nome(value: string) {
    this.nome = value;
  }

  get email(): string {
    return this.email;
  }

  set email(value: string) {
    this.email = value;
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

  get cep(): string {
    return this.cep;
  }

  set cep(value: string) {
    this.cep = value;
  }
}