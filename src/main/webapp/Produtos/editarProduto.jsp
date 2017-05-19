
<%@page import="java.util.List"%>
<%@page import="br.com.senac.pi.model.categoria.Categoria"%>
<%@page import="br.com.senac.pi.model.produtos.Produtos"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Produto</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
        <link href="default.css" rel="stylesheet" type="text/css" media="all" />
        <link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

        <style><%@include file="../CSS/default.css" %></style>
        <style><%@include file="../CSS/fonts.css" %></style>

    </head>
    <body>
        <% Produtos produto = (Produtos) session.getAttribute("ProdutoAtualiza");
        
           List<Categoria> listaCategoria = (List<Categoria>) session.getAttribute("ListaCategoriaAtualiza");
        
        
        %>
        <div id="wrapper3">
            <div id="three-column" class="container">
                <div><span class="arrow-down"></span></div>

                <div id="tbox1" class="paginaDeGerenciamento"> <span class="icon icon-group"></span>
                    <div id="textCustom" class="title">	<h2>Editar Produto</h2> </div>
                </div>

                <a id="botaoCustom" href="/XPTOTECH/dashboard.jsp" class="button">Voltar</a>

                <div class="container" >

                    <div class="cadastroFormulario" >

                        <form method="post" action="EditarProduto">

                            <fieldset class="fieldProd">
                                <legend>Informações do produto</legend>  
                            </fieldset>   
                            
                            
                            <input value="<%= produto.getId()%>" required="" name="idProd" type="hidden" id="idProd" class="form-control input-sm"> </br>


                            <div class="nomeProd">
                                <label  for="nomeProd">Nome: </label>			
                                <input  value="<%= produto.getProduto() %>" required="" name="nomeProd" type="text" id="nomeProd" class="form-control input-sm"> </br>
                            </div>

                            <div  class="categoriaProd">
                                <label  for="categoriaProd">Categoria: </label>
                            <select class="form-control" name="categoriaProd" id="categoriaProd" >
                                
                                    <%for(Categoria categoria : listaCategoria){ %>
                                    <option value="<%= categoria.getIdCategoria() %>"><%=categoria.getCategoria() %></option>
                                    <% }%>
                            </select>
                            
                            </div>							
							
                            <div  class="vlProd">
                                <label  for="vlProd">Valor: </label>
                                <input  required="" name="vlProd" value="<%= produto.getVlProd()%>"  type="text" id="vlProd" class="form-control input-sm"> </br>
                            </div>
                          
 

                            <div class="botaoCadastrarProd">
                                <input type="submit" class="btn btn-primary" value="Cadastrar"></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>      

        <c:import url="../Estrutura/footer.jsp"></c:import>
    </body>
</html>