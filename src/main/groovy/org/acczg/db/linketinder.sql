CREATE TABLE "candidatos" (
  "id" serial PRIMARY KEY,
  "nome" varchar(100) NOT NULL,
  "sobrenome" varchar(200) NOT NULL,
  "data_nascimento" date NOT NULL,
  "email" varchar(120) NOT NULL,
  "cpf" varchar(20) NOT NULL,
  "estado_id" int NOT NULL,
  "pais_id" varchar(40) NOT NULL,
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
  "nome" varchar(120) NOT NULL
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

ALTER TABLE "competencias_candidatos" ADD FOREIGN KEY ("id_candidato") REFERENCES "candidatos" ("id");

ALTER TABLE "competencias_vagas" ADD FOREIGN KEY ("id_vagas") REFERENCES "vagas" ("id");

ALTER TABLE "competencias_candidatos" ADD FOREIGN KEY ("id_competencias") REFERENCES "competencias" ("id");

ALTER TABLE "competencias_vagas" ADD FOREIGN KEY ("id_competencias") REFERENCES "competencias" ("id");

ALTER TABLE "vagas" ADD FOREIGN KEY ("empresa_id") REFERENCES "empresa" ("id");

ALTER TABLE "candidatos" ADD FOREIGN KEY ("pais_id") REFERENCES "pais" ("id");

ALTER TABLE "candidatos" ADD FOREIGN KEY ("estado_id") REFERENCES "estados" ("estado_id");

ALTER TABLE "empresa" ADD FOREIGN KEY ("pais_id") REFERENCES "pais" ("id");

ALTER TABLE "empresa" ADD FOREIGN KEY ("cep_id") REFERENCES "cep" ("id");

ALTER TABLE "empresa" ADD FOREIGN KEY ("estado_id") REFERENCES "estados" ("estado_id");

ALTER TABLE "match" ADD FOREIGN KEY ("candidato_id") REFERENCES "candidatos" ("id");

ALTER TABLE "match" ADD FOREIGN KEY ("vaga_id") REFERENCES "vagas" ("id");
