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
    
   private int idProduto; 
   private String unidade; 
   private Double vlProduto;
   private String descProduto;
   private String categoria;
      
   public Produtos (){
       this.unidade = null;
       this.vlProduto = null;
       this.descProduto = "";
       this.categoria = "";
}
   
   public Produtos (String categoria, String descProduto, String unidade, double vlProd){
       this.unidade = unidade;
       this.vlProduto = vlProd;
       this.descProduto = descProduto;
       this.categoria = categoria;
   }

    /**
     * @return the id
     */
    public Integer getIdProduto() {
        return idProduto;
    }

    /**
     * @param id the id to set
     */
    public void setIdProduto(Integer id) {
        this.idProduto = id;
    }
    /**
     * @return the qtdUnidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param qtdUnidade the qtdUnidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the vlProd
     */
    public Double getVlProduto() {
        return vlProduto;
    }

    /**
     * @param vlProd the vlProd to set
     */
    public void setVlProduto(Double vlProd) {
        this.vlProduto = vlProd;
    }

    /**
     * @return the descProduto
     */
    public String getDescProduto() {
        return descProduto;
    }

    /**
     * @param descProduto the descProduto to set
     */
    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

   
  
}
