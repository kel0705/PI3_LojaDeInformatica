/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.com.senac.pi3.db.utils.ConnectionUtils;
import br.senac.tads.pi3.db.dao.ClienteDao;
import java.io.IOException;
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
@WebServlet("/ExcluiCliente")
public class ExcluirCliente extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClienteDao clienteDao  = new ClienteDao(ConnectionUtils.getConnection());
        
         
        int idCliente = 0;
        
        idCliente = Integer.parseInt(req.getParameter("idClienteExcluir"));

        
        try {
            clienteDao.excluirCliente(idCliente);
        } catch (Exception ex) {
            Logger.getLogger(ExcluirCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        resp.sendRedirect("ListarClientes");
    }

    
    
    
    
}
