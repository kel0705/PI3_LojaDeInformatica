/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet.produtos;

import br.com.senac.pi.model.produtos.Produtos;
import br.com.senac.pi3.db.utils.ConnectionUtils;
import br.senac.tads.pi3.db.dao.CategoriaDao;
import br.senac.tads.pi3.db.dao.ProdutoDao;
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
 * @author Maquinaria
 */

@WebServlet(name = "CadastrarProduto", urlPatterns = {"/CadastraProduto"})

public class CadastrarProduto extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        CategoriaDao categoriaDao = new CategoriaDao(ConnectionUtils.getConnection());
        
        try {
            req.getSession().setAttribute("listaCategoria", categoriaDao.listarCategoria()) ;
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        req.getRequestDispatcher("Produtos/inserirProduto.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        ProdutoDao produtoDao = new ProdutoDao(ConnectionUtils.getConnection());
        Produtos produto = new Produtos();
        
        
        
        produto.setProduto(req.getParameter("nomeProd"));
        int idCategoria = Integer.parseInt(req.getParameter("categoriaProd"));
        try {        
            produto.setCategoria(new CategoriaDao(ConnectionUtils.getConnection()).buscarPorId(idCategoria));
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        produto.setVlProd(Double.parseDouble(req.getParameter("vlProd")));
        
        try {
            produtoDao.inserirProduto(produto);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        req.getRequestDispatcher("Produtos/listarProduto.jsp").forward(req, resp);
    }
    
    
    
    
    
}