/**
 *
 * @author Kelly
 */

--Deleta as tabelas criadas no  banco de dados

/*
DROP TABLE Venda_Produto; 
DROP TABLE Venda;  
DROP TABLE Produto;
DROP TABLE Cliente;

*/

-- Cria tabela Cliente 

/*CREATE TABLE cliente (
    id_cliente INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(200) NOT NULL,
    idade INTEGER NOT NULL,
    cpf BIGINT NOT NULL UNIQUE,
    sexo VARCHAR(10),
    cel BIGINT NOT NULL,
    endereco VARCHAR(50), 
    num Integer NOT NULL ,
    bairro VARCHAR(20) NOT NULL,
    cep INTEGER NOT NULL,
    cid VARCHAR(50) NOT NULL,
    est VARCHAR(50) NOT NULL, 
    email VARCHAR(50) NOT NULL,
    enabled BOOLEAN
);
*/
-- Cria tabela Produto
CREATE TABLE Produto (
    id_produto INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    categ_prod VARCHAR (20),
    desc_prod VARCHAR(50),
    qtd_prod INTEGER NOT NULL,
    valor_prod DOUBLE NOT NULL,
    enabled BOOLEAN
);
/*
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
    id_venda INTEGER NOT NULL REFERENCES venda (id_venda)
   
    
);
*/