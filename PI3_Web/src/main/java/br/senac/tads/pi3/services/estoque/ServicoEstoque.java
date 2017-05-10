package br.senac.tads.pi3.services.estoque;

import br.senac.tads.pi3.db.dao.DaoEstoque;
import br.senac.tads.pi3.exceptions.DataSourceException;
import br.senac.tads.pi3.exceptions.EstoqueException;
import br.senac.tads.pi3.model.estoque.Estoque;
import java.util.List;

public class ServicoEstoque{
        //Insere um estoque na fonte de dados
    public static void cadastrarEstoque(Estoque estoque)
            throws EstoqueException, DataSourceException {
        //Realização de validações de negócio
        if (estoque == null) {
            throw new EstoqueException("Não foi informado um estqoue");
        }
        if (estoque.getNome()== null || "".equals(estoque.getNome())) {
            throw new EstoqueException("É necessário informar um nome para o estoque");
        }
        /*
        if (estoque.getFkEmpresa() == null || estoque.getFkEmpresa() < 0){
            throw new EstoqueException("É necessário informar um valor para o produto");
        }
        if  (produto.getQtdProd()== null || produto.getVlProd()< 0) {
            throw new EstoqueException("É necessário informar um quantidade de produto válido");
        }
        */
        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoEstoque.inserir(estoque);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um produto na fonte de dados
    public static void atualizarEstoque(Estoque estoque)
            throws EstoqueException, DataSourceException {
        //Realização de validações de negócio
 if (estoque == null) {
            throw new EstoqueException("Não foi informado um produto");
        }
        if (estoque.getNome()== null || "".equals(estoque.getNome())) {
            throw new EstoqueException("É necessário informar um nome para produto");
        }
   
     
        if (estoque.getFkEmpresa()== 0 || estoque.getFkEmpresa()< 0) {
            throw new EstoqueException("É necessário informar uma quantidade de produto");
        }
        try {
            //Realiza a chamada de atualização na fonte de dados
            DaoEstoque.atualizar(estoque);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Realiza a pesquisa de um produto por nome na fonte de dados
    public static List<Estoque> procurarProduto(String estoque) throws EstoqueException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do banco.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            if (estoque == null || "".equals(estoque)) {
                return DaoEstoque.listar();
            } else {
                return DaoEstoque.procurar(estoque);
            }
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem o produto com ID informado do banco de dados
    public static Estoque obterEstoque(Integer id) throws EstoqueException, DataSourceException {
        try {
            //Retorna o produto obtido com o DAO
            return DaoEstoque.obter(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Exclui o produto com ID informado do banco de dados
    public static void excluirEstoque(Integer id) throws EstoqueException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do produto informado
            DaoEstoque.excluir(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
