package br.com.almaviva.desafio.array.etapa2.models;

public class Bicicleta extends Model {
    private String marca;
    private String cor;
    private int anoFabricacao;

    public Bicicleta(int id, String marca, String cor, int anoFabricacao) {
        super(id);
        this.marca = marca;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

}
