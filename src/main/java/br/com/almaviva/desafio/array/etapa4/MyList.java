package br.com.almaviva.desafio.array.etapa4;

import java.util.*;
import java.util.function.UnaryOperator;

class MyList<T> {
    private Object[] elements;
    private int size;

    public MyList() {
        elements = new Object[10];
        size = 0;
    }

    public void add(T element) {
        if (size == elements.length) {
            expandCapacity();
        }
        elements[size++] = element;
    }

    public void addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    public T get(int index) {
        validateIndex(index);
        return (T) elements[index];
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int lastIndexOf(Object element) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(elements[i], element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Object element) {
        int index = indexOf(element);
        if (index >= 0) {
            removeAt(index);
            return true;
        }
        return false;
    }

    public T removeAt(int index) {
        validateIndex(index);
        T removedElement = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removedElement;
    }

    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            while (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }

    public void replaceAll(UnaryOperator<T> operator) {
        for (int i = 0; i < size; i++) {
            elements[i] = operator.apply((T) elements[i]);
        }
    }

    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i])) {
                removeAt(i--);
                modified = true;
            }
        }
        return modified;
    }

    public T set(int index, T element) {
        validateIndex(index);
        T oldElement = (T) elements[index];
        elements[index] = element;
        return oldElement;
    }

    public void sort(Comparator<? super T> c) {
        Arrays.sort((T[]) elements, 0, size, c);
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    private void expandCapacity() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
