<%-- 
    Document   : Empresa
    Created on : 04/05/2017, 01:13:46
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Empresas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
  <body>
    <form action="empresa" method="post">
        <div>		
            <label for="campoFantasia">Nome fantasia </label>
            <input id="campoFantasia" type="text" name="fantasia"/>
        </div>
        <div>	
            <label for="campoDtNasc">Dt. Nascimento </label>
            <input id="campoDtNasc" type="date" name="dtNasc"/>
        </div>
        <div>
              <label for="campoTelefone">Telefone </label>
              <input id="campoTelefone" type="number" name="telefone"/>
        </div>
        <div>
            <label for="campoEmail">E-mail </label>
            <input id="campoEmail" type="text" name="email"/>
        </div>
      <button type="submit" value="Salvar">Enviar</button>
    </form>
  </body>
</html>
