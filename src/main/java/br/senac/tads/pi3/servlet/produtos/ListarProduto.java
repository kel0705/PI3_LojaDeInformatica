/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet.produtos;

import br.com.senac.pi.model.produtos.Produtos;
import br.com.senac.pi3.db.utils.ConnectionUtils;
import br.senac.tads.pi3.db.dao.ProdutoDao;
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
 * @author Maquinaria
 */
@WebServlet(name = "ListarProduto", urlPatterns = {"/ListaProduto"})

public class ListarProduto extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        ProdutoDao produtoDao = new ProdutoDao(ConnectionUtils.getConnection());
        
         List<Produtos> listaProdutos = null;
        try {
           listaProdutos =  produtoDao.listarProduto();
        } catch (SQLException ex) {
            Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        req.getSession().setAttribute("listaProdutos", listaProdutos);
        req.getRequestDispatcher("Produtos/listarProduto.jsp").forward(req, resp);


    }
    
    
    
    
}
