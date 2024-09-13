import User from "./User";

export class Empresa extends User {
  private _pais: string;
  private _cnpj: string;
  private _competencias: string[];
  private _descricao: string;
  private _email: string;
  private _estado: string;
  private _nome: string;
  private _cep: string;

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
    this._pais = pais;
    this._cnpj = cnpj;
    this._competencias = competencias;
    this._descricao = descricao;
    this._email = email;
    this._estado = estado;
    this._nome = nome;
    this._cep = cep;
  }

  get pais(): string {
    return this._pais;
  }

  set pais(value: string) {
    this._pais = value;
  }

  get cnpj(): string {
    return this._cnpj;
  }

  set cnpj(value: string) {
    this._cnpj = value;
  }
  get cep(): string {
    return this._cep;
  }

  set cep(value: string) {
    this._cep = value;
  }

  get competencias(): string[] {
    return this._competencias;
  }

  set competencias(value: string[]) {
    this._competencias = value;
  }

  get descricao(): string {
    return this._descricao;
  }

  set descricao(value: string) {
    this._descricao = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get estado(): string {
    return this._estado;
  }

  set estado(value: string) {
    this._estado = value;
  }

  get nome(): string {
    return this._nome;
  }

  set nome(value: string) {
    this._nome = value;
  }

}

