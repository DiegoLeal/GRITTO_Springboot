create table usuario (
	id bigint not null auto_increment,
	nome varchar(145) not null,
    rg varchar(15),
    cpf varchar(14),
    data_nascimento date,
    telefone varchar(45),
    senha varchar(60),
	email varchar(255),
	sexo varchar(20),
	primary key (id)
);