CREATE DATABASE MOV_CONTA_CORRENTE
GO

USE MOV_CONTA_CORRENTE
GO

CREATE TABLE AGENCIAS(
	NUM_AGE	NUMERIC(5,0) PRIMARY KEY identity(1,1) NOT NULL,
	NOME_AGE VARCHAR(30) NOT NULL,
	ENDE_AGE VARCHAR(50) NOT NULL,
	NUME_AGE VARCHAR(8),
	COMPL_AGE VARCHAR(20),
	BAIR_AGE VARCHAR(20),
	CIDA_AGE VARCHAR(30) NOT NULL,
	UF_AGE CHAR(2) NOT NULL,
	CEP_AGE CHAR(8) NOT NULL,
	FONE_AGE VARCHAR(13)
	)

CREATE TABLE CLIENTES(
	ID_CLI NUMERIC(9,0) PRIMARY KEY identity(1,1) NOT NULL,
	NOME_CLI VARCHAR(50) NOT NULL,
	ENDE_CLI VARCHAR(50) NOT NULL,
	NUME_CLI VARCHAR(8),
	COMPL_CLI VARCHAR(20),
	BAIR_CLI VARCHAR(20),
	CIDA_CLI VARCHAR(30) NOT NULL,
	UF_CLI CHAR(2) NOT NULL,
	CEP_CLI CHAR(8) NOT NULL,
	FONE_CLI VARCHAR(13),
	CPF_CLI CHAR(11),
	DATA_NASC DATETIME,
	CNPJ_CLI CHAR(14)
)

CREATE TABLE HISTORICOS(
	ID_HIS NUMERIC(4,0) PRIMARY KEY identity(1,1) NOT NULL,
	DES_HIS VARCHAR(30) NOT NULL
)

CREATE TABLE CONTACORRENTE(
	NUM_AGE NUMERIC(5,0) NOT NULL,
	NUM_CC NUMERIC(10,0) identity(1,1)  NOT NULL,
	ID_CLI NUMERIC(9,0) NOT NULL,
	SALDO NUMERIC(15,2),
	PRIMARY KEY (NUM_AGE,NUM_CC),
	CONSTRAINT FK_CONTACORRENTE_AGE FOREIGN KEY (NUM_AGE) REFERENCES AGENCIAS(NUM_AGE),
	CONSTRAINT FK_CONTACORRENTE_CLI FOREIGN KEY (ID_CLI) REFERENCES CLIENTES(ID_CLI)
)

CREATE TABLE USUARIOS(
	ID int PRIMARY KEY identity(1,1) NOT NULL,
	SENHA VARCHAR(20) NOT NULL,
	NUM_AGE NUMERIC(5,0) NOT NULL,
	NUM_CC NUMERIC(10,0) NOT NULL,
	CONSTRAINT FK_USUARIOS_CC FOREIGN KEY (NUM_AGE,NUM_CC) REFERENCES CONTACORRENTE(NUM_AGE,NUM_CC)
)

CREATE TABLE MOVIMENTACAO(
	NUM_AGE NUMERIC(5,0) NOT NULL,
	NUM_CC NUMERIC(10,0) NOT NULL,
	DATA_MOV DATETIME NOT NULL,
	NUM_DOCTO VARCHAR(6) NOT NULL,
	DEBITO_CREDITO CHAR(1) NOT NULL,
	ID_HIS NUMERIC(4,0) NOT NULL,
	COMPL_HIS VARCHAR(30),
	VALOR NUMERIC(9,2) NOT NULL,
	SALDO NUMERIC(15,2),
	PRIMARY KEY (NUM_AGE,NUM_CC,DATA_MOV,NUM_DOCTO),
	CONSTRAINT FK_MOVIMENTACAO_AGE FOREIGN KEY (NUM_AGE) REFERENCES AGENCIAS(NUM_AGE),
	CONSTRAINT FK_MOVIMENTACAO_CC FOREIGN KEY (NUM_AGE,NUM_CC) REFERENCES CONTACORRENTE(NUM_AGE,NUM_CC),
	CONSTRAINT FK_MOVIMENTACAO_HIS FOREIGN KEY (ID_HIS) REFERENCES HISTORICOS(ID_HIS)
)

select * from CLIENTES
select * from AGENCIAS
select * from CONTACORRENTE
select * from HISTORICOS
select * from MOVIMENTACAO
select * from USUARIOS

select * from MOVIMENTACAO where NUM_AGE = 8 and NUM_CC = 6 and ID_HIS = 10 and NUM_DOCTO = 123456
delete from MOVIMENTACAO where NUM_AGE = 8 and NUM_CC = 6 and ID_HIS = 10 and NUM_DOCTO = 123457