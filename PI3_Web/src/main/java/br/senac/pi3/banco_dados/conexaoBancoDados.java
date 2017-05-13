/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.banco_dados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kelly
 */
public class conexaoBancoDados {
    
    Connection conBanco;
    
    public boolean abrirConexao(){
        String url = "jdbc:derby://localhost:1527/xptoTech;create=true;user=xptoTech;password=xptoTech";
                
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conBanco = DriverManager.getConnection(url); 
            return true;
        }
        catch (Exception erro){
            erro.printStackTrace();
            return false;
        }
    }
    
    public boolean fecharConexao(){
        try {
            conBanco.close();
            return true;
        }
        catch(SQLException erro){
            erro.printStackTrace ();
            return false;
        }
    }
    
    public Connection obterConexao () {
        return conBanco;
    }
    
    
}
