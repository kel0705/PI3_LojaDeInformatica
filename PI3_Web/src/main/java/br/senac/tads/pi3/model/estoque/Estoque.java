package br.senac.tads.pi3.model.estoque;

public class Estoque {
    public int id;
    public String nome;
    public int fkEmpresa;
    
    public Estoque(int i, String e, int emp){
        this.id = i;
        this.nome = e;
        this.fkEmpresa = emp;       
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getid(){
        return this.id;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public String getNome(){
        return this.nome;
    }
    public int getfkEmpresa(){
        return this.fkEmpresa;
    }
    public void setfkEmpresa(int fk){
        this.fkEmpresa = fk;
    }
}
