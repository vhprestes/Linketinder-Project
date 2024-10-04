# PROJETO LINKETINDER EM GROOVY - ACC ZG
<br/>

Esse é um projeto do programa Acelera ZG 6.0, aonde foi necessário criar um MVP do Linketinder em groovy.
Aqui tive o objetivo inicial de cumprir os requisitos solicitados no MVP, depois o código foi refatorado para melhorar legibilidade e manutenção.
Feito por Victor Hugo S P Martins
<br/>


## Tecnologias utilizadas:
Groovy Version: 4.0.22 JVM: 1.8.0_422

PostgreSQL 14.13 (Ubuntu 14.13-0ubuntu0.22.04.1)
<br/>

## Atenção
[Para rodar a aplicação, é necessário instalar o groovy](https://groovy-lang.org/install.html)
[Também é necessário instalar o postgresql, nesse projeto foi utilizado a versão mais recente na data do desenvolvimento](https://www.postgresql.org/download/)


# Instruções para rodar o projeto


Primeiramente, clone o projeto através do comando

````bash
git clone git@github.com:vhprestes/Linketinder-Project.git
````


## Backend

1) Certifique-se de estar no diretório correto
**/linketinder-project

2) estrutura do projeto se encontra da seguinte forma:


```tree
src/
└── main/
    └── groovy/
        └── org.acczg/
            ├── controller/
            │   ├── ControllerCandidatos.groovy
            │   ├── ControllerCompetencias.groovy
            │   ├── ControllerEmpresas.groovy
            │   └── ControllerVagas.groovy
            ├── DAO/
            │   ├── CandidatoDAO.groovy
            │   ├── CompetenciaDAO.groovy
            │   ├── EmpresaDAO.groovy
            │   └── VagaDAO.groovy
            ├── models/
            │   ├── Candidato.groovy
            │   ├── Competencia.groovy
            │   ├── Empresa.groovy
            │   └── Vaga.groovy
            ├── service/
            │   ├── CandidatoService.groovy
            │   ├── CompetenciaService.groovy
            │   ├── EmpresaService.groovy
            │   └── VagaService.groovy
            ├── views/
            │   ├── MenuCandidatos.groovy
            │   ├── MenuCompetencias.groovy
            │   ├── MenuEmpresas.groovy
            │   └── MenuVagas.groovy
            └── Main.groovy
```

Aonde:
- Controller: Responsável por controlar as requisições e respostas da aplicação, recebendo os dados do user
- DAO: Responsável por fazer a comunicação com o banco de dados
- Models: Responsável por representar as entidades do banco de dados
- Service: Responsável por fazer a comunicação entre o Controller e o DAO
- Views: Responsável por mostrar as opções disponíveis para o usuário
- Main: Responsável por iniciar a aplicação


3) Para executar o projeto idealmente precisamos de uma IDE, onde basta abrir o Main.groovy e clicar em executar. 


4) Caso haja a necessidade de compilar o com o groovyc:
   -Abra um terminal na raiz do projeto e execute o comando para compilar os arquivos Groovy

````bash
groovyc -d out src/main/groovy/org/acczg/**/*.groovy
````

5) Rode o comando para executar a aplicação:
````bash
groovy -cp out out/org/acczg/Main.class
````

## Frontend

1) Após clonar o repositório, Acesse a pasta frontend
```bash
cd frontend
```
2) Instale as dependências
```bash
npm install
```
3) Builde o projeto
```bash
npm run build
```
4) rode /src/index.html no seu navegador de preferência. Aqui, usaremos o google-chrome
```bash
google-chrome src/index.html
```