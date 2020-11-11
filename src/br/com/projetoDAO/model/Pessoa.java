
package br.com.projetoDAO.model;

public class Pessoa {
    
    private int id;
    private String nome;
    private String profissao;

    public Pessoa(String nome, String profissao) {
        this.nome = nome;
        this.profissao = profissao;
    }
    
    public Pessoa(int id) {
        this.id = id;        
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
   
   public String getProfissao() {
        return profissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", profissao=" + profissao + '}';
    }
}
