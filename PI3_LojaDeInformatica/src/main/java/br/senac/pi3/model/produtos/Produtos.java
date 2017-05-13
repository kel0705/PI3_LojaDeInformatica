/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.model.produtos;

/**
 *
 * @author Kelly
 */
public class Produtos {
    
   private int idProduto; 
   private int qtdEstoque;
   private int qtdUnidade; 
   private Double vlProduto;
   private String descProduto;
   private String categoria;
      
   public Produtos (){
       this.qtdEstoque = 0;
       this.qtdUnidade = 0;
       this.vlProduto = null;
       this.descProduto = "";
       this.categoria = "";
}
   
   public Produtos (String categoria, String descProduto, int qtdEstoque, int qtdUnidade, double vlProd){
       this.qtdEstoque = qtdEstoque;
       this.qtdUnidade = qtdUnidade;
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
     * @return the qtdEstoque
     */
    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    /**
     * @param qtdEstoque the qtdEstoque to set
     */
    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
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
