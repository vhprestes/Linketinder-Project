import User from "./User";

export class Empresa extends User {
  constructor(
      nome: string,
      email: string,
      estado: string,
      descricao: string,
      competencias: string[],
      cep: string,
      pais: string,
      cnpj: string) {
    super(nome, email, estado, descricao, competencias, cep);
  }

  get pais(): string {
    return this.pais;
  }

  set pais(value: string) {
    this.pais = value;
  }

  get cnpj(): string {
    return this.cnpj;
  }

  set cnpj(value: string) {
    this.cnpj = value;
  }
}