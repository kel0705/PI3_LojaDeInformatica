
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.senac.pi3.model.produtos.Produtos"%>
<%@page import="br.senac.pi3.db.dao.DaoProduto"%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="conexao" scope="page" class="br.senac.pi3.banco_dados.conexaoBancoDados" />
<jsp:useBean id="daoProduto" scope="page" class="br.senac.pi3.db.dao.DaoProduto" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema XPTO 1.0</title>
    </head>
    
    <body class="FundoPagina">
        
        <%
            ResultSet rsRegistro;
            boolean blnConectado;
            
            Produtos Produto = new Produtos();
            
            int idProduto = Integer.parseInt(request.getParameter("codigo_produto"));
            blnConectado = false;
            
            if (conexao.abrirConexao()){
                daoProduto.configurarConexao(conexao.obterConexao());
                
                rsRegistro = daoProduto.obter(idProduto);
                
                Produto.setIdProduto(idProduto);
                Produto.setCategoria(rsRegistro.getString("categoria"));
                Produto.setDescProduto(rsRegistro.getString("descricao"));
                Produto.setQtdEstoque(rsRegistro.getInt("qtdeEstoque"));
                Produto.setQtdEstoque(rsRegistro.getInt("qtdeUnidade"));
                Produto.setQtdEstoque(rsRegistro.getInt("vlProduto"));
                
                conexao.fecharConexao();
                
                blnConectado = true;                
            }
            else
                out.print("<p>Falha na conexão com o banco de dados!</p>");
            %>
            
            <% if (blnConectado) {%>
            <p class="TituloAplicação"> Loja de Informática</p>
            <p class="TituloPagina">Cadastro de Produtos - Excluir</p>

            <form name="formExcluirProduto" action="excluirProduto" method="POST">
                <p> Nome do Produto: <%=Produto.getIdProduto()%>></p>
                <br>
                <p>Categoria: <%=Produto.getCategoria()%></p>
                <p>Descrição: <%=Produto.getDescProduto()%></p>
                <p>Qtde. Estoque: <%=Produto.getQtdEstoque()%></p>
                <p>Qtde. Unidade: <%=Produto.getQtdUnidade()%></p>
                <p>Valor: <%=Produto.getVlProduto()%></p>
                
                    <input type="hidden" name="codigo_produto" value="<%=idProduto%>" />
                    <br>
                
                <p><input type="submit" value="Excluir" name="btnExcluir" />
                    <span class="LinkVoltar"><a href="javascript:history.back()">[Voltar]</a></span>
                </p>
                
            </form>
                          
                          
            <p class="RodapePagina">Copyright(c) XPTO_2017. <p> 
            <%}%>
</body>
</html>
