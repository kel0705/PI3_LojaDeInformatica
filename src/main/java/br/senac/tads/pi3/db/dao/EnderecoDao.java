/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.db.dao;

import br.com.senac.pi.model.cliente.Cliente;
import br.com.senac.pi.model.endereco.Endereco;
import br.com.senac.pi3.db.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Souza08
 */
public class EnderecoDao {
    
    
    
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;

   
    public EnderecoDao(Connection conBanco) {
        
        this.conBanco = conBanco;
    }


    public Endereco inserir(Endereco endereco) throws SQLException, Exception {

        String sql = "INSERT INTO Endereco (cep  , rua  , bairro  , cidade  , estado  ,numero ) VALUES (?,?,?,?,?,?)";


        try {
            psComando = conBanco.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            psComando.setLong(1, endereco.getCep());
            psComando.setString(2, endereco.getRua());
            psComando.setString(3, endereco.getBairro());
            psComando.setString(4, endereco.getCidade());
            psComando.setString(5, endereco.getEstado());
            psComando.setString(6, endereco.getNumero());

            psComando.execute();
            ResultSet rs = psComando.getGeneratedKeys();
            
             

           Integer idEndereco = 0 ;
           while(rs.next()){
               idEndereco = rs.getInt(1);
           }  
           endereco.setId(idEndereco);
       }catch (Exception erro) {
           erro.printStackTrace();
       }

        
            return endereco;
    }

    public Endereco buscarPorId(int id) throws SQLException {
        
        String sql = "SELECT * FROM Endereco WHERE id_endereco=?";
        psComando = conBanco.prepareStatement(sql);
        psComando.setInt(1, id);
        ResultSet rs =  psComando.executeQuery();
           
           
           Endereco endereco =  new Endereco();
           
           
           while(rs.next()){
               
               endereco.setId(rs.getInt("ID_ENDERECO"));
               endereco.setCep(rs.getInt("CEP"));
               endereco.setRua(rs.getString("RUA"));
               endereco.setBairro(rs.getString("BAIRRO"));
               endereco.setCidade(rs.getString("CIDADE"));
               endereco.setEstado(rs.getString("ESTADO"));
               endereco.setNumero(rs.getString("NUMERO"));
               
                              
           }
           
            
        return endereco;
    }
    
    public void atualizarEndereco(Endereco endereco) throws SQLException, Exception {

        String sql = "UPDATE ENDERECO set CEP=?,RUA=?,BAIRRO=?,CIDADE=?,ESTADO=?,NUMERO=? WHERE ID_ENDERECO=?";
              

        try {
            psComando = conBanco.prepareStatement(sql);

            psComando.setInt(1, endereco.getCep());
            psComando.setString(2, endereco.getRua());
            psComando.setString(3, endereco.getBairro());
            psComando.setString(4,endereco.getCidade());
            psComando.setString(5, endereco.getEstado());
            psComando.setString(6, endereco.getNumero());
            psComando.setInt(7, endereco.getId());
           
        

            psComando.executeUpdate();

       }catch (Exception erro) {
           erro.printStackTrace();
       }

    }
    
}
