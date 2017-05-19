package br.com.senac.pi.model.cliente;

import br.com.senac.pi.model.Pessoa.Pessoa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Souza08
 */
public class Cliente extends Pessoa {
    
        
    private Integer idCliente; 
    private String dtCadastro; 
    
    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the dtCadastro
     */
    public String getDtCadastro() {
        return dtCadastro;
    }

    /**
     * @param dtCadastro the dtCadastro to set
     */
    public void setDtCadastro(String dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
   
    
}
