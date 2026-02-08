create table funcionarioInterno(
cpf CHAR (11) NOT NULL,
nome VARCHAR (100) NOT NULL,
dataNascimento  CHAR(15) NOT NULL,
cargo VARCHAR (100) NOT NULL,
matricula CHAR (11) NOT NULL,
salario VARCHAR (100) NOT NULL,
PRIMARY KEY (cpf)
);

select * from funcionarioInterno;

insert into funcionarioInterno (cpf, nome, dataNascimento, cargo, matricula, salario) values ('031', 'Joenio', '11/10/1992', 'Gerente', '001', '1000'); -- inserir dados

DELETE FROM funcionarioInterno
WHERE cpf = '031';

UPDATE funcionarioInterno -- alterar dados
SET nome = 'teste'
WHERE cpf = '032';