/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.pi.model.produtos;

import br.com.senac.pi.model.categoria.Categoria;

/**
 *
 * @author Jonathan Souza
 */
public class Produtos {

    
   private Integer id; 
   private Integer qtdProd; 
   private Double vlProd;
   private String produto;
   private Integer qtdUnidade; 
   private Categoria categoria;


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the qtdProd
     */
    public Integer getQtdProd() {
        return qtdProd;
    }

    /**
     * @param qtdProd the qtdProd to set
     */
    public void setQtdProd(Integer qtdProd) {
        this.qtdProd = qtdProd;
    }

    /**
     * @return the vlProd
     */
    public Double getVlProd() {
        return vlProd;
    }

    /**
     * @param vlProd the vlProd to set
     */
    public void setVlProd(Double vlProd) {
        this.vlProd = vlProd;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }
   
    
    /**
     * @return the qtdUnidade
     */
    public Integer getQtdUnidade() {
        return qtdUnidade;
    }

    /**
     * @param qtdUnidade the qtdUnidade to set
     */
    public void setQtdUnidade(Integer qtdUnidade) {
        this.qtdUnidade = qtdUnidade;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
   
}
