/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet ;

import br.com.senac.pi.model.user.Usuario;
import br.com.senac.pi3.db.utils.ConnectionUtils;
import br.senac.tads.pi3.db.dao.DaoUsuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Souza08
 */

//@WebServlet( {"/Login","/Logout"})
@WebServlet("/Login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    
    
    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        

        
        

        DaoUsuario daoUsuario = new DaoUsuario(ConnectionUtils.getConnection());
            
        String login = request.getParameter("loginForm");
        String password =  request.getParameter("passwordForm");
        Usuario usuario = null;

        try {
            System.out.println("Teste ");

            if(daoUsuario.autentica(login,password)){
                
                
                usuario =   daoUsuario.getUser(login) ;
                

                System.out.println("Autenticado");

                request.getSession().setAttribute("usuarioLogado", usuario);
                        resp.sendRedirect("dashboard.jsp");
                            
            }else{
                request.setAttribute("login", login);
                request.setAttribute("password", password);
                
                request.setAttribute("errormsg", "Dados Incorretos!");
                   
                request.getRequestDispatcher("index.jsp").forward(request, resp);
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                       

    }

    
}
