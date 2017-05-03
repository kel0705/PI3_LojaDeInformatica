/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.model.produtos;

/**
 *
 * @author Kelly
 */
public class Produtos {
    
   private Integer id; 
   private String produto;
   private String categoria;
   private Integer qtdProd; 
   private Double vlProd;
   
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public Integer getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(Integer qtdProd) {
        this.qtdProd = qtdProd;
    }

    public Double getVlProd() {
        return vlProd;
    }

    public void setVlProd(Double vlProd) {
        this.vlProd = vlProd;
    }
  
}
