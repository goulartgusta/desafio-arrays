package br.com.almaviva.desafio.array.etapa2;

import br.com.almaviva.desafio.array.etapa2.models.Carro;
import br.com.almaviva.desafio.array.etapa2.models.Model;
import br.com.almaviva.desafio.array.etapa3.Array;
import br.com.almaviva.desafio.array.exceptions.ModelCastException;

public class ArrayCarro extends Array{

    public ArrayCarro(Integer tamanho) {
        super(tamanho);
    }

    @Override
    public void inserir(Model model) {
        try {
            Carro carro = (Carro) model;
            super.inserir(carro);
        } catch (ClassCastException e) {
            throw new ModelCastException("Falha ao inserir: não é Carro.", e);
        }
    }

    @Override
    public void remover(Model model) {
        try {
            Carro carro = (Carro) model;
            super.remover(carro);
        } catch (ClassCastException e) {
            throw new ModelCastException("Falha ao remover: não é Carro.", e);
        }
    }

    @Override
    public Model pesquisar(Model model) {
        try {
            Carro carro = (Carro) model;
            return super.pesquisar(carro); 
        } catch (ClassCastException e) {
            throw new ModelCastException("Falha ao pesquisar: não é Carro.", e);
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
            Carro carro = (Carro) model;
            super.atualizar(carro);
        } catch (ClassCastException e) {
            throw new ModelCastException("Falha ao atualizar: não é Carro.", e);
        }
    }
}
