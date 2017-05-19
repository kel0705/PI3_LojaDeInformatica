<%-- 
    Document   : listarProduto
    Created on : 16/05/2017, 23:35:57
    Author     : Souza08
--%>

<%@page import="br.com.senac.pi.model.produtos.Produtos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
        <link href="default.css" rel="stylesheet" type="text/css" media="all" />
        <link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Produto</title>

        <style><%@include file="../CSS/default.css" %></style>
        <style><%@include file="../CSS/fonts.css" %></style>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />

    </head>
    <body>
        <% List<Produtos> listaProdutos = (List<Produtos>) session.getAttribute("listaProdutos"); %>
        
        <form action="ExcluiProduto" method="POST" name="formExcluirProduto">
            <input type="hidden" value="" name="idProdutoExcluir">
        </form>
        <div id="wrapper3"> 
            <div id="three-column" class="container">
                <div><span class="arrow-down"></span></div>

                <div id="tbox1" class="paginaDeGerenciamento"> <span class="icon icon-suitcase"></span>
                    <div id="textCustom" class="title">	<h2>Gerenciamento de Produtos</h2> </div>
                </div>

                <a id="botaoCustom" href="gerencia.html" class="button" style="border-radius: 10px;">Voltar</a>

                <div class="container">
                    <div class="row">


                        <div class="col-md-12">
                            <div style="margin-top: -250px;" class="table-responsive">


                                <table     id="mytable" class="table table-bordred table-striped">

                                    <thead>

                                    <th>ID Produto</th>
                                    <th>Produto</th>
                                    <th>Categoria</th>
                                    <th>Valor</th>
                                    <th>Edit</th>

                                    <th>Delete</th>
                                    </thead>
                                    <tbody>
                                        <%for(Produtos produto : listaProdutos){ %>    
                                        <tr>
                                            <td><%= produto.getId()%></td>
                                            <td><%= produto.getProduto()%></td>
                                            <td><%= produto.getCategoria().getCategoria()%></td>
                                            <td><%= produto.getVlProd()%></td>
                                            <td><p data-placement="top" data-toggle="tooltip" title="Edit"><a href="EditarProduto?idProduto=<%=produto.getId()%>" class="btn btn-primary btn-xs" data-title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a></p></td>
                                            <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs excluir-produto"  data-idProduto="<%=produto.getId()%>" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                                        </tr> 
                                        <%} %>
                                    </tbody>

                                </table>

                                <div class="clearfix"></div>


                            </div>

                        </div>
                    </div>
                </div>


                <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                                <h4 class="modal-title custom_align" id="Heading">Edit Your Detail</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <input class="form-control " type="text" placeholder="Mohsin">
                                </div>
                                <div class="form-group">

                                    <input class="form-control " type="text" placeholder="Irshad">
                                </div>
                                <div class="form-group">
                                    <textarea rows="2" class="form-control" placeholder="CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan"></textarea>


                                </div>
                            </div>
                            <div class="modal-footer ">
                                <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>
                            </div>
                        </div>
                        <!-- /.modal-content --> 
                    </div>
                    <!-- /.modal-dialog --> 
                </div>



                <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                                <h4 class="modal-title custom_align" id="Heading">Deletar Produto</h4>
                            </div>
                            <div class="modal-body">

                                <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Tem certeza que deseja excluir esse registro?</div>

                            </div>
                            <div class="modal-footer ">
                                <button type="button" class="btn btn-success btn-confirm-excluir" ><span class="glyphicon glyphicon-ok-sign"></span> Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Não</button>
                            </div>
                        </div>
                        <!-- /.modal-content --> 
                    </div>
                    <!-- /.modal-dialog --> 
                </div>

            </div>
        </div>

    <c:import url="Estrutura/footer.jsp"></c:import>
    <script
            src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
        crossorigin="anonymous"></script>
        <script>

            $(function () {

                $(".excluir-produto").on('click', function () {

                    let idProduto = $(this).attr('data-idProduto');


                    formExcluirProduto.idProdutoExcluir.value = idProduto;
                });

                $('.btn-confirm-excluir').on('click', function () {

                    formExcluirProduto.submit();
                });


            });

        </script>

</body>
</html>

