package br.com.almaviva.desafio.array.etapa3;

import br.com.almaviva.desafio.array.etapa2.models.Model;

public class Array {

    private Model[] itens;

    public Array(Integer tamanho) {
        this.itens = new Model[tamanho];
    }

    public void inserir(Model model) {
        for (int posicao = 0; posicao < itens.length; posicao++) {
            if (itens[posicao] == null) {
                itens[posicao] = model;
                return;
            }
        }
    }

    public void remover(Model model) {
        for (int posicao = 0; posicao < itens.length; posicao++) {
            if (itens[posicao] == model) {
                itens[posicao] = null;
            }
        }
    }

    public Model pesquisar(Model model) {
        for (Model item : itens) {
            if (item == model) {
                return item;
            }
        }
        return null;
    }

    public void ordenarPorIdCrescente(int id) {
        for (int volta = 0; volta < itens.length - 1; volta++) {
            for (int comp = 0; comp < itens.length - volta - 1; comp++) {
                if (itens[comp].getId() > itens[comp + 1].getId()) {
                    Model temp = itens[comp];
                    itens[comp] = itens[comp + 1];
                    itens[comp + 1] = temp;
                }
            }
        }
    }

    public void ordenarPorIdDecrescente(int id) {
        for (int volta = 0; volta < itens.length - 1; volta++) {
            for (int comp = 0; comp < itens.length - volta - 1; comp++) {
                if (itens[comp].getId() < itens[comp + 1].getId()) {
                    Model temp = itens[comp];
                    itens[comp] = itens[comp + 1];
                    itens[comp + 1] = temp;
                }
            }
        }
    }

    public void atualizar(Model model) {
        for (int posicao = 0; posicao < itens.length; posicao++) {
            if (itens[posicao].getId().equals(model.getId())) {
                itens[posicao] = model;
            }
        }
    }

    public Model[] getItens() {
        return itens;
    }
}
