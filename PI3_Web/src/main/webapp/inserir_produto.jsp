
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema XPTO 1.0</title>
    </head>

    <body class="FundoPagina">
        <p class="TituloAplicação"> Loja de Informática</p>
        <p class="TituloPagina">Cadastro de Produtos - Inserir</p>

        <form name="formInsereProduto" action="inserirProduto" method="POST" target="_parent">

            <p>Categoria: <select name="categoria" >
                    <option value="item1" selected>Selecione</option>
                    <option value="item2">Acessórios</option>
                    <option value="item3">Computadores</option>
                    <option value="item4">Impressoras</option>
                    <option value="item5">Mouses</option>
                    <option value="item6">Notebooks</option>
                </select>

            <p>Produto: <input type="text" name="descricao" value="" size="50" />   
            <p>Unidade: <input type="text" name="unidade" value="" size="20" /> <br>    
            <p>Valor: <input type="text" name="vlProduto" value="" size="10"/>
                <br><br><br>


            <p>

                <span class="LinkVoltar"><a href="javascript:history.back()">[Voltar]</a></span>
                <input type="submit" value="Salvar" name="btnSalvar" />

            </p>

        </form>

        <p class="RodapePagina">Copyright(c) XPTO_2017. <p>

    </body>
</html>

