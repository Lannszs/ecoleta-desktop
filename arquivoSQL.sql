CREATE TABLE ponto(
	id_ponto serial not null primary key,
	nome varchar(100) not null,
	email varchar(100) not null,
	cidade varchar(100) not null unique,
	latitude numeric(50) not null,
	longetude numeric(50) not null
)
