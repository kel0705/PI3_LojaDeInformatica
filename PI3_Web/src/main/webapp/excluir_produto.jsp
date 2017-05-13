
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.senac.tads.pi3.model.produtos.Produtos"%>
<%@page import="br.senac.tads.pi3.db.dao.DaoProduto"%>
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
            ResultSet rsRegistro;
            boolean blnConectado;
            
            Produtos Produto = new Produtos();
            
            int idProduto = Integer.parseInt(request.getParameter("Codigo"));
            blnConectado = false;
            
            if (conexao.abrirConexao()){
                daoProduto.configurarConexao(conexao.obterConexao());
                
                rsRegistro = daoProduto.obter(idProduto);
                
                Produto.setIdProduto(idProduto);
                Produto.setCategoria(rsRegistro.getString("categ_prod"));
                Produto.setDescProduto(rsRegistro.getString("desc_prod"));
                Produto.setQtdEstoque(rsRegistro.getInt("qtd_Estoque"));
                Produto.setQtdEstoque(rsRegistro.getInt("qtd_Unidade"));
                Produto.setQtdEstoque(rsRegistro.getInt("valor_prod"));
                
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
                <br>
                <p> Descrição   : <%=Produto.getDescProduto()%></p>
                <p>Categoria: <%=Produto.getCategoria()%></p>
                <p>Qtde. Estoque: <%=Produto.getQtdEstoque()%></p>
                <p>Qtde. Unidade: <%=Produto.getQtdUnidade()%></p>
                <p>Valor: <%=Produto.getVlProduto()%></p>
                
                    <input type="hidden" name="codigo_produto" value="<%=idProduto%>" />
                    <br>
                
                <p>
                    <span class="LinkVoltar"><a href="javascript:history.back()">[Voltar]</a></span>
                    <input type="submit" value="Excluir" name="btnExcluir" />
                </p>
                
            </form>
                          
                          
            <p class="RodapePagina">Copyright(c) XPTO_2017. <p> 
            <%}%>
</body>
</html>
