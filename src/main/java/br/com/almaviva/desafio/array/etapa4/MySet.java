package br.com.almaviva.desafio.array.etapa4;

import java.util.Arrays;

public class MySet<E> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] elementos;
    private int quantidade;

    public MySet() {
        elementos = new Object[INITIAL_CAPACITY];
        quantidade = 0;
    }

    private void ensureCapacity() {
        if (quantidade >= elementos.length) {
            elementos = Arrays.copyOf(elementos, elementos.length * 2);
        }
    }

    public boolean add(E elemento) {
        if (!contains(elemento)) {
            ensureCapacity();
            elementos[quantidade++] = elemento;
            return true;
        }
        return false;
    }

    public boolean remove(Object objeto) {
        int indice = indexOf(objeto);
        if (indice >= 0) {
            elementos[indice] = elementos[quantidade - 1];
            elementos[quantidade - 1] = null;
            quantidade--;
            return true;
        }
        return false;
    }

    public boolean contains(Object objeto) {
        return indexOf(objeto) >= 0;
    }

    public int size() {
        return quantidade;
    }

    public boolean isEmpty() {
        return quantidade == 0;
    }

    public void clear() {
        Arrays.fill(elementos, 0, quantidade, null);
        quantidade = 0;
    }

    private int indexOf(Object objeto) {
        for (int i = 0; i < quantidade; i++) {
            if ((elementos[i] == null && objeto == null)
             || (elementos[i] != null && elementos[i].equals(objeto))) {
                return i;
            }
        }
        return -1;
    }
}
