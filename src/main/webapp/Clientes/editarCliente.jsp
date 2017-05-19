
<%@page import="br.com.senac.pi.model.cliente.Cliente"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
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
    <body>
        <% Cliente cliente = (Cliente) session.getAttribute("clienteAtualiza");%> 
        <div id="wrapper3">
            <div id="three-column" class="container">
                <div><span class="arrow-down"></span></div>

                <div id="tbox1" class="paginaDeGerenciamento"> <span class="icon icon-group"></span>
                    <div id="textCustom" class="title">	<h2>Editar Cliente</h2> </div>
                </div>

                <a id="botaoCustom" href="/XPTOTECH/ListarClientes" class="button">Voltar</a>

                <div class="container" >

                    <div class="cadastroFormulario">

                        <form method="post" action="EditarCliente">

                            <fieldset class="fieldCliente">
                                <legend>Dados Pessoais</legend>  
                            </fieldset>       
                            <div class="nomeCliente">
                                <input type="hidden" value="<%= cliente.getId()%>" name="idClienteAtualiza"> 
                                <label  for="nome">Nome: </label>			
                                <input requerid="" name="nomeCliente" type="text" id="nomeCliente"  value="<%= cliente.getNome()%>" class="form-control input-sm"> </br>
                            </div>
                            <div  class="sobreNomeCliente">
                                <label  for="sobreNomeCliente">Sobrenome: </label>
                                <input requerid="" name="sobreNomeCliente" type="text" id="sobreNomeCliente" value="<%= cliente.getSobrenome()%>"  class="form-control input-sm"> </br>
                            </div>			

                            <div  class="dataNascimentoCliente">    
                                <label  for="dataNascimentoCliente">Data Nascimento:  </label>
                                <input maxlength="10" requerid="" OnKeyPress="formatar('##/##/####', this)" name="dataNascimentoCliente"  type="text" id="dataNascimentoCliente" value="<%= cliente.getDtNasc()%>" class="form-control input-sm"> </br>
                            </div>
                            <div  class="cpfCliente">
                                <label  for="cpfCliente">CPF:  </label>
                                <input  maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" requerid="" name="cpfCliente" type="text" id="cpfCliente" value="<%= cliente.getCpf()%>" class="form-control input-sm" > </br>
                            </div>

                            <label  class="teste"  for="sexoCliente">Sexo:  </label>
                           <div  class="selectSexoCliente">
                            <select class="form-control" name="selectSexoCliente" >
                                <% if (cliente.getSexo().equals("M")) { %>
                                <option value="M" >Masculino</option>
                                <option value="F">Feminino</option>
                                <% } else { %>
                                <option value="F">Feminino</option>
                                <option value="M" >Masculino</option>
                                <% }%>
                            </select>
                    </div>
                 
                        <div required="" class="celularCliente">			
                            <label  for="celularCliente">Celular:  </label>
                            <input maxlength="13" OnKeyPress="formatar('##-#####-####', this)" requerid="" name="celularCliente" type="text" size="30" id="celularCliente" class="form-control input-sm" value="<%= cliente.getCel()%>" > </br>
                        </div>		
                        <div class="emailCliente">
                            <label style="margin-right: 12px" for="emailCliente">Email:  </label>
                            <input size="37" name="emailCliente" type="text" id="emailCliente" class="form-control input-sm" value="<%= cliente.getEmail()%>"> </br></br>
                        </div>
                        <fieldset  class="fieldEndreco">
                            <legend>Endereço - Cliente</legend>
                        </fieldset> 

                        <input type="hidden" value="<%= cliente.getEndereco().getId()%>" name="idEnderecoAtualiza" > 
                        <div class="enderecoCliente">
                            <label>Rua: </label> 
                            <input requerid="" size="30" type="text" id="enderecoCliente" maxlength="80" name="enderecoCliente" class="form-control input-sm" value="<%= cliente.getEndereco().getRua()%>">
                        </div>
                        <div class="numEnderecoCliente">
                            <label>Número: </label> 
                            <input requerid="" size="4" type="text" id="numEnderecoCliente" maxlength="5" name="numEnderecoCliente" class="form-control input-sm" value="<%= cliente.getEndereco().getNumero()%>" >
                        </div>
                        <div class="cepCliente">
                            <label>Cep:</label>
                            <input OnKeyPress="formatar('#####-###', this)" requerid="" id="cepCliente"  type="cepCliente" maxlength="9" name="cepCliente" class="form-control input-sm" value="<%= cliente.getEndereco().getCep()%>" > </br>
                        </div>
                        <div class="bairroCliente">
                            <label>Bairro: </label> 
                            <input requerid="" type="text" id="bairroCliente" maxlength="40" name="bairroCliente"class="form-control input-sm" value="<%= cliente.getEndereco().getBairro()%>">
                        </div>
                        <div class="cidadeCliente">
                            <label>Cidade: </label>
                            <input requerid="" type="text" id="cidadeCliente" maxlength="40" name="cidadeCliente"class="form-control input-sm" value="<%= cliente.getEndereco().getCidade()%>">
                        </div>

                        <div class="estadoCliente">
                            <label>Estado: </label>
                            <input requerid="" size="6" type="text" id="estadoCliente" maxlength="2" name="estadoCliente"class="form-control input-sm" value="<%= cliente.getEndereco().getEstado()%>"></br>
                        </div>

                        <div class="botaoCadastrarCliente">
                            <input type="submit" class="btn btn-primary" value="Atualizar"></button>
                        </div>
                        </form>

                    </div>
                </div>


            </div>
        </div>

        <script>
		function formatar(mascara, documento){
			var i = documento.value.length;
			var saida = mascara.substring(0,1);
			var texto = mascara.substring(i)
			
			if (texto.substring(0,1) != saida){
				documento.value += texto.substring(0,1);
			}
			
		}
        </script>  



        <c:import url="../Estrutura/footer.jsp"></c:import>
    </body>
</html>
