package br.com.almaviva.desafio.array.etapa4;

import java.util.Arrays;

public class MySet<E> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MySet() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    public boolean add(E element) {
        if (!contains(element)) {
            ensureCapacity();
            elements[size++] = element;
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            elements[index] = elements[size - 1];
            elements[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    private int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if ((elements[i] == null && o == null)
             || (elements[i] != null && elements[i].equals(o))) {
                return i;
            }
        }
        return -1;
    }
}
