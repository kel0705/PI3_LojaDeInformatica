<%-- 
    Document   : index
    Created on : 13/05/2017, 22:10:12
    Author     : Souza08
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
                <meta name="keywords" content="" />
                <meta name="description" content="" />
                <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
                <link href="default.css" rel="stylesheet" type="text/css" media="all" />
                <link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

                <!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
                <style><%@include file="CSS/default.css" %></style>
                <style><%@include file="CSS/fonts.css" %></style>
                </head>
                <body>

                    <div id="header-wrapper">
                        <div id="header" class="container">
                            <div id="logo">
                                <h1><a href="#">XPTO Tech</a></h1>
                                <span>Desenvolver <a rel="nofollow">é evoluir</a></span>
                            </div>
                            <div id="menu">
                                <div class="container-fluid">  
                                    <form action="Login" method="post">
                                        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                                            <div class="panel panel-info" >
                                                <div class="panel-heading">
                                                    <div class="panel-title">Login</div>

                                                </div>     

                                                <div style="padding-top:30px" class="panel-body" >

                                                    <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                                                    <form id="loginform" class="form-horizontal" role="form">

                                                        <div style="margin-bottom: 25px" class="input-group">
                                                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                                            <input name="loginForm" type="text" id="login" class="form-control" placeholder="Usuário"
                                                                   value ="<%= request.getAttribute("login") != null ? request.getAttribute("login") : ""%>">

                                                        </div>

                                                        <div style="margin-bottom: 25px" class="input-group">
                                                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                                            <input id="password" type="password" class="form-control" name="passwordForm" placeholder="Senha"
                                                                   value ="<%= request.getAttribute("password") != null ? request.getAttribute("password") : ""%>"/>
                                                        </div>

                                                        <% if (request.getAttribute("errormsg") != null) {%>    
                                                        <span  style="color:red;";style="display: table;margin-bottom: 14px">  <%= request.getAttribute("errormsg")%>  </span> 
                                                        <%}%>   


                                                        <div style="margin-top:10px" class="form-group">
                                                            <!-- Button -->

                                                            <div class="col-sm-12 controls">
                                                                <input class="botao-padrao" type="submit"  value="Login" /></br>
                                                                <!--<a id="btn-fblogin" href="#" class="btn btn-primary">Login com Facebook</a>-->

                                                            </div>
                                                        </div>

                                                    </form>     



                                                </div>                     
                                            </div>  
                                    </form>
                                </div>
                                <ul>

                                </ul>
                            </div>
                        </div>
                    </div>
                    <div id="wrapper4">
                        <div id="footer" class="container">
                            <div>
                                <header class="title">
                                    <span class="byline">Empresa jovem e revolucionaria</span> </header>
                                <ul class="contact">
                                    <li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
                                    <li><a href="#" class="icon icon-facebook"><span></span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </body>
                </html>