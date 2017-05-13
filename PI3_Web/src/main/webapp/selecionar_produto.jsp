
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="conexao" scope="page" class="br.senac.tads.pi3.banco_dados.conexaoBancoDados" />
<jsp:useBean id="daoProduto" scope="page" class="br.senac.tads.pi3.db.dao.DaoProduto" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema XPTO 1.0</title>
    </head>
    
    
    <body class="FundoPagina">
        <%
            ResultSet rsRegistros;
            
            if (conexao.abrirConexao()){
                
                daoProduto.configurarConexao(conexao.obterConexao());
                
                
                rsRegistros = daoProduto.listarRegistros();
                
                if (rsRegistros != null){
                    
                    out.println("<h2><center>Lista de Produtos</center></h2>");
                    out.println("<br>");
                    out.println("<table>");
                    out.println("<tr><th>Categoria</th><th>Produto</th><th></th>"
                            + "<th></th></tr>");
                    
                    while (rsRegistros.next()){
                        
                        out.println("<tr>");
                        
                        out.println("<td>" + rsRegistros.getString("categ_prod")+"</td>");
                        out.println("<td>" + rsRegistros.getString("desc_prod")+"</td>");
                        out.println("<td><a href='editar_produto.jsp?Codigo=" + rsRegistros.getString("id_produto")
                        + "'>Editar</a></td>");
                        out.println("<td><a href='excluir_produto.jsp?Codigo=" + rsRegistros.getString("id_produto")
                        + "'>Excluir</a></td>");
                        out.print("</tr>");
                    }
                    out.println("</table>");
                    out.println("<br>");
                }
                else{
                    out.println("<p>Falha na exibição dos registros!</p>");
                }
                conexao.fecharConexao();
            }
            
            else{
                out.println("<p>Falha na conexão com o banco de dados!</p>");          
                    }         
        %>
        
        <span class="LinkVoltar"><a href="javascript:history.back()">[Voltar]</a></span>
        
        <p class="RodapePagina">Copyright(c) XPTO_2017. <p>
        
        
    </body>
</html>
