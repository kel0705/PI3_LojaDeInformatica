/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.pi.model.vendas;

import br.com.senac.pi.model.Pessoa.Pessoa;
import br.com.senac.pi.model.produtos.Produtos;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Jonathan Souza
 */
public class Venda {

    
    private Integer cod_venda;   
    private double valorVenda;
    private Pessoa cliente;
    private Integer idFuncionario;
    private Produtos produto;
    private ArrayList<Produtos> produtos;
    private String  data;

  
    /**
     * @param produto the produto to set
     */
    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    /**
     * @return the valorVenda
     */
    public double getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }


    /**
     * @return the cliente
     */
    public Pessoa getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the cod_venda
     */
    public Integer getCod_venda() {
        return cod_venda;
    }

    /**
     * @param cod_venda the cod_venda to set
     */
    public void setCod_venda(Integer cod_venda) {
        this.cod_venda = cod_venda;
    }

    /**
     * @return the produto
     */
    public ArrayList<Produtos> getProduto() {
        return produtos;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ArrayList<Produtos> produto) {
        this.produtos = produto;
    }

    /**
     * @return the data
     */
    public String  getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String  data) {
        this.data = data;
    }
    
    
    
}
