DROP DATABASE IF EXISTS bdifarm;

create database if not exists bdifarm;

use bdifarm;

CREATE TABLE cooperado (
    nome_cooperado varchar(40),
    cpf varchar(15) PRIMARY KEY, 
    endereco varchar(40),
    telefone varchar(20)
);

CREATE TABLE empresa_parceira (
	cnpj varchar(20) PRIMARY KEY,
    nome_empresa varchar(40),
    contato_empresa varchar(255)
);

create table concessao_credito (
    id_concessao INT PRIMARY KEY auto_increment,
	cpf_cooperado varchar(15),
	cnpj_parceira varchar(20),
	valor BIGINT,
	dt_concessao varchar(10),
	FOREIGN KEY(cpf_cooperado) REFERENCES cooperado(cpf),
	FOREIGN KEY(cnpj_parceira) REFERENCES empresa_parceira(cnpj)
);

CREATE TABLE evento (
    id_evento INT PRIMARY KEY auto_increment,
    nome varchar(60),
    tipo varchar(15),
    cpf_cooperado varchar(15),
    FOREIGN KEY(cpf_cooperado) REFERENCES cooperado(cpf)
);

CREATE TABLE pedido (
    id_pedido INT PRIMARY KEY auto_increment,
    dt_entrega varchar(15),
    tipo_pedido varchar(40),
	status varchar(30),
    valor_total float(7,2),
    cnpj_cliente varchar(20)
);

CREATE TABLE produto (
    id_produto INT PRIMARY KEY auto_increment,
    nome_produto varchar(30),
    quantidade INT,
    categoria varchar(30)
);

create table produto_pedido (
	id_pedido INT,
	id_produto INT,
	quantidade INT,
	valor_total BIGINT,
	FOREIGN KEY(id_pedido) REFERENCES pedido(id_pedido),
	FOREIGN KEY(id_produto) REFERENCES pedido(id_pedido)
);
