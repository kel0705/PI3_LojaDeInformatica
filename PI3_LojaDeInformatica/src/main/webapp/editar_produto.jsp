<%@page import="br.senac.pi3.model.produtos.Produtos"%>
<%@page import="br.senac.pi3.db.dao.DaoProduto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            ResultSet rsRegistros;
            boolean blnConectado;

            Produtos Produto = new Produtos();

            int idProduto = Integer.parseInt(request.getParameter("Codigo"));
            blnConectado = false;

            if (conexao.abrirConexao()) {
                daoProduto.configurarConexao(conexao.obterConexao());
                
                rsRegistros = daoProduto.obter(idProduto);

                Produto.setCategoria(rsRegistros.getString("categ_prod"));
                Produto.setDescProduto(rsRegistros.getString("desc_prod"));
                Produto.setQtdEstoque(Integer.parseInt(rsRegistros.getString("qtd_Estoque")));
                Produto.setQtdEstoque(Integer.parseInt(rsRegistros.getString("qtd_Unidade")));
                Produto.setVlProduto(Double.parseDouble(rsRegistros.getString("valor_prod")));

                blnConectado = true;
            } else {
                out.print("<p>Falha na conexão com o banco de dados!</p>");
            }
        %>

        <% if (blnConectado) {%>
        <p class="TituloAplicação"> Loja de Informática</p>
        <p class="TituloPagina">Cadastro de Produtos - Edição</p>

        <form name="formEditarProduto" action="atualizarProduto" method="POST">
            <p>Categoria: <select name="categoria" value="<%=Produto.getCategoria()%>">
                    <option value="item1" selected>Selecione</option>
                    <option value="item2">Acessórios</option>
                    <option value="item3">Computadores</option>
                    <option value="item4">Impressoras</option>
                    <option value="item5">Mouses</option>
                    <option value="item6">Notebooks</option>
                </select>
                
            
            <p>Produto: <input type="text" name="descricao" value="<%=Produto.getDescProduto()%>" size="50" /></p>

            <p>Quant. Estoque: <input type="text" name="qtdeEstoque" value="<%=Produto.getQtdEstoque()%>" size="3" /> <br>  
            <p>Quant. Unidade: <input type="text" name="qtdeUnidade" value="<%=Produto.getQtdUnidade()%>" size="3" /> <br>    
            <p>Valor: <input type="text" name="vlProduto" value="<%=Produto.getVlProduto()%>" size="10"/>


            <p><input type="hidden" name="codigo_produto" value="<%=idProduto%>"></p>

            <br>
            <p>
                <span class="LinkVoltar"><a href="javascript:history.back()">[Voltar]</a></span>
                <input type="submit" value="Salvar" name="btnSalvar" />
            </p>

        </form>


        <p class="RodapePagina">Copyright(c) XPTO_2017. <p>    
            <%}%>

    </body>
</html>
