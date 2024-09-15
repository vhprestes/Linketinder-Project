export class regexValidation {


  public static validateNome(nome: string): boolean {
    const nomeRegex = /^[a-zA-Z\s]{5,50}$/;
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
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z]+[^@?%&#$]\.[a-zA-Z]+(\.[a-zA-Z]+)?$/;
    if (!emailRegex.test(email)) {
      alert('Email inválido! O email deve conter um @ e um .');
    }
      return emailRegex.test(email);

  }

  public static validateEstado(estado: string): boolean {
    const estadoRegex = /^[a-zA-Z\s]{2,25}$/;
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
    const cepRegex = /^\d{5}-?\d{3}$/; // Aceita CEP no formato 12345-678 ou 12345678
    if (!cepRegex.test(cep)) {
      alert('CEP inválido! O CEP deve conter 8 dígitos.');
    }
    return cepRegex.test(cep);
  }

  public static validateCpf(cpf: string): boolean {
    const cpfRegex = /^\d{3}\.?\d{3}\.?\d{3}-?\d{2}$/;
    if (!cpfRegex.test(cpf)) {
      alert('CPF inválido! O CPF deve conter 11 dígitos.');
    }
    return cpfRegex.test(cpf);
  }

  public static validateCnpj(cnpj: string): boolean {
    const cnpjRegex = /^\d{2}\.?\d{3}\.?\d{3}\/?\d{4}-?\d{2}$/;
    if (!cnpjRegex.test(cnpj)) {
      alert('CNPJ inválido! O CNPJ deve conter 14 dígitos.');
    }
    return cnpjRegex.test(cnpj);
  }

  public static validateIdade(idade: string): boolean {
    const idadeRegex = /^\d{2}$/;
    if (!idadeRegex.test(idade)) {
      alert('Idade inválida! A idade deve conter 2 dígitos.');
    }
    return idadeRegex.test(idade);
  }

  public static validatePais(pais: string): boolean {
    const paisRegex = /^[a-zA-Z\s]{2,50}$/;
    if (!paisRegex.test(pais)) {
      alert('País inválido! O país deve conter no máximo 50 caracteres.');
    }
    return paisRegex.test(pais);
  }

}