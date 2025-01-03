package br.com.almaviva.desafio.array.etapa1;

import br.com.almaviva.desafio.array.exceptions.MatrizClassException;

public class MyMatriz {

    private final Character[] linhaCaracteres;
    private final Integer[] linhaNumeros;

    public MyMatriz(Character[] caracteres, Integer[] numeros) {
        this.linhaCaracteres = caracteres.clone();
        this.linhaNumeros = numeros.clone();
    }

    public void inserirCaractere(int coluna, Object valor) {
        try {
            linhaCaracteres[coluna] = (Character) valor;
        } catch (Exception e) {
            throw new MatrizClassException("Erro ao inserir caractere na posição " + coluna + ": " + e.getMessage());
        }
    }

    public void inserirNumero(int coluna, Object valor) {
        try {
            linhaNumeros[coluna] = (Integer) valor;
        } catch (Exception e) {
            throw new MatrizClassException("Erro ao inserir número na posição " + coluna + ": " + e.getMessage());
        }
    }

    public Character buscarCaractere(int coluna) {
        try {
            return linhaCaracteres[coluna];
        } catch (Exception e) {
            throw new MatrizClassException("Erro ao buscar caractere na posição " + coluna + ": " + e.getMessage());
        }
    }

    public Integer buscarNumero(int coluna) {
        try {
            return linhaNumeros[coluna];
        } catch (Exception e) {
            throw new MatrizClassException("Erro ao buscar número na posição " + coluna + ": " + e.getMessage());
        }
    }

    public void removerCaractere(int coluna) {
        try {
            linhaCaracteres[coluna] = null;
        } catch (Exception e) {
            throw new MatrizClassException("Erro ao remover caractere na posição " + coluna + ": " + e.getMessage());
        }
    }

    public void removerNumero(int coluna) {
        try {
            linhaNumeros[coluna] = null;
        } catch (Exception e) {
            throw new MatrizClassException("Erro ao remover número na posição " + coluna + ": " + e.getMessage());
        }
    }

}
