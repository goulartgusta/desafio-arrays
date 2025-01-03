package br.com.almaviva.desafio.array.etapa1;

import br.com.almaviva.desafio.array.exceptions.MatrizException;

public class MyMatriz {

	private final Number[][] matrizNumerica;
	private final Character[][] matrizCaracteres;

	public MyMatriz(Integer linhas, Integer colunas) {
		this.matrizNumerica = new Number[linhas][colunas];
		this.matrizCaracteres = new Character[linhas][colunas];
	}

	public void inserirNumero(Integer linha, Integer coluna, Number elemento) {
		try {
			matrizNumerica[linha][coluna] = elemento;
		} catch (Exception e) {
			throw new MatrizException("Erro ao inserir número: " + e.getMessage());
		}
	}

	public void inserirCaractere(Integer linha, Integer coluna, Character elemento) {
		try {
			matrizCaracteres[linha][coluna] = elemento;
		} catch (Exception e) {
			throw new MatrizException("Erro ao inserir caractere: " + e.getMessage());
		}
	}

	public Number buscarNumero(Integer linha, Integer coluna) {
		try {
			return matrizNumerica[linha][coluna];
		} catch (Exception e) {
			throw new MatrizException("Erro ao buscar número: " + e.getMessage());
		}
	}

	public Character buscarCaractere(Integer linha, Integer coluna) {
		try {
			return matrizCaracteres[linha][coluna];
		} catch (Exception e) {
			throw new MatrizException("Erro ao buscar caractere: " + e.getMessage());
		}
	}

	public void removerNumero(Integer linha, Integer coluna) {
		try {
			matrizNumerica[linha][coluna] = null;
		} catch (Exception e) {
			throw new MatrizException("Erro ao remover número: " + e.getMessage());
		}
	}

	public void removerCaractere(Integer linha, Integer coluna) {
		try {
			matrizCaracteres[linha][coluna] = null;
		} catch (Exception e) {
			throw new MatrizException("Erro ao remover caractere: " + e.getMessage());
		}
	}
}
