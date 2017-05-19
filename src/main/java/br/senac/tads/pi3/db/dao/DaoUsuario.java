/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.db.dao;

import br.com.senac.pi.model.user.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Souza08
 */
public class DaoUsuario {
    
    
    
    
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;

   
    public DaoUsuario(Connection conBanco) {
        
        this.conBanco = conBanco;
    }

    
    
    
    public Boolean autentica(String login, String password) throws SQLException{
        
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM USUARIO WHERE login=? and SENHA =? ";
            psComando = conBanco.prepareStatement(sql);
            
            psComando.setString(1, login);
            psComando.setString(2, password);
            
            rs = psComando.executeQuery();
        }catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
        
            String loginBusca="";
            String passwordBusca="";
          while(rs.next()){
            
            loginBusca = rs.getString("login");
            passwordBusca= rs.getString("senha");
            
            //usuario.setFuncionario(funcionario);
                 
        }
          
          if(loginBusca.equals(login) && passwordBusca.equals(password)){
              return true;
          }
        
        
        return false;
    }
    
    public Usuario getUser(String login) throws SQLException{
        
        Usuario usuario = new Usuario();
        DaoFuncionario daoFuncionario = new DaoFuncionario(conBanco);
        
          ResultSet rs = null; 
        try {
            String sql = "SELECT * FROM USUARIO WHERE login=?";
            psComando = conBanco.prepareStatement(sql);
            
            psComando.setString(1, login);
            
            rs = psComando.executeQuery();
        }

         catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
        
        while(rs.next()){
            
            
            usuario.setLogin(rs.getString("login"));
            usuario.setPassword(rs.getString("senha"));
            
            
           usuario.setFuncionario(daoFuncionario.buscarPorId(rs.getInt("id_funcionario")));
          

                    
        }
        
        
        return  usuario;
    }
    
    
    
    
    
    
}
