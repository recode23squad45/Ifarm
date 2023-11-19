DROP DATABASE IF EXISTS bdifarm;

create database if not exists bdifarm;

use bdifarm;

CREATE TABLE produtor (
    nome_produtor varchar(40),
    CPF varchar(15) PRIMARY KEY,
    endereco varchar(40),
    telefone varchar(20)
);

CREATE TABLE parceiro (
	id_parceiro INT PRIMARY KEY auto_increment,
    nome_parceiro varchar(40),
    CPF varchar(15),
    FOREIGN KEY(CPF) REFERENCES produtor(CPF)
);

CREATE TABLE evento (
    id_evento INT PRIMARY KEY auto_increment,
    nome varchar(60),
    tipo varchar(15),
    CPF varchar(15),
    FOREIGN KEY(CPF) REFERENCES produtor(CPF)
);

CREATE TABLE pedido (
    id_pedido INT PRIMARY KEY auto_increment,
    dt_entrega varchar(15),
    tipo_pedido varchar(40),
	status varchar(30),
    valor_total float(7,2),
    CPF varchar(15),
    FOREIGN KEY(CPF) REFERENCES produtor(CPF)
);

CREATE TABLE produto (
    id_produto INT PRIMARY KEY auto_increment,
    nome_produto varchar(30),
    quantidade INT,
    categoria varchar(30),
    id_pedido INT,
    FOREIGN KEY(id_pedido) REFERENCES pedido(id_pedido)
);

-- salvando(create) os dados

insert into produtor (nome_produtor, CPF, endereco, telefone) values

('Fernando da Silva', '12812812812', 'Rua das flores', '86994368323'),
('Leonardo Batista', '12812812823', 'Beco 03', '65994368234');


insert into parceiro (nome_parceiro, CPF) values

('Fernandes frutas S/A', '12812812812'),
('Companhia Melhores Laticinios', '12812812823');


insert into evento (nome, tipo, CPF) values

('Tecnologia e inovação na agricultura', 'Palestra', '12812812812'),
('Instruções técnicas para cultivo comercial', 'Minicurso', '12812812823'); 

insert into pedido (dt_entrega, tipo_pedido, status, valor_total, CPF ) values

('18/09/2023', 'compra de hortifruti', 'pendente de transporte', 500.00, '12812812812'),
('02/07/2024', 'solicitação de emprestimo', 'pendente de deposito', 5000.00, '12812812823');


insert into produto (nome_produto, quantidade, categoria, id_pedido) values 

('Tomate', 500, 'fruta', default),
('Cebola', 600, 'verdura', default);

 

-- consulta(read) dos dados

select * from parceiro;

select * from produtor;

select * from evento;

select * from pedido;

select * from produto;

 
-- atualizando(updade) os dados
UPDATE produtor SET nome_produtor = 'Daniel Tavares', endereco = 'Rua 10', telefone = '93995069000' WHERE CPF = '12812812823';
UPDATE parceiro SET nome_parceiro = 'Banco MGA'  WHERE CPF = '12812812823';
UPDATE evento SET nome = 'atividade prática na agricultura',tipo = 'atividade' WHERE CPF = '12812812823';
UPDATE pedido SET dt_entrega = '10/09/2023', tipo_pedido = 'compra de material',status = 'cancelado',valor_total = 956.00 WHERE id_pedido = 2;
UPDATE produto SET nome_produto = 'cenoura', quantidade = 100,  categoria = 'verdura' WHERE id_produto = 2;

 

-- deletando(delete) os dados
DELETE FROM produtor WHERE CPF = '93995069000';
DELETE FROM parceiro WHERE id_parceiro = 2;
DELETE FROM evento WHERE id_evento = 2;
DELETE FROM pedido WHERE id_pedido = 2;
DELETE FROM produto WHERE id_produto = 2;