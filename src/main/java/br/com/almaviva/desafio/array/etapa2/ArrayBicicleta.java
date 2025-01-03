package br.com.almaviva.desafio.array.etapa2;

import br.com.almaviva.desafio.array.etapa2.models.Bicicleta;
import br.com.almaviva.desafio.array.etapa2.models.Model;
import br.com.almaviva.desafio.array.etapa3.Array;
import br.com.almaviva.desafio.array.exceptions.ModelCastException;

public class ArrayBicicleta extends Array {

    public ArrayBicicleta(Integer tamanho) {
        super(tamanho);
    }

    @Override
    public void inserir(Model model) {
        try {
            Bicicleta bike = (Bicicleta) model;
            super.inserir(bike);
        } catch (ClassCastException e) {
            throw new ModelCastException("Falha ao inserir: não é Bicicleta.", e);
        }
    }

    @Override
    public void remover(Model model) {
        try {
            Bicicleta bike = (Bicicleta) model;
            super.remover(bike);
        } catch (ClassCastException e) {
            throw new ModelCastException("Falha ao remover: não é Bicicleta.", e);
        }
    }

    @Override
    public Model pesquisar(Model model) {
        try {
            Bicicleta bike = (Bicicleta) model;
            return super.pesquisar(bike);
        } catch (ClassCastException e) {
            throw new ModelCastException("Falha ao pesquisar: não é Bicicleta.", e);
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
            Bicicleta bike = (Bicicleta) model;
            super.atualizar(bike);
        } catch (ClassCastException e) {
            throw new ModelCastException("Falha ao atualizar: não é Bicicleta.", e);
        }
    }
}
