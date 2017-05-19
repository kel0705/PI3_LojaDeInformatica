/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.com.senac.pi.model.cliente.Cliente;
import br.com.senac.pi.model.endereco.Endereco;
import br.com.senac.pi3.db.utils.ConnectionUtils;
import br.senac.tads.pi3.db.dao.ClienteDao;
import br.senac.tads.pi3.db.dao.EnderecoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jazon
 */
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastraCliente"})
public class CadastrarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("Clientes/inserir.jsp");
    }

   
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        Connection connection = ConnectionUtils.getConnection();
        
        
        EnderecoDao enderecoDao = new EnderecoDao(connection);
        
        Cliente cliente = new Cliente();
        
        cliente.setNome(request.getParameter("nomeCliente"));
        cliente.setSobrenome(request.getParameter("sobreNomeCliente"));
        cliente.setDtNasc(request.getParameter("dataNascimentoCliente"));
        cliente.setCpf(request.getParameter("cpfCliente"));
        cliente.setSexo(request.getParameter("selectSexoCliente"));
        cliente.setCel(request.getParameter("celularCliente"));
        cliente.setEmail(request.getParameter("emailCliente"));
        
        Endereco endereco = new Endereco();
        
        endereco.setBairro(request.getParameter("bairroCliente"));
        endereco.setRua(request.getParameter("enderecoCliente"));
        endereco.setCep(Integer.parseInt(request.getParameter("cepCliente")));
        endereco.setCidade(request.getParameter("cidadeCliente"));
        endereco.setEstado(request.getParameter("estadoCliente"));
        endereco.setNumero(request.getParameter("numEnderecoCliente"));
        
        try {
            endereco = enderecoDao.inserir(endereco);
            cliente.setEndereco(endereco);
            connection.commit();
            connection.close();
            System.out.println(endereco.getId());

        } catch (Exception ex) {
        }
        try {
            
        Connection connection1 = ConnectionUtils.getConnection();
        
        ClienteDao clienteDao = new ClienteDao(connection1);
            clienteDao.inserir(cliente);

        } catch (Exception ex) {
        }
        
        response.sendRedirect("ListarClientes");
    }
    
   
}
