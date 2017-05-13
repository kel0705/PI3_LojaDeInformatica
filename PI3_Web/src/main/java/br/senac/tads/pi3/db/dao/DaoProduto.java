package br.senac.tads.pi3.db.dao;

/**
 *
 * @author Kelly
 */

import br.senac.tads.pi3.model.produtos.Produtos;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Data Access Object de produto. Realiza operações de BD com o produto. 
public class DaoProduto {

    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;

    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }

    //Insere um produto na tabela "Produtos" do banco de dados
    public boolean inserir(Produtos produto) {
        //Monta a string de inserção de um produto no BD,
        //utilizando os dados do produtos passados como parâmetro
        try {
            String sql = "INSERT INTO produto (categ_prod, desc_prod, "
                    + "unidade, valor_prod, enabled) VALUES ("
                    + "'" + produto.getCategoria() + "', "
                    + "'" + produto.getDescProduto() + "', "
                    + "'" + produto.getUnidade() + "', "
                    + produto.getVlProduto() + ", "
                    + "true"
                    + ")";

            //Executa o comando SQL montado            
            psComando = conBanco.prepareStatement(sql);
            psComando.executeUpdate();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    //Realiza a atualização dos dados de um produto, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "produto"
    public boolean alterar(Produtos produto) {
        //Monta a string de atualização do produto no BD, utilizando
        //os dados e o ID do produto passados como parâmetro
        try {
            String sql = "UPDATE PRODUTO SET categ_prod = '" + produto.getCategoria() + "', "
                    + "desc_prod = '" + produto.getDescProduto() + "', "
                    + "unidade = " + produto.getUnidade() + ", "
                    + "valor_prod = " + produto.getVlProduto() + " "
                    + " WHERE id_produto = " + produto.getIdProduto();

            //Executa o comando SQL montado            
            psComando = conBanco.prepareStatement(sql);
            psComando.executeUpdate();
            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    //Realiza a exclusão lógica de um produto no BD, com ID fornecido
    //como parâmetro. A exclusão lógica simplesmente "desliga" o
    //produto, configurando um atributo específico, a ser ignorado
    //em todas as consultas de produtos ("enabled").
    public boolean excluir(Integer id) throws SQLException, Exception {
        //Monta a string de atualização do produto no BD, utilizando
        //o ID do produto passado como parâmetro para desativá-lo
        try {
            String sql = "UPDATE produto SET "
                    + "enabled=false"
                    + " WHERE (id_produto=" + id + ")";

            //Executa o comando SQL montado
            psComando = conBanco.prepareStatement(sql);
            psComando.executeUpdate();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    //Lista todos os produtos da tabela produto
    public ResultSet listarRegistros () throws SQLException {
        //Monta a string de listagem de produtos no banco, considerando
        //apenas a coluna de ativação de produtos ("enabled")
        
        try {
            String sql = "SELECT * FROM produto WHERE enabled=true ORDER BY id_produto";
            psComando = conBanco.prepareStatement(sql);
            rsRegistros = psComando.executeQuery();
            return rsRegistros;
            }

         catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }

    //Procura um produto no banco de dados, de acordo com o nome
    public int procurar(String valor)
            throws SQLException, Exception {
        int intCodigo = 0;
        //Monta a string de consulta de produto no banco, utilizando
        //o valor passado como parâmetro para busca nas colunas de
        //produto(através do "LIKE" e ignorando minúsculas
        //ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        //parâmetro). Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de produto configurada com
        //o valor correto ("enabled" com "true")
        try {
            String sql = "SELECT * FROM produto WHERE ((UPPER(desc_prod) LIKE UPPER('%"
                    + valor + "%') ) AND enabled=true)";

            //Retorna o resultado da execução da consulta SQL montada
            psComando = conBanco.prepareStatement(sql);
            rsRegistros = psComando.executeQuery();
            rsRegistros.next();
            intCodigo = rsRegistros.getInt("id_produto");
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return intCodigo;
    }

    //Obtém uma instância da classe "Produto" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    public ResultSet obter(Integer id)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o produto
        //com o ID informado e que esteja ativo ("enabled" com "true")
        try {
            String sql = "SELECT * FROM produto WHERE (id_produto=" + id
                    + " AND enabled=true)";

            //Armazena o valor da consulta numa lista temporária
            psComando = conBanco.prepareStatement(sql);
            rsRegistros = psComando.executeQuery();
            rsRegistros.next();

            return rsRegistros;
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }

    }
}
