/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet.filial;

import br.senac.tads.pi3.model.filial.Filial;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vitor
 */
public class FilialServlet {

@WebServlet({"/filial"})
public class EmpresaServerlet extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException{
        
        List<Filial> lista = new ArrayList();
                      
        lista.add(new Filial(1, "PWI"));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("agenda2.jsp");
        
        try{
            dispatcher.forward(request, response);
        } catch (IOException ex ){
            
        }
                
        response.setContentType("text/plain");
        try(PrintWriter out = response.getWriter()){
            out.print("!DOCTYPE html");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"utf-8\" />");
            out.print("<title>Primeiro Servlet</title>");
            out.print("</head>");
            out.print("<body>");
            for(Filial f: lista){
                out.print("<h1>Nome = " + f.getFantasia() + "</h1>");
            }
            out.print("</body>");
            out.print("</html>");
            out.flush();
        }catch (IOException ex){
            //Logger.getLogger(AgendaServlet.class.getName()).log(level.)
        }
    }
}

}
