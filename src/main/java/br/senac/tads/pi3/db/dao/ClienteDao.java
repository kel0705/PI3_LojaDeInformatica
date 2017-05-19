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
public class ClienteDao {
    
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;

   
    public ClienteDao(Connection conBanco) {
        
        this.conBanco = conBanco;
    }


    public void inserir(Cliente cliente) throws SQLException, Exception {

        String sql = "INSERT INTO Cliente (dt_cadastro,nome,sobrenome,dt_nasc,cpf,sexo,cel,email ,enabled,fk_endereco) "+
               " VALUES (CURRENT_DATE,?,?,?,?,?,?,?,?,?)";

        try {
            psComando = conBanco.prepareStatement(sql);

            psComando.setString(1, cliente.getNome());
            psComando.setString(2, cliente.getSobrenome());
            psComando.setString(3, cliente.getDtNasc());
            psComando.setString(4,cliente.getCpf());
            psComando.setString(5, cliente.getSexo());
            psComando.setString(6, cliente.getCel());
            psComando.setString(7, cliente.getEmail());
            psComando.setBoolean(8, true);
            psComando.setInt(9, cliente.getEndereco().getId());




            psComando.execute();

       }catch (Exception erro) {
           erro.printStackTrace();
       }

    }
    
    
    
        public void atualizarCliente(Cliente cliente) throws SQLException, Exception {

        String sql = "UPDATE Cliente set nome=?,sobrenome=?,dt_nasc=?,cpf=?,sexo=?,cel=?,email=? WHERE id_cliente=?";
              

        try {
            psComando = conBanco.prepareStatement(sql);

            psComando.setString(1, cliente.getNome());
            psComando.setString(2, cliente.getSobrenome());
            psComando.setString(3, cliente.getDtNasc());
            psComando.setString(4,cliente.getCpf());
            psComando.setString(5, cliente.getSexo());
            psComando.setString(6, cliente.getCel());
            psComando.setString(7, cliente.getEmail());
            psComando.setInt(8, cliente.getId()) ;
           
        

            psComando.executeUpdate();

       }catch (Exception erro) {
           erro.printStackTrace();
       }

    }
        
        public  void excluirCliente(Integer id) throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando
        //o ID do cliente passado como parâmetro para desativá-lo
        String sql = "UPDATE cliente SET enabled=false WHERE id_cliente=?";        
       
        psComando = conBanco.prepareStatement(sql);
        psComando.setInt(1, id);
        psComando.executeUpdate();
    }
     
       public ArrayList<Cliente> listarCliente() throws SQLException{
           
           String sql = "SELECT * FROM Cliente WHERE enabled=true";
           psComando = conBanco.prepareStatement(sql);
           ResultSet rs =  psComando.executeQuery();
           
           
           ArrayList<Cliente> listaCliente  = new ArrayList<Cliente>();
           
           
           EnderecoDao  daoEndereco = new EnderecoDao(ConnectionUtils.getConnection());
           while(rs.next()){
               Cliente cliente = new Cliente();
               
               cliente.setId(rs.getInt("ID_CLIENTE"));
               cliente.setDtCadastro(rs.getString("DT_CADASTRO"));
               cliente.setNome(rs.getString("NOME"));
               cliente.setSobrenome(rs.getString("SOBRENOME"));
               cliente.setDtNasc(rs.getString("DT_NASC"));
               cliente.setCpf(rs.getString("CPF"));
               cliente.setSexo(rs.getString("SEXO"));
               cliente.setCel(rs.getString("CEL"));
               cliente.setEmail(rs.getString("EMAIL"));
               
              
               cliente.setEndereco(daoEndereco.buscarPorId(rs.getInt("FK_ENDERECO")));
               listaCliente.add(cliente);
               
           }
           
           return listaCliente;
           
    }    

    public Cliente buscarPorId(int idCliente) throws SQLException {
         String sql = "SELECT * FROM Cliente WHERE id_cliente=?";
        psComando = conBanco.prepareStatement(sql);
        psComando.setInt(1, idCliente);
        ResultSet rs =  psComando.executeQuery();
           
           
           Cliente cliente =  new Cliente();
           
           
           while(rs.next()){
               
               cliente.setId(rs.getInt("ID_CLIENTE"));
               cliente.setDtCadastro(rs.getString("DT_CADASTRO"));
               cliente.setNome(rs.getString("NOME"));
               cliente.setSobrenome(rs.getString("SOBRENOME"));
               cliente.setDtNasc(rs.getString("DT_NASC"));
               cliente.setCpf(rs.getString("CPF"));
               cliente.setSexo(rs.getString("SEXO"));
               cliente.setCel(rs.getString("CEL"));
               cliente.setEmail(rs.getString("EMAIL"));
                             
                cliente.setEndereco(new EnderecoDao(ConnectionUtils.getConnection()).buscarPorId(rs.getInt("FK_ENDERECO")));
               
           }
           
            
        return cliente;
    }  
}
