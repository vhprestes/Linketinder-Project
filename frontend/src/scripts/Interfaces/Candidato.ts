import User from "./User";

export class Candidato extends User {
  constructor(
      nome: string,
      email: string,
      estado: string,
      descricao: string,
      competencias: string[],
      cep: string,
      cpf: string,
      idade: string) {
    super(nome, email, estado, descricao, competencias, cep);
  }

  get cpf(): string {
    return this.cpf;
  }

  set cpf(value: string) {
    this.cpf = value;
  }

  get idade(): string {
    return this.idade;
  }

  set idade(value: string) {
    this.idade = value;
  }
}