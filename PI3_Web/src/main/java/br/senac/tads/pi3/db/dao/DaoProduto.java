package br.senac.tads.pi3.db.dao;
/**
 *
 * @author Kelly
 */

import br.senac.tads.pi3.db.utils.ConnectionUtils;
import br.senac.tads.pi3.exceptions.ProdutoException;
import br.senac.tads.pi3.model.produtos.Produtos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Data Access Object de produto. Realiza operações de BD com o produto. 
public class DaoProduto {

    //Insere um produto na tabela "Produtos" do banco de dados
    public static void inserir(Produtos produto)
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD,
        //utilizando os dados do produtos passados como parâmetro
        String sql = "INSERT INTO produto (categ_prod, desc_prod, qtd_prod, "
                + "valor_prod, enabled) VALUES ("
                + "'" +produto.getCategoria()+ "', "
                + "'" +produto.getProduto()+ "', "
                +  +produto.getQtdProd() + ", "
                +  produto.getVlProd()+ ", "
                + "true"
                + ")";

        //Executa o comando SQL montado
        executarSQL(sql);
        System.out.println("inserido com sucesso");
    }

    //Realiza a atualização dos dados de um produto, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "produto"
    public static void atualizar(Produtos produto)
            throws SQLException, Exception {
        //Monta a string de atualização do produto no BD, utilizando
        //os dados e o ID do produto passados como parâmetro
        String sql = "UPDATE produto SET "
                + "categ_prod='" + produto.getCategoria()+ "', "
                + "desc_prod='" + produto.getProduto()+ "', "
                + "qtd_prod=" + produto.getQtdProd()+ ", "
                + "valor_prod=" + produto.getVlProd()+ " "
                + " WHERE (id_produto=" + produto.getId() + ")";

        //Executa o comando SQL montado
        executarSQL(sql);
    }

    //Realiza a exclusão lógica de um produto no BD, com ID fornecido
    //como parâmetro. A exclusão lógica simplesmente "desliga" o
    //produto, configurando um atributo específico, a ser ignorado
    //em todas as consultas de produtos ("enabled").
    public static void excluir(Integer id) throws SQLException, Exception {
        //Monta a string de atualização do produto no BD, utilizando
        //o ID do produto passado como parâmetro para desativá-lo
        String sql = "UPDATE produto SET "
                + "enabled=false"
                + " WHERE (id_produto=" + id + ")";

        //Executa o comando SQL montado
        executarSQL(sql);
    }

    //Lista todos os produtos da tabela produto
    public static List<Produtos> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de produtos no banco, considerando
        //apenas a coluna de ativação de produtos ("enabled")
        String sql = "SELECT * FROM produto WHERE enabled=true";

        //Retorna o resultado da execução da consulta SQL montada
        return executarConsulta(sql);
    }

    //Procura um produto no banco de dados, de acordo com o nome
     public static List<Produtos> procurar(String valor)
            throws SQLException, Exception {
        //Monta a string de consulta de produto no banco, utilizando
        //o valor passado como parâmetro para busca nas colunas de
        //produto(através do "LIKE" e ignorando minúsculas
        //ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        //parâmetro). Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de produto configurada com
        //o valor correto ("enabled" com "true")
        String sql = "SELECT * FROM produto WHERE ((UPPER(desc_prod) LIKE UPPER('%"
                + valor + "%') ) AND enabled=true)";

        //Retorna o resultado da execução da consulta SQL montada
        return executarConsulta(sql);
    }

    //Obtém uma instância da classe "Produto" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    public static Produtos obter(Integer id)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o produto
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM produto WHERE (id_produto=" + id
                + " AND enabled=true)";

        //Armazena o valor da consulta numa lista temporária
        List<Produtos> listaProdutos= executarConsulta(sql);

        //Verifica se a lista de resposta não é nula e contém resultados
        if (listaProdutos != null && listaProdutos.size() > 0) {
            //Como a consulta foi feita por ID, este é uma chave
            //primária (só pode haver um) e a verificação de tamanho
            //da lista foi maior que zero, deve significar que há
            //apenas um item de resultado. Retornaremos este primeiro
            //e único item, já que ele é o que se deseja obter.
            return listaProdutos.get(0);
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados e a lista estava nula ou vazia.
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }

    //Executa um comando SQL não-consulta no banco de dados,
    //tratando da abertura, execução e fechamento de elementos
    //do JDBC necessários.
    private static void executarSQL(String sql) throws
            ProdutoException, SQLException, Exception {
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        Statement statement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.createStatement();
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            //Executa o comando no banco de dados
            statement.execute(sql);
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Executa um comando SQL de consulta no banco de dados,
    //tratando da abertura, execução e fechamento de elementos
    //do JDBC necessários e a iteração de elementos de resultado
    //para composição de uma lista de produtos para retorno.
    public static List<Produtos> executarConsulta(String sql) throws
        ProdutoException, SQLException, Exception {
        //Lista de produtos de resultado
        List<Produtos> listaProdutos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        Statement statement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.createStatement();
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando CONSULTA SQL: " + sql);
            //Executa a consulta SQL no banco de dados
            result = statement.executeQuery(sql);
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos= new ArrayList<Produtos>();
                }
                //Cria uma instância de produto e popula com os valores do BD
                Produtos produto = new Produtos();
                produto.setId(result.getInt("id_produto"));
                produto.setCategoria(result.getString("categ_prod"));
                produto.setProduto(result.getString("desc_prod"));
                produto.setQtdProd(result.getInt("qtd_prod"));
                produto.setVlProd(result.getDouble("valor_prod"));

                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de produtos do banco de dados
        return listaProdutos;
    }
}
