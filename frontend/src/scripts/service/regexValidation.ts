export class regexValidation {

  /*
  validações usando REGEX:
  ok nome: min 5 caracteres, máximo 50 caracteres;
  ok email: padrão de email;
  ok estado: maximo 30 caracteres apenas letras;
  ok descricao: maximo 200 caracteres, minimo 10 caracteres;
  ok idade: 2 digitos;
  ok cep: formato ddddd-ddd (d = digito) OU dddddddd;
  ok cpf: formato ddd.ddd.ddd-dd (d = digito) OU ddddddddddd;
  pais: maximo 30 caracteres apenas letras;
  cpf: formato dd.ddd.ddd/dddd-dd (d = digito);
  nome empresa: 5 a 50 caracteres permitido digitos e letras;
   */

  public static validateNome(nome: string): boolean {
    const nomeRegex = /^[a-zA-Z]{5,50}$/;
    if (!nomeRegex.test(nome)) {
      alert('Nome inválido! O nome deve conter entre 5 e 50 caracteres simples.');
    }
    return nomeRegex.test(nome);
  }

  public static validateNomeEmpresa(nome: string): boolean {
        const nomeRegex = /^[a-zA-Z0-9\s]{5,50}$/;
    if (!nomeRegex.test(nome)) {
      alert('Nome inválido! O nome deve conter entre 5 e 50 caracteres entre números e letras.');
    }
    return nomeRegex.test(nome);
  }


  public static validateEmail(email: string): boolean {
    const emailRegex = /^[\w-._]+@([\w-]+\.)+[\w-]{2,4}$/;
    if (!emailRegex.test(email)) {
      alert('Email inválido! O email deve ser no formato email@teste.com');
    }
      return emailRegex.test(email);

  }

  public static validateEstado(estado: string): boolean {
    const estadoRegex = /^[a-zA-Z]{1,25}$/;
    if (!estadoRegex.test(estado)) {
      alert('Estado inválido! O estado deve conter no máximo 25 caracteres.');
    }
    return estadoRegex.test(estado);
  }
  public static validateDescricao(descricao: string): boolean {
    const descricaoRegex = /^.{10,200}$/;
    if (!descricaoRegex.test(descricao)) {
      alert('Descrição inválida! A descrição deve conter entre 10 e 200 caracteres.');
    }
    return descricaoRegex.test(descricao);
  }

  public static validateCEP(cep: string): boolean {
    const cepRegex = /^\d{5}-?\d{3}$/;
    if (!cepRegex.test(cep)) {
      alert('CEP inválido! O CEP deve ser no formato 99999-999 ou 99999999');
    }
    return cepRegex.test(cep);
  }

  public static validateCpf(cpf: string): boolean {
    const cpfRegex = /^\d{3}\.?\d{3}\.?\d{3}-?\d{2}$/;
    return cpfRegex.test(cpf);
  }

  public static validateCnpj(cnpj: string): boolean {
    const cnpjRegex = /^\d{2}\.?\d{3}\.?\d{3}\/?\d{4}-?\d{2}$/;
    return cnpjRegex.test(cnpj);
  }

  public static validateIdade(idade: string): boolean {
    const idadeRegex = /^\d{2}$/;
    return idadeRegex.test(idade);
  }

  public static validatePais(pais: string): boolean {
    const paisRegex = /^[a-zA-Z]{1,30}$/;
    return paisRegex.test(pais);
  }


  static validarCandidatoFormData(nome: string, email: string, estado: string, descricao: string, cep: string, cpf: string, idade: string): boolean {
    const validator = [
      this.validateNome(nome),
      this.validateEmail(email),
      this.validateEstado(estado),
      this.validateDescricao(descricao),
      this.validateCEP(cep),
      this.validateCpf(cpf),
      this.validateIdade(idade)
    ];
    return validator.every((value) => value);
  }

  static validarEmpresaFormData(nome: string, email: string, estado: string, descricao: string, cep: string, cnpj: string, pais: string): boolean {
    const validator = [
      this.validateNomeEmpresa(nome),
      this.validateEmail(email),
      this.validateEstado(estado),
      this.validateDescricao(descricao),
      this.validateCEP(cep),
      this.validateCnpj(cnpj),
      this.validatePais(pais)
    ];
    return validator.every((value) => value);
  }




}