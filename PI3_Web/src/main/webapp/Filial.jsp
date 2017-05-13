<%-- 
    Document   : Filial
    Created on : 12/05/2017, 21:01:01
    Author     : nataly.lalves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Filiais</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="empresa" method="post">
            <div>		
                <label for="campoNome">Nome </label>
                <input id="camponome" type="text" name="nome"/>
            </div>
            <div>		
                <label for="campoFantasia">Nome Fantasia </label>
                <input id="campoFantasia" type="text" name="fantasia"/>
            </div>
            <div>	
                <label for="CNPJ">CNPJ</label>
                <input id="campoCNPJ" type="number" name="CNPJ"/>
            </div>
            <div>
                <label for="cidade">Cidade </label>
                <input id="campoCidade" type="text" name="cidade"/>
            </div>
            <div>
                <label for="estado">Estado </label>
                <input id="campoEstado" type="text" name="estado"/>
            </div>
            <div>
                <label for="telefone">Telefone</label>
                <input id="campoTelefone" type="number" name="telefone"/>
            </div>
            <button type="submit" value="Salvar">Enviar</button>
        </form>
    </body>
</html>