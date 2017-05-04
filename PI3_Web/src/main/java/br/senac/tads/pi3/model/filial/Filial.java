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
    public String fantasia;
    public int id;
    
    public Filial(int id, String f){
        this.id = id;
        this.fantasia = f;
    }
    
    public int getId() {
        return this.id;
    }
    public String getFantasia() {
        return this.fantasia;
    }
    public void setFantasia(String f) {
        this.fantasia = f;
    }
}
