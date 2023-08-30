create table aluno(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(11) not null unique,
    curso varchar (50) not null,
    logradouro varchar(100) not null,
    bairro varchar(60) not null,
    cep varchar(9) not null,
    cidade varchar(50) not null,
    uf varchar (2) not null,
    complemento varchar(80),
    numero varchar(20),
    status tinyint,

    primary key (id)

);