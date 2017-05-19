/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.com.senac.pi.model.cliente.Cliente;
import br.com.senac.pi3.db.utils.ConnectionUtils;
import br.senac.tads.pi3.db.dao.ClienteDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jazon
 */
@WebServlet({"/ListarClientes"})

public class ListarCliente extends HttpServlet{
    
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        ClienteDao clienteDao = new ClienteDao(ConnectionUtils.getConnection());
        
        List<Cliente> listaClientes = null;
        try {
            listaClientes =  clienteDao.listarCliente();
        } catch (SQLException ex) {
        }
        
        req.getSession().setAttribute("listaClientes", listaClientes);
        
        req.getRequestDispatcher("/Clientes/listarCliente.jsp").forward(req, resp);
    }
    
    
    
    
}
