/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.db.dao;

import br.senac.tads.pi3.db.utils.ConnectionUtils;
import br.senac.tads.pi3.model.filial.Filial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nataly
 */
public class DaoFilial {
    
    public static void inserirFilial(Filial filial)
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD,
        //utilizando os dados do produtos passados como parâmetro
        String sql = "INSERT INTO filial ( CNPJ, NOME, "
                + "NOME_FANTASIA) VALUES ("
                + "'" +filial.getCnpj()+ "', "
                + "'" +filial.getNomeFilial()+ "', "
                + "'" +filial.getNomeFantasia()
                + ")";

        //Executa o SQL
        executarSQL(sql);
        System.out.println("inserido com sucesso");
    }

    public static void atualizarFilial(Filial filial)
            throws SQLException, Exception {
        String sql = "UPDATE filial SET "
                + "CNPJ='" + filial.getCnpj()+ "', "
                + "NOME='" + filial.getNomeFilial()+ "', "
                + "NOME_FANTASIA=" + filial.getNomeFantasia()+ " "
                + " WHERE (ID_FILIAL=" + filial.getId() + ")";

        //Executa o SQL
        executarSQL(sql);
    }

    public static void excluirFilial(Integer cnpj) throws SQLException, Exception {
        String sql = "DELETE filial SET "
                + " WHERE (ID_FILIAL=" + cnpj + ")";

        //Executa o SQL
        executarSQL(sql);
    }

    public static List<Filial> listarFiliais()
            throws SQLException, Exception {
        //Monta a string de listagem de produtos no banco, considerando
        //apenas a coluna de ativação de produtos ("enabled")
        String sql = "SELECT * FROM filial";

        return executarConsulta(sql);
    }

     public static List<Filial> procurarFilialPorCNPJ(int cnpj)
            throws SQLException, Exception {
        String sql = "SELECT * FROM filial WHERE CNPJ = "+cnpj;

        //Retorna o resultado da execução da consulta SQL montada
        return executarConsulta(sql);
    }

    
    private static void executarSQL(String sql) throws
            SQLException, Exception {
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

    public static List<Filial> executarConsulta(String sql) throws
        SQLException, Exception {
        List<Filial> listaFilial = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (listaFilial == null) {
                    listaFilial= new ArrayList<Filial>();
                }
                Filial filial = new Filial();
                filial.setCnpj(result.getInt("CNPJ"));
                filial.setNomeFilial(result.getString("NOME"));
                filial.setNomeFantasia(result.getString("NOME_FANTASIA"));

                //Adiciona a instância na lista
                listaFilial.add(filial);
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
        return listaFilial;
    }
}
