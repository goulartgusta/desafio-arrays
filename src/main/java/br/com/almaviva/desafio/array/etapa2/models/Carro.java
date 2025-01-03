package br.com.almaviva.desafio.array.etapa2.models;

public class Carro extends Model {
    private String marca;
    private String placa;
    private int ano;

    public Carro(int id, String marca, String placa, int ano) {
        super(id);
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
