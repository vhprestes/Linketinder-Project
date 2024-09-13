import User from "./User";

export class Candidato extends User {
  private _cpf: string;
  private _idade: string;
  private _cep: string;
  private _competencias: string[];
  private _descricao: string;
  private _email: string;
  private _estado: string;
  private _nome: string;

  constructor(
      nome: string,
      email: string,
      estado: string,
      descricao: string,
      competencias: string[],
      cep: string,
      cpf: string,
      idade: string
  ) {
    super(nome, email, estado, descricao, competencias, cep);
    this._cpf = cpf;
    this._idade = idade;
    this._cep = cep;
    this._competencias = competencias;
    this._descricao = descricao;
    this._email = email;
    this._estado = estado;
    this._nome = nome;
  }

  get cpf(): string {
    return this._cpf;
  }

  set cpf(value: string) {
    this._cpf = value;
  }

  get idade(): string {
    return this._idade;
  }

  set idade(value: string) {
    this._idade = value;
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