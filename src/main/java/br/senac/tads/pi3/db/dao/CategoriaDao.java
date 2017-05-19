/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.db.dao;

import br.com.senac.pi.model.categoria.Categoria;
import br.com.senac.pi3.db.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Souza08
 */
public class CategoriaDao {
    
        
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;

   
    public CategoriaDao(Connection conBanco) {
        
        this.conBanco = conBanco;
    }
    
        public void inserir(Categoria categoria) throws SQLException, Exception {

        String sql = "INSERT INTO Categoria (DESC_PROD,enabled) "+
               " VALUES (?,?)";

        try {
            psComando = conBanco.prepareStatement(sql);

            psComando.setString(1, categoria.getCategoria());
            psComando.setBoolean(2, true);


            psComando.execute();

       }catch (Exception erro) {
           erro.printStackTrace();
       }

    }
    
    
    
        public void atualizarCategoria(Categoria categoria) throws SQLException, Exception {

        String sql = "UPDATE Categoria set DESC_PROD=? WHERE id_categoria=?";
              

        try {
            psComando = conBanco.prepareStatement(sql);

            psComando.setString(1, categoria.getCategoria());
     
     
            psComando.executeUpdate();

       }catch (Exception erro) {
           erro.printStackTrace();
       }

    }
        
    public  void excluirCategoria(Integer idCategoria) throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando
        //o ID do cliente passado como parâmetro para desativá-lo
        String sql = "UPDATE categoria SET enabled=false WHERE id_categoria=?";        
       
        psComando = conBanco.prepareStatement(sql);
        psComando.executeUpdate();
    }
     
       public ArrayList<Categoria> listarCategoria() throws SQLException{
           
           String sql = "SELECT * FROM Categoria WHERE enabled=true";
           psComando = conBanco.prepareStatement(sql);
           ResultSet rs =  psComando.executeQuery();
           
           
           ArrayList<Categoria> listaCategoria  = new ArrayList<Categoria>();
           

           while(rs.next()){
               Categoria categoria = new Categoria();
               
               categoria.setIdCategoria(rs.getInt("ID_CATEGORIA"));
               categoria.setCategoria(rs.getString("DESC_PROD"));
              
               listaCategoria.add(categoria);
               
           }
           
           return listaCategoria;
           
    }    

    public Categoria buscarPorId(int idCategoria) throws SQLException {
         String sql = "SELECT * FROM Categoria WHERE ID_CATEGORIA=?";
        psComando = conBanco.prepareStatement(sql);
        psComando.setInt(1, idCategoria);
        ResultSet rs =  psComando.executeQuery();
           
           
           Categoria categoria =  new Categoria();
           
           
           while(rs.next()){
               
               categoria.setIdCategoria(rs.getInt("ID_CATEGORIA"));
               categoria.setCategoria(rs.getString("DESC_PROD"));
                             
           }
           
            
        return categoria;
    }  
    
    
    
}
