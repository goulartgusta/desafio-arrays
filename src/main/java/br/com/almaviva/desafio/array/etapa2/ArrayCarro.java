package br.com.almaviva.desafio.array.etapa2;

import br.com.almaviva.desafio.array.etapa2.models.Carro;
import br.com.almaviva.desafio.array.etapa2.models.Model;
import br.com.almaviva.desafio.array.etapa3.Array;

public class ArrayCarro extends Array {

    public ArrayCarro(int tamanho) {
        super(tamanho);
    }

    @Override
    public Carro[] getItems() {
        return (Carro[]) super.getItems();
    }

    @Override
    public void inserir(Model model) {
        if (model instanceof Carro) {
            super.inserir(model);
        }
    }

    @Override
    public void remover(Model model) {
        if (model instanceof Carro) {
            super.remover(model);
        }
    }

    @Override
    public Carro buscar(Model model) {
        if (model instanceof Carro) {
            return (Carro) super.buscar(model);
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
        if (model instanceof Carro) {
            super.atualizar(model);
        }
    }
}
