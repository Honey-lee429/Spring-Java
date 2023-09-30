create table medico(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    especialidade varchar(100) not null,
    logradouro varchar(20),
    bairro varchar(100),
    cep varchar(9),
    complemento varchar(100),
    numero varchar(20) not null,
    uf char(2),
    cidade varchar(100),

    primary key(id)

);