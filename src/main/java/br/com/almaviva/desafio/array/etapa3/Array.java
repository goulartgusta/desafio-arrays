package br.com.almaviva.desafio.array.etapa3;

import br.com.almaviva.desafio.array.etapa2.models.Model;

public class Array {
    private Model[] items;

    public Array(int tamanho) {
        this.items = new Model[tamanho];
    }

    public Model[] getItems() {
        return items.clone();
    }

    public void inserir(Model model) {
        for (int posicao = 0; posicao < items.length; posicao++) {
            if (items[posicao] == null) {
                items[posicao] = model;
                return;
            }
        }
    }

    public void remover(Model model) {
        for (int posicao = 0; posicao < items.length; posicao++) {
            items[posicao] = items[posicao] == model ? null : items[posicao];
        }
    }

    public Model buscar(Model model) {
        for (int posicao = 0; posicao < items.length; posicao++) {
            if (items[posicao] == model) {
                return items[posicao];
            }
        }
        return null;
    }

    public void ordenarPorIdAscendente(int id) {
        for (int indiceExterno = 0; indiceExterno < items.length - 1; indiceExterno++) {
            for (int indiceInterno = 0; indiceInterno < items.length - indiceExterno - 1; indiceInterno++) {
                trocar(indiceInterno, indiceInterno + 1, 
                       items[indiceInterno] != null && 
                       items[indiceInterno + 1] != null && 
                       items[indiceInterno].getId() > items[indiceInterno + 1].getId());
            }
        }
    }

    public void ordenarPorIdDescendente(int id) {
        for (int indiceExterno = 0; indiceExterno < items.length - 1; indiceExterno++) {
            for (int indiceInterno = 0; indiceInterno < items.length - indiceExterno - 1; indiceInterno++) {
                trocar(indiceInterno, indiceInterno + 1, 
                       items[indiceInterno] != null && 
                       items[indiceInterno + 1] != null && 
                       items[indiceInterno].getId() < items[indiceInterno + 1].getId());
            }
        }
    }

    public void atualizar(Model model) {
        for (int posicao = 0; posicao < items.length; posicao++) {
            items[posicao] = (items[posicao] != null && items[posicao].getId() == model.getId()) ? model : items[posicao];
        }
    }

    private void trocar(int indice1, int indice2, boolean condicao) {
        if (condicao) {
            Model temp = items[indice1];
            items[indice1] = items[indice2];
            items[indice2] = temp;
        }
    }
}
