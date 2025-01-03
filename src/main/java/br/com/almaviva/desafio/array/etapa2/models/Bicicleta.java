package br.com.almaviva.desafio.array.etapa2.models;

public class Bicicleta extends Model {

    private String cor;
    private String marca;
    private Integer tamanhoQuadro;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getTamanhoQuadro() {
        return tamanhoQuadro;
    }

    public void setTamanhoQuadro(Integer tamanhoQuadro) {
        this.tamanhoQuadro = tamanhoQuadro;
    }
}
