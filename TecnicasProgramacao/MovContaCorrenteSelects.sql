use MOV_CONTA_CORRENTE

select * from CLIENTES
select * from AGENCIAS
select * from CONTACORRENTE
select * from HISTORICOS
select * from MOVIMENTACAO
select * from USUARIOS


UPDATE CLIENTES set 
 NOME_CLI='Cliente',
        ENDE_CLI='Endereco',
        NUME_CLI='Numero',
        COMPL_CLI='Complemento',
        BAIR_CLI='Bairro',
        CIDA_CLI='Cidade',
        UF_CLI='SP',
        CEP_CLI='18075718',
        FONE_CLI='15988319486',
        CPF_CLI='12345678911',
        DATA_NASC='20201010',
        CNPJ_CLI = NULL where ID_CLI = 3
select * from CLIENTES where CNPJ_CLI is not null 