package br.com.almaviva.desafio.array.etapa2;

import br.com.almaviva.desafio.array.etapa2.models.Bicicleta;
import br.com.almaviva.desafio.array.etapa2.models.Model;
import br.com.almaviva.desafio.array.etapa3.Array;

public class ArrayBicicleta extends Array {

    public ArrayBicicleta(int tamanho) {
        super(tamanho);
    }

    @Override
    public Bicicleta[] getItems() {
        return (Bicicleta[]) super.getItems();
    }

    @Override
    public void inserir(Model model) {
        if (model instanceof Bicicleta) {
            super.inserir(model);
        }
    }

    @Override
    public void remover(Model model) {
        if (model instanceof Bicicleta) {
            super.remover(model);
        }
    }

    @Override
    public Bicicleta buscar(Model model) {
        if (model instanceof Bicicleta) {
            return (Bicicleta) super.buscar(model);
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
        if (model instanceof Bicicleta) {
            super.atualizar(model);
        }
    }
}
