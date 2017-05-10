package br.senac.tads.pi3.db.dao;

import br.senac.tads.pi3.db.utils.ConnectionUtils;
import br.senac.tads.pi3.exceptions.EstoqueException;
import br.senac.tads.pi3.model.estoque.Estoque;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Data Access Object de produto. Realiza operações de BD com o produto. 
public class DaoEstoque{
    
    public static void inserir(Estoque estoque) throws SQLException, Exception {
        String sql = "INSERT INTO Estoque (desc_estoque, fk_empresa, enabled) VALUES ("
                + "'" +estoque.getNome()+ "', "
                + "'" +estoque.getFkEmpresa() + ", "
                + "true"
                + ")";

        executarSQL(sql);
        System.out.println("inserido com sucesso");
    }

    public static void atualizar(Estoque estoque) throws SQLException, Exception {
        String sql = "UPDATE Estoque SET "
                + "desc_estoque ='" + estoque.getNome()+ "', "
                + "fk_empresa='" + estoque.getFkEmpresa()+ "', "
                + " WHERE (id_estoque=" + estoque.getId() + ")";

        executarSQL(sql);
    }

    public static void excluir(Integer id) throws SQLException, Exception {
        String sql = "UPDATE Estoque SET "
                + "enabled=false"
                + " WHERE (id_estoque=" + id + ")";

        executarSQL(sql);
    }
    
    public static List<Estoque> listar() throws SQLException, Exception {
        String sql = "SELECT * FROM produto WHERE enabled=true";

        return executarConsulta(sql);
    }

     public static List<Estoque> procurar(String desc) throws SQLException, Exception {
        String sql = "SELECT * FROM ESTOQUE WHERE ((UPPER(DESC_ESTOQUE) LIKE UPPER('%"
                + desc + "%') ) AND enabled=true)";

        return executarConsulta(sql);
    }

    public static Estoque obter(Integer id) throws SQLException, Exception {
        String sql = "SELECT * FROM ESTOQUE WHERE (id_estoque=" + id
                + " AND enabled=true)";

        List<Estoque> listaProdutos = executarConsulta(sql);

        if (listaProdutos != null && listaProdutos.size() > 0) {
            return listaProdutos.get(0);
        }
        return null;
    }

    private static void executarSQL(String sql) throws EstoqueException, SQLException, Exception {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando COMANDO SQL: " + sql);
            statement.execute(sql);
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static List<Estoque> executarConsulta(String sql) throws EstoqueException, SQLException, Exception {
        List<Estoque> listaEstoque = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery(sql);

            while (result.next()) {
                if ( listaEstoque == null) {
                     listaEstoque = new ArrayList<>();
                }
                Estoque estoque = new Estoque();
                estoque.setId(result.getInt("id_estoque"));
                estoque.setNome(result.getString("desc_estoque"));
                estoque.setidEmpresa(result.getInt("fk_empresa"));

                 listaEstoque.add(estoque);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaEstoque;
    }
}
