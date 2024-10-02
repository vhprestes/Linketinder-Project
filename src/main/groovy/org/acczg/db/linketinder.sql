CREATE TABLE "candidatos" (
  "id" serial PRIMARY KEY,
  "nome" varchar(100) NOT NULL,
  "sobrenome" varchar(200) NOT NULL,
  "data_nascimento" date NOT NULL,
  "email" varchar(120) NOT NULL,
  "cpf" varchar(20) NOT NULL,
  "estado_id" int NOT NULL,
  "pais_id" int NOT NULL,
  "cep" varchar(20) NOT NULL,
  "descricao" varchar(200) NOT NULL,
  "senha" varchar(120) NOT NULL
);

CREATE TABLE "competencias_candidatos" (
  "id_competencias" integer,
  "id_candidato" integer
);

CREATE TABLE "competencias" (
  "id" serial PRIMARY KEY,
  "competencia" varchar(100) NOT NULL
);

CREATE TABLE "competencias_vagas" (
  "id_competencias" integer,
  "id_vagas" integer
);

CREATE TABLE "vagas" (
  "id" serial PRIMARY KEY,
  "nome" varchar(255) NOT NULL,
  "descricao" text NOT NULL,
  "cidade" varchar(120) NOT NULL,
  "empresa_id" int
);

CREATE TABLE "empresa" (
  "id" serial PRIMARY KEY,
  "nome" varchar(120) NOT NULL,
  "descricao" text,
  "cnpj" varchar(18) NOT NULL,
  "email" varchar(100) NOT NULL,
  "pais_id" int NOT NULL,
  "cep" varchar(20) NOT NULL,
  "senha" varchar(120) NOT NULL,
  "estado_id" int NOT NULL
);

CREATE TABLE "cidades" (
  "cidade_id" serial PRIMARY KEY,
  "nome" varchar(120) NOT NULL,
  "estado_id" int
);

CREATE TABLE "estados" (
  "estado_id" serial PRIMARY KEY,
  "nome" varchar(120) NOT NULL,
  "uf" varchar(2) NOT NULL
);

CREATE TABLE "pais" (
  "id" serial PRIMARY KEY,
  "nome" varchar(100) NOT NULL
);


CREATE TABLE "match" (
  "match_id" serial PRIMARY KEY,
  "candidato_id" int,
  "vaga_id" int
);

ALTER TABLE "competencias_candidatos" ADD FOREIGN KEY ("id_candidato") REFERENCES "candidatos" ("id") ON DELETE CASCADE;

ALTER TABLE "competencias_candidatos" ADD FOREIGN KEY ("id_competencias") REFERENCES "competencias" ("id");

ALTER TABLE "competencias_vagas" ADD FOREIGN KEY ("id_vagas") REFERENCES "vagas" ("id") ON DELETE CASCADE;

ALTER TABLE "competencias_vagas" ADD FOREIGN KEY ("id_competencias") REFERENCES "competencias" ("id");

ALTER TABLE "vagas" ADD FOREIGN KEY ("empresa_id") REFERENCES "empresa" ("id") ON DELETE CASCADE;

ALTER TABLE "candidatos" ADD FOREIGN KEY ("pais_id") REFERENCES "pais" ("id");

ALTER TABLE "candidatos" ADD FOREIGN KEY ("estado_id") REFERENCES "estados" ("estado_id");

ALTER TABLE "empresa" ADD FOREIGN KEY ("pais_id") REFERENCES "pais" ("id");

-- ALTER TABLE "empresa" ADD FOREIGN KEY ("cep_id") REFERENCES "cep" ("id");

ALTER TABLE "empresa" ADD FOREIGN KEY ("estado_id") REFERENCES "estados" ("estado_id");

ALTER TABLE "match" ADD FOREIGN KEY ("candidato_id") REFERENCES "candidatos" ("id");

ALTER TABLE "match" ADD FOREIGN KEY ("vaga_id") REFERENCES "vagas" ("id");



