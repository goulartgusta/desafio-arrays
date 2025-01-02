package br.com.almaviva.desafio.array.etapa2.models;

public class Pessoa extends Model {
    private String nome;
    private int idade;
    private String cpf;

    public Pessoa(int id, String nome, int idade, String cpf) {
        super(id);
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
