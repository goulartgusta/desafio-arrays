package br.com.almaviva.desafio.array.etapa2;

import br.com.almaviva.desafio.array.etapa2.models.Pessoa;
import br.com.almaviva.desafio.array.etapa2.models.Model;
import br.com.almaviva.desafio.array.etapa3.Array;
import br.com.almaviva.desafio.array.exceptions.ModelCastException;

public class ArrayPessoa extends Array {

	public ArrayPessoa(Integer tamanho) {
		super(tamanho);
	}

	@Override
	public void inserir(Model model) {
		try {
			Pessoa pessoa = (Pessoa) model;
			super.inserir(pessoa);
		} catch (ClassCastException e) {
			throw new ModelCastException("Falha ao inserir: não é Pessoa.", e);
		}
	}

	@Override
	public void remover(Model model) {
		try {
			Pessoa pessoa = (Pessoa) model;
			super.remover(pessoa);
		} catch (ClassCastException e) {
			throw new ModelCastException("Falha ao remover: não é Pessoa.", e);
		}
	}

	@Override
	public Model pesquisar(Model model) {
		try {
			Pessoa pessoa = (Pessoa) model;
			return super.pesquisar(pessoa);
		} catch (ClassCastException e) {
			throw new ModelCastException("Falha ao pesquisar: não é Pessoa.", e);
		}
	}

	@Override
	public void ordenarPorIdCrescente(int id) {
		super.ordenarPorIdCrescente(id);
	}

	@Override
	public void ordenarPorIdDecrescente(int id) {
		super.ordenarPorIdDecrescente(id);
	}

	@Override
	public void atualizar(Model model) {
		try {
			Pessoa pessoa = (Pessoa) model;
			super.atualizar(pessoa);
		} catch (ClassCastException e) {
			throw new ModelCastException("Falha ao atualizar: não é Pessoa.", e);
		}
	}
}
