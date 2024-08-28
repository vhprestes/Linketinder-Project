# PROJETO LINKETINDER EM GROOVY - ACC ZG
<br/>

Esse é um projeto do programa Acelera ZG 6.0, aonde foi necessário criar um MVP do Linketinder em groovy.
Aqui tive o objetivo inicial de cumprir os requisitos solicitados no MVP, depois o código foi refatorado para melhorar legibilidade e manutenção.
Feito por Victor Hugo S P Martins
<br/>


## Tecnologias utilizadas:
Groovy Version: 4.0.22 JVM: 1.8.0_422 
<br/>

## Atenção
[Para rodar a aplicação, é necessário instalar o groovy](https://groovy-lang.org/install.html)


<br/>


## Instruções para rodar o projeto

1) Primeiramente, clone o projeto através do comando 

````bash
git clone git@github.com:vhprestes/Linketinder-Project.git
````

Então: 
2) Certifique-se de estar no diretório correto
**/linketinder-project

3) A estrutura do projeto se encontra da seguinte forma:


```tree
src/
└── main/
    └── groovy/
        └── org.acczg/
            ├── entities/
            ├── models/
            ├── utils/
            └── Main.groovy
```


Para executar o projeto idealmente precisamos de uma IDE, onde basta abrir o Main.groovy e clicar em executar. 


4) Caso haja a necessidade de compilar o com o groovyc:
   -Abra um terminal na raiz do projeto e execute o comando para compilar os arquivos Groovy

````bash
groovyc -d out src/main/groovy/org/acczg/**/*.groovy
````

5) Rode o comando para executar a aplicação:
````bash
groovy -cp out out/org/acczg/Main.class
````
