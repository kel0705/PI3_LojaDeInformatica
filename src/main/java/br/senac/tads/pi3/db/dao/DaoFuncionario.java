/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.db.dao;

import br.com.senac.pi.model.funcionario.Funcionario;
import br.com.senac.pi.model.user.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Souza08
 */
public class DaoFuncionario {
    
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;

   
    public DaoFuncionario(Connection conBanco) {
        
        this.conBanco = conBanco;
    }
    
    
     public Funcionario buscarPorId(int id) throws SQLException{
        
        Funcionario funcionario = new Funcionario();
        
          ResultSet rs = null; 
        try {
            String sql = "SELECT * FROM FUNCIONARIO WHERE id_funcionario=?";
            psComando = conBanco.prepareStatement(sql);
            
            psComando.setInt(1, id);
            
            rs = psComando.executeQuery();
        }

         catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
        
        while(rs.next()){
            
            
            funcionario.setId(rs.getInt("id_funcionario"));
            funcionario.setCargo(rs.getString("cargo"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setEmail(rs.getString("email"));
            
            
            
            //usuario.setFuncionario(funcionario);
          

                    
        }
        
        
        return  funcionario;
    }
    
}
