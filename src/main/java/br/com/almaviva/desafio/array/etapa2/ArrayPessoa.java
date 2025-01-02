package br.com.almaviva.desafio.array.etapa2;

import br.com.almaviva.desafio.array.etapa2.models.Model;
import br.com.almaviva.desafio.array.etapa2.models.Pessoa;
import br.com.almaviva.desafio.array.etapa3.Array;

public class ArrayPessoa extends Array {

    public ArrayPessoa(int tamanho) {
        super(tamanho);
    }

    @Override
    public Pessoa[] getItems() {
        return (Pessoa[]) super.getItems();
    }

    @Override
    public void inserir(Model model) {
        if (model instanceof Pessoa) {
            super.inserir(model);
        }
    }

    @Override
    public void remover(Model model) {
        if (model instanceof Pessoa) {
            super.remover(model);
        }
    }

    @Override
    public Pessoa buscar(Model model) {
        if (model instanceof Pessoa) {
            return (Pessoa) super.buscar(model);
        }
        return null;
    }

    @Override
    public void ordenarPorIdAscendente(int id) {
        super.ordenarPorIdAscendente(id);
    }

    @Override
    public void ordenarPorIdDescendente(int id) {
        super.ordenarPorIdDescendente(id);
    }

    @Override
    public void atualizar(Model model) {
        if (model instanceof Pessoa) {
            super.atualizar(model);
        }
    }
}
