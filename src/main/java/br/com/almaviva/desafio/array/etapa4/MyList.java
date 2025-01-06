package br.com.almaviva.desafio.array.etapa4;

import java.util.Arrays;

public class MyList<E> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] elementos;
    private int quantidade;

    public MyList() {
        elementos = new Object[INITIAL_CAPACITY];
        quantidade = 0;
    }

    private void ensureCapacity() {
        if (quantidade >= elementos.length) {
            elementos = Arrays.copyOf(elementos, elementos.length * 2);
        }
    }

    public boolean add(E elemento) {
        ensureCapacity();
        elementos[quantidade++] = elemento;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int indice) {
        validateIndex(indice);
        return (E) elementos[indice];
    }

    @SuppressWarnings("unchecked")
    public E set(int indice, E elemento) {
        validateIndex(indice);
        E antigo = (E) elementos[indice];
        elementos[indice] = elemento;
        return antigo;
    }

    @SuppressWarnings("unchecked")
    public E removeByIndex(int indice) {
        validateIndex(indice);
        E removido = (E) elementos[indice];
        for (int i = indice; i < quantidade - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[--quantidade] = null;
        return removido;
    }

    public boolean remove(Object objeto) {
        int indice = indexOf(objeto);
        if (indice >= 0) {
            removeByIndex(indice);
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

    private void validateIndex(int indice) {
        if (indice < 0 || indice >= quantidade) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
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
