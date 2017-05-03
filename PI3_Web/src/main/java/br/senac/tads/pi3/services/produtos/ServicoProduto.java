package br.senac.tads.pi3.services.produtos;
/**
 *
 * @author Kelly
 */
import br.senac.tads.pi3.db.dao.DaoProduto;
import br.senac.tads.pi3.exceptions.ProdutoException;

import br.senac.tads.pi3.exceptions.DataSourceException;
import br.senac.tads.pi3.model.produtos.Produtos;
import java.util.List;

/**
 * Classe de serviço de produto *
 */
public class ServicoProduto {

    //Insere um produto na fonte de dados
    public static void cadastrarProduto(Produtos produto)
            throws ProdutoException, DataSourceException {
        //Realização de validações de negócio
        if (produto == null) {
            throw new ProdutoException("Não foi informado um produto");
        }
        if (produto.getProduto()== null || "".equals(produto.getProduto())) {
            throw new ProdutoException("É necessário informar um nome para produto");
        }   
     
        if (produto.getVlProd()== null
                || produto.getVlProd()< 0) {
            throw new ProdutoException("É necessário informar um valor para o produto");
        }
        if  (produto.getQtdProd()== null
              || produto.getVlProd()< 0) {
            throw new ProdutoException("É necessário informar um quantidade de produto válido");
        }

        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoProduto.inserir(produto);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um produto na fonte de dados
    public static void atualizarProduto(Produtos produto)
            throws ProdutoException, DataSourceException {
        //Realização de validações de negócio
 if (produto == null) {
            throw new ProdutoException("Não foi informado um produto");
        }
        if (produto.getProduto()== null || "".equals(produto.getProduto())) {
            throw new ProdutoException("É necessário informar um nome para produto");
        }
   
     
        if (produto.getQtdProd()== null
                || produto.getQtdProd()< 0) {
            throw new ProdutoException("É necessário informar uma quantidade de produto");
        }
        if (produto.getVlProd()== null
                || produto.getVlProd()< 0) {
            throw new ProdutoException("É necessário informar um valor para o produto");
        }

        try {
            //Realiza a chamada de atualização na fonte de dados
            DaoProduto.atualizar(produto);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Realiza a pesquisa de um produto por nome na fonte de dados
    public static List<Produtos> procurarProduto(String produto)
            throws ProdutoException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do banco.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            if (produto == null || "".equals(produto)) {
                return DaoProduto.listar();
            } else {
                return DaoProduto.procurar(produto);
            }
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem o produto com ID informado do banco de dados
    public static Produtos obterProduto(Integer id)
            throws ProdutoException, DataSourceException {
        try {
            //Retorna o produto obtido com o DAO
            return DaoProduto.obter(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Exclui o produto com ID informado do banco de dados
    public static void excluirProduto(Integer id)
            throws ProdutoException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do produto informado
            DaoProduto.excluir(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}