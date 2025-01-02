package br.com.almaviva.desafio.array.etapa4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.UnaryOperator;

public class MyList<E> {

    private Object[] elements;
    private int size;

    public MyList() {
        this.elements = new Object[10];
        this.size = 0;
    }

    private void increaseCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    public boolean add(E element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
        return true;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        validateIndex(index);
        return (E) elements[index];
    }

    public E set(int index, E element) {
        validateIndex(index);
        E oldElement = (E) elements[index];
        elements[index] = element;
        return oldElement;
    }

    public boolean remove(Object element) {
        int index = indexOf(element);
        if (index >= 0) {
            removeAt(index);
            return true;
        }
        return false;
    }

    public E removeAt(int index) {
        validateIndex(index);
        E removedElement = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removedElement;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object element) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void replaceAll(UnaryOperator<E> operator) {
        for (int i = 0; i < size; i++) {
            elements[i] = operator.apply((E) elements[i]);
        }
    }

    public void sort(Comparator<? super E> comparator) {
        Arrays.sort((E[]) elements, 0, size, comparator);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}
