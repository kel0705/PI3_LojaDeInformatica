/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet.produto;

import br.senac.tads.pi3.banco_dados.conexaoBancoDados;
import br.senac.tads.pi3.db.dao.DaoProduto;
import br.senac.tads.pi3.model.produtos.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kelly
 */
@WebServlet(name = "atualizarProduto", urlPatterns = {"/atualizarProduto"})
public class atualizarProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out;
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>");
        out.println("<title>Sistema XPTO 1.0</title>");
        out.println("</head>");
        out.println("<body class='FundoPagina'>");
        out.println("<p class=\"TituloAplicação\"> Loja de Informática</p>");
        out.println("<p class=\"TituloPagina\">Cadastro de Produtos</p>");

        try {
            conexaoBancoDados conexao = new conexaoBancoDados();
            DaoProduto daoProduto = new DaoProduto();

            Produtos produto = new Produtos(request.getParameter("categoria"),
                    request.getParameter("descricao"),
                    request.getParameter("unidade"),
                    Double.parseDouble(request.getParameter("vlProduto")));

            produto.setIdProduto(Integer.parseInt(request.getParameter("codigo_produto")));

            
            if (conexao.abrirConexao()) {

                daoProduto.configurarConexao(conexao.obterConexao());                
                if(daoProduto.alterar(produto)){
                    out.println("<h2>Produto alterado com sucesso!</h2>");
                    out.println("<br><br><br><br>");
                    out.println("<a href='menu_produtos.html'>Voltar</a>");
                }else{
                    out.println("<h2>Não foi possível alterar produto.</h2>");
                }
                conexao.fecharConexao();
            } else {
                out.println("<h2>Não foi possível estabelecer conexão com o banco de dados!</h2>");
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            out.println("<h2>Erro do sistema: processo de cadastro de produto!</h2>");
        }
        out.println("<p class=\"RodapePagina\">Copyright(c) XPTO_2017.</p>");
        out.println("</body>");
        out.println("</html>");

    }

}
        
        
        
