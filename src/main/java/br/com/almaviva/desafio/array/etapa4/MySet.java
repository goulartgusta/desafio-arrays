package br.com.almaviva.desafio.array.etapa4;

import java.util.ArrayList;
import java.util.List;

public class MySet<E> {
    private Object[] elementos;
    private int tamanho;

    public MySet() {
        this.elementos = new Object[10];
        this.tamanho = 0;
    }

    private void aumentarTamanho() {
        Object[] novoArray = new Object[elementos.length * 2];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = elementos[i];
        }
        elementos = novoArray;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean contains(E elemento) {
        for (int i = 0; i < tamanho; i++) {
            if ((elemento == null && elementos[i] == null) || 
                (elemento != null && elemento.equals(elementos[i]))) {
                return true;
            }
        }
        return false;
    }

    public boolean add(E elemento) {
        if (contains(elemento)) {
            return false;
        }
        if (tamanho == elementos.length) {
            aumentarTamanho();
        }
        elementos[tamanho++] = elemento;
        return true;
    }

    public boolean remove(E elemento) {
        for (int i = 0; i < tamanho; i++) {
            if ((elemento == null && elementos[i] == null) || 
                (elemento != null && elemento.equals(elementos[i]))) {
                for (int j = i; j < tamanho - 1; j++) {
                    elementos[j] = elementos[j + 1];
                }
                elementos[--tamanho] = null;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < tamanho; i++) {
            elementos[i] = null;
        }
        tamanho = 0;
    }

    public List<E> toList() {
        List<E> lista = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            lista.add((E) elementos[i]);
        }
        return lista;
    }
}
