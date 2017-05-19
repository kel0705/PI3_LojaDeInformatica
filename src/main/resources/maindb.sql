
/*
insert into ENDERECO(CEP,RUA,BAIRRO,CIDADE,ESTADO,NUMERO) VALUES(4940010,'Rua Afonso rui','santa lucia','são paulo','SP','55');
insert into ENDERECO(CEP,RUA,BAIRRO,CIDADE,ESTADO,NUMERO) VALUES(4940010,'Rua Afonso rui','santa lucia','são paulo','SP','10');
insert into filial(CNPJ,DESC_FILIAL,ENABLED,FK_ENDERECO) values('3634270980001','MATRIZ',true,1);

insert into funcionario (COD_ACESSO,CARGO,ID_FILIAL,NOME,SOBRENOME,DT_NASC,CPF,SEXO,CEL,EMAIL,ENABLED,FK_ENDERECO)
values (1,'gerente',2,'Joao','Souza','27/12/90','36342709858','M','959668809','jazoniel@gmail.com',true,2);

insert into USUARIO(login,senha,id_funcionario) values('admin','admin',2);


insert into Categoria(desc_prod,enabled) values('Eletrodomésticos',true);
insert into Categoria(desc_prod,enabled) values('Livros',true);
insert into Categoria(desc_prod,enabled) values('Filmes,Séries',true);
insert into Categoria(desc_prod,enabled) values('Games',true);
insert into Categoria(desc_prod,enabled) values('Moda',true);


*/
CREATE TABLE Endereco (
    id_endereco INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    cep INTEGER NOT NULL,
    rua VARCHAR(50)NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    numero VARCHAR(255) NOT NULL
);


CREATE TABLE Filial(
    id_filial INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    cnpj VARCHAR(255) NOT NULL,
    desc_filial VARCHAR(50),
    enabled BOOLEAN,
    fk_endereco INTEGER NOT NULL REFERENCES Endereco(id_endereco)

);


CREATE TABLE FUNCIONARIO(
    id_funcionario INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    cod_acesso INTEGER NOT NULL,
    cargo VARCHAR(50),
    id_filial INTEGER NOT NULL REFERENCES Filial(id_filial),
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(200) NOT NULL,
    dt_nasc VARCHAR(8)NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    sexo VARCHAR(10),
    cel VARCHAR(15) NOT NULL,
    email VARCHAR(50) NOT NULL,
    enabled BOOLEAN,
    fk_endereco INTEGER NOT NULL REFERENCES Endereco(id_endereco)

);

CREATE TABLE Cliente (
    id_cliente INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    dt_cadastro VARCHAR(255)NOT NULL,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(200) NOT NULL,
    dt_nasc VARCHAR(8)NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    sexo VARCHAR(10),
    cel VARCHAR(15) NOT NULL,
    email VARCHAR(50) NOT NULL,
    enabled BOOLEAN,
    fk_endereco INTEGER NOT NULL REFERENCES Endereco(id_endereco)

  );
CREATE TABLE Categoria (
    id_categoria INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    desc_prod VARCHAR(50) NOT NULL,
    enabled BOOLEAN
);

CREATE TABLE Produto (
    id_produto INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    vl_prod DOUBLE NOT NULL,
    desc_prod VARCHAR(50),
    FK_ID_CATEGORIA INTEGER NOT NULL REFERENCES CATEGORIA(ID_CATEGORIA),
    enabled BOOLEAN
);

CREATE TABLE ESTOQUE (
    ID_ESTOQUE INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    DESC_ESTOQUE VARCHAR (20),
    FK_FILIAL INTEGER NOT NULL REFERENCES FILIAL(ID_FILIAL),
    FK_ID_PRODUTO INTEGER NOT NULL REFERENCES PRODUTO(ID_PRODUTO),
    ENABLED BOOLEAN
);

CREATE TABLE MOVIMENTACAO_ESTOQUE (
    ID_MOVIMENTACAO INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    FK_PRODUTO INTEGER NOT NULL REFERENCES PRODUTO(ID_PRODUTO),
    FK_ESTOQUE INTEGER NOT NULL REFERENCES ESTOQUE(ID_ESTOQUE),
    QTDUND INTEGER NOT NULL
  
);


-- Cria tabela Venda
CREATE TABLE Venda (
    id_venda INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    dt_venda DATE ,
    valor_compra DOUBLE NOT NULL,
    cliente_id INTEGER NOT NULL REFERENCES cliente(id_cliente)    
   
);
 
-- Cria tabela Venda_produto

CREATE TABLE Venda_Produto (
    
    produto_id INTEGER NOT NULL REFERENCES produto(id_produto),
    id_venda INTEGER NOT NULL REFERENCES venda (id_venda),
    qtdUnd INTEGER NOT NULL
    
);





CREATE TABLE Usuario(
    id_usuario INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    login Varchar(255),
    senha Varchar(255),
    id_funcionario INTEGER NOT NULL REFERENCES FUNCIONARIO (id_funcionario)
);