INSERT INTO  "pais" ("nome") VALUES ('Brasil');


-- TODO: Verificar se é necess´ario mesmo usar estados ou deixar só uma string
INSERT INTO "estados" (uf, nome)
VALUES
    ('AC', 'Acre'),
    ('AL', 'Alagoas'),
    ('AP', 'Amapá'),
    ('AM', 'Amazonas'),
    ('BA', 'Bahia'),
    ('CE', 'Ceará'),
    ('DF', 'Distrito Federal'),
    ('ES', 'Espírito Santo'),
    ('GO', 'Goiás'),
    ('MA', 'Maranhão'),
    ('MT', 'Mato Grosso'),
    ('MS', 'Mato Grosso do Sul'),
    ('MG', 'Minas Gerais'),
    ('PA', 'Pará'),
    ('PB', 'Paraíba'),
    ('PR', 'Paraná'),
    ('PE', 'Pernambuco'),
    ('PI', 'Piauí'),
    ('RJ', 'Rio de Janeiro'),
    ('RN', 'Rio Grande do Norte'),
    ('RS', 'Rio Grande do Sul'),
    ('RO', 'Rondônia'),
    ('RR', 'Roraima'),
    ('SC', 'Santa Catarina'),
    ('SP', 'São Paulo'),
    ('SE', 'Sergipe'),
    ('TO', 'Tocantins');

INSERT INTO "empresa" (nome, descricao, cnpj, email, pais_id, cep, senha, estado_id)
VALUES
    ('Sandubas Samdubinhas', 'sandubas tecnologicos',  '12345678901234', 'sandubsubs@food.com', 1, '12345678', '123456', 9 ),
    ('Pizzaria Tech','pizzas com alta tecnologia', '23456789012345', 'techizzas@tech.com', 1, 22660000, '123456', 2),
    ('Cafeteria Home office', 'cafeteria para seu home office', '34567890123456', 'techcoffe@gmail.com', 1, 22660000, '123456', 19),
    ('Lab tech LTDA', 'laboratorio de tecnologia','45678901234567', 'simples@tech.com', 1, 22660000, '123456', 19),
    ('Tech Jobs for everyone', 'plaza de empregos para devs', '56789012345678', 'recruiters@tech.job.com', 1, 22660000, '123456', 19);

INSERT INTO "competencias" (competencia)
VALUES
    ('Java'),
    ('Groovy'),
    ('Python'),
    ('Javascript'),
    ('Typescript'),
    ('Angular'),
    ('Web Crawler');

INSERT INTO "candidatos" (nome, sobrenome, data_nascimento, email, cpf, estado_id, pais_id, cep, descricao, senha)
VALUES
    ('João', 'Silva', '01/10/2001', 'joao@silva.com', '13433300150' , 19, 1, '26600000', 'Dev gente boa', '123456'),
    ('Sandubinha', 'Subs', '01/12/1990', 'sandubasso@gmail.com', '13488832159', 19, 1, '26600000', 'Dev amante de sandubas', '123456'),
    ('Leo', 'Techniatlo', '01/02/1998', 'leozinhotech@gmail.com', '1345500150', 19, 1, '26600000', 'Dev amante de tecnologia', '123456'),
    ('Breno', 'Coffe', '01/02/2004', 'meumelhor@email.com', '99955549350', 9, 1, '12345678', 'Dev amante de café', '123456'),
    ('Lucio', 'Malfoy', '17/03/1961', 'lucio@malfoy.com', '64644422201', 19, 1, '26600000', 'Dev comensal da morte', '123456');


INSERT INTO "competencias_candidatos" (id_competencias, id_candidato)
VALUES
    (1, 1),
    (4, 1),
    (7, 1),
    (2, 2),
    (2, 3),
    (2, 4),
    (6, 3),
    (4, 3),
    (1, 4),
    (5, 4),
    (3, 5),
    (4, 5),
    (6, 5);

