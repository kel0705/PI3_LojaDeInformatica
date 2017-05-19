/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.db.dao;


import br.com.senac.pi.model.produtos.Produtos;
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
public class ProdutoDao {
    
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;

   
    public ProdutoDao(Connection conBanco) {
        
        this.conBanco = conBanco;

    }


    public void inserirProduto(Produtos produto) throws SQLException, Exception {

        String sql = "INSERT INTO Produto(vl_prod,desc_prod,enabled,fk_id_categoria) "+
               " VALUES (?,?,?,?)";

        try {
            psComando = conBanco.prepareStatement(sql);

            psComando.setDouble(1, produto.getVlProd());
            psComando.setString(2, produto.getProduto());
            psComando.setBoolean(3, true);
            psComando.setInt(4, produto.getCategoria().getIdCategoria());


            psComando.execute();

       }catch (Exception erro) {
           erro.printStackTrace();
       }

    }
    
    
    
        public void atualizarProduto(Produtos produto) throws SQLException, Exception {

//            String sql = "UPDATE Produto set qtd_unidade=?,vl_prod=?,desc_prod=?,qtd_estoque=?,categoria=? WHERE id_produto=?";

            
            String sql =  "UPDATE PRODUTO SET DESC_PROD =? ,VL_PROD=? , FK_ID_CATEGORIA = ? WHERE ID_PRODUTO = ?";

            try {
                psComando = conBanco.prepareStatement(sql);

                psComando.setString(1, produto.getProduto());
                psComando.setDouble(2, produto.getVlProd());
                psComando.setInt(3, produto.getCategoria().getIdCategoria());
                psComando.setInt(4, produto.getId());


                psComando.executeUpdate();

           }catch (Exception erro) {
               erro.printStackTrace();
           }

        }
        
        public  void excluirProduto(Integer id) throws SQLException, Exception {
        //Monta a string de atualização do Produto no BD, utilizando
        //o ID do produto passado como parâmetro para desativá-lo
        String sql = "UPDATE produto SET enabled=false WHERE ID_PRODUTO=?";        
       
        psComando = conBanco.prepareStatement(sql);
        psComando.setInt(1, id);
        psComando.executeUpdate(); 
    }
     
       public ArrayList<Produtos> listarProduto() throws SQLException{
           
           String sql = "SELECT * FROM PRODUTO WHERE enabled=true";
           psComando = conBanco.prepareStatement(sql);
           ResultSet rs =  psComando.executeQuery();
           
           
           ArrayList<Produtos> listaProduto  = new ArrayList<Produtos>();
           
           
           while(rs.next()){
               Produtos produto = new Produtos();
               
               produto.setId(rs.getInt("id_produto"));
               produto.setVlProd(rs.getDouble("vl_prod"));
               produto.setProduto(rs.getString("desc_prod"));
               produto.setCategoria(new CategoriaDao(ConnectionUtils.getConnection()).buscarPorId(rs.getInt("FK_ID_CATEGORIA")));
               listaProduto.add(produto);
               
           }
           
           return listaProduto;
           
    }    

    public Produtos buscarPorId(int idProduto) throws SQLException {
         String sql = "SELECT * FROM Produto WHERE id_produto=?";
        psComando = conBanco.prepareStatement(sql);
        psComando.setInt(1, idProduto);
        ResultSet rs =  psComando.executeQuery();
           
           
           Produtos produto=  new Produtos();
           
           
           while(rs.next()){
                                      

            produto.setId(rs.getInt("id_produto"));
            produto.setVlProd(rs.getDouble("vl_prod"));
            produto.setProduto(rs.getString("desc_prod"));
            produto.setCategoria(new CategoriaDao(ConnectionUtils.getConnection()).buscarPorId(rs.getInt("FK_ID_CATEGORIA")));
     
           }
           
            
        return produto;
    }  
}