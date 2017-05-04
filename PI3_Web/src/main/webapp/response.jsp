<%-- 
    Document   : produto2
    Created on : 03/05/2017, 22:31:48
    Author     : Kelly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="teste.TesteJSP" />
        <jsp:setProperty name="mybean" property="name" />
        <h1>Hello, <jsp:getProperty name="mybean" property="name" />!</h1>
    </body>
</html>
