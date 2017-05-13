package br.senac.tads.pi3.model.estoque;

public class Estoque {
    public int id;
    public String nome;
    public int idEmpresa;
    
    public Estoque(int i, String e, int emp){
        this.id = i;
        this.nome = e;
        this.idEmpresa = emp;       
    }

    public Estoque(){
        
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public String getNome(){
        return this.nome;
    }
    public int getFkEmpresa(){
        return this.idEmpresa;
    }
    public void setidEmpresa(int fk){
        this.idEmpresa = fk;
    }
}
