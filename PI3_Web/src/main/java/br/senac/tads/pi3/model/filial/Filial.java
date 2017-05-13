/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.model.filial;

/**
 *
 * @author Vitor
 */
public class Filial {
    public int id;
    public String nomeFantasia;
    public int cnpj = 0;
    public String nomeFilial;
    
    
    public Filial(int id, String nomeFantasia, int cnpj, String nomeFilial){
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.nomeFilial = nomeFilial;
    }

    public Filial(int i, String pwi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Filial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId() {
        return this.id;
    }
    public String getNomeFantasia() {
        return this.nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public int getCnpj(){
        return this.cnpj;
    }
    public void setCnpj(int cnpj){
        this.cnpj = cnpj;
    }
    public String getNomeFilial(){
        return this.nomeFilial;
    }
    public void setNomeFilial(String nomeFilial){
        this.nomeFilial = nomeFilial;
    }
}
