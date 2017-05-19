/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.pi.model.funcionario;

import br.com.senac.pi.model.filial.Filial;
import br.com.senac.pi.model.Pessoa.Pessoa;

/**
 *
 * @author Souza08
 */
public class Funcionario extends Pessoa {
    
    private Integer idFuncionario;
    private String cargo; 
    private Integer codAcesso; 
    private Filial filial;

    /**
     * @return the idFuncionario
     */
    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the codAcesso
     */
    public Integer getCodAcesso() {
        return codAcesso;
    }

    /**
     * @param codAcesso the codAcesso to set
     */
    public void setCodAcesso(Integer codAcesso) {
        this.codAcesso = codAcesso;
    }

    /**
     * @return the filial
     */
    public Filial getFilial() {
        return filial;
    }

    /**
     * @param filial the filial to set
     */
    public void setFilial(Filial filial) {
        this.filial = filial;
    }

 
}
