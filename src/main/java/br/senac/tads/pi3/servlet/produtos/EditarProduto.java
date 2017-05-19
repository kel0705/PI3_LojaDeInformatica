/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet.produtos;

import br.com.senac.pi.model.categoria.Categoria;
import br.com.senac.pi.model.produtos.Produtos;
import br.com.senac.pi3.db.utils.ConnectionUtils;
import br.senac.tads.pi3.db.dao.CategoriaDao;
import br.senac.tads.pi3.db.dao.ProdutoDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;
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
@WebServlet("/EditarProduto")

public class EditarProduto extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

           int idProduto = Integer.parseInt( req.getParameter("idProduto") );
           
           ProdutoDao dao = new ProdutoDao(ConnectionUtils.getConnection());
           
           CategoriaDao  categoriaDao = new CategoriaDao(ConnectionUtils.getConnection());
           
           Produtos produto = null;
        try {
           produto = dao.buscarPorId(idProduto);
        } catch (SQLException ex) {
            Logger.getLogger(EditarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Categoria> listaCategoria = null;
        try {
            listaCategoria = categoriaDao.listarCategoria();
        } catch (SQLException ex) {
            Logger.getLogger(EditarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        listaCategoria.remove(produto.getCategoria());
        
        listaCategoria.set(0, produto.getCategoria());
        
        req.getSession().setAttribute("ListaCategoriaAtualiza", listaCategoria);
        req.getSession().setAttribute("ProdutoAtualiza", produto);
        req.getRequestDispatcher("/Produtos/editarProduto.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProdutoDao produtoDao = new ProdutoDao(ConnectionUtils.getConnection());
        Produtos produto = new Produtos();
        
        produto.setId(Integer.parseInt(req.getParameter("idProd")));
        
        produto.setProduto(req.getParameter("nomeProd"));
        int idCategoria = Integer.parseInt(req.getParameter("categoriaProd"));
        try {        
            produto.setCategoria(new CategoriaDao(ConnectionUtils.getConnection()).buscarPorId(idCategoria));
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        produto.setVlProd(Double.parseDouble(req.getParameter("vlProd")));
        
        try {
            produtoDao.atualizarProduto(produto);
        } catch (Exception ex) {

        }
        
        
        resp.sendRedirect("ListaProduto");


    }
    
    
    
    
    
    
    
}
