/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jazon
 */
@WebFilter(filterName = "Autorizacao", urlPatterns = {"/teste.jsp"}  )
public class Autorizacao implements Filter {
     
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
        Arrays.asList("", "/Login", "/Logout")));
    
    public Autorizacao() { 
    }    
    

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", ""); 

        
        boolean allowedPath = ALLOWED_PATHS.contains(path);

         
        
        if(allowedPath){
            chain.doFilter(request, response);

        }
        
        if(req.getSession().getAttribute("UsuarioLogado")==null){

            
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            
        }
                         

        
     
        
        
    }

 
    public void destroy() {        
    }

  
    public void init(FilterConfig filterConfig) {        
       
    }

    
    
}
