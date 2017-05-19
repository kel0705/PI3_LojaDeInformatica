/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.pi.model.filial;

import br.com.senac.pi.model.endereco.Endereco;

/**
 *
 * @author Souza08
 */
public class Filial {
    
    private Integer idFilial; 
    private String descFilial;
    private String cnpj;
    private Endereco endereco;
    

    /**
     * @return the idFilial
     */
    public Integer getIdFilial() {
        return idFilial;
    }

    /**
     * @param idFilial the idFilial to set
     */
    public void setIdFilial(Integer idFilial) {
        this.idFilial = idFilial;
    }

    /**
     * @return the descFilial
     */
    public String getDescFilial() {
        return descFilial;
    }

    /**
     * @param descFilial the descFilial to set
     */
    public void setDescFilial(String descFilial) {
        this.descFilial = descFilial;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
