package br.com.almaviva.desafio.array.etapa4;

import java.util.Arrays;

public class MyList<E> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
<<<<<<< HEAD
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
=======
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        checkIndex(index);
        E old = (E) elements[index];
        elements[index] = element;
        return old;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        E removed = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removed;
    }

    public boolean remove(Object o) {
        int idx = indexOf(o);
        if (idx >= 0) {
            remove(idx);
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
>>>>>>> minha-nova-branch
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0; 
    }

<<<<<<< HEAD
    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if ((elements[i] == null && element == null) ||
                (elements[i] != null && elements[i].equals(element))) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

=======
>>>>>>> minha-nova-branch
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

<<<<<<< HEAD
    public E get(int index) {
        return (E) elements[index];
    }

    public E set(int index, E element) {
        E oldElement = (E) elements[index];
        elements[index] = element;
        return oldElement;
    }

    public boolean remove(Object element) {
        int index = indexOf(element);
        return index >= 0 && removeAt(index) != null;
    }

    public E removeAt(int index) {
        E removedElement = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removedElement;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if ((elements[i] == null && element == null) ||
                (elements[i] != null && elements[i].equals(element))) {
=======
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
    }

    private int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if ((elements[i] == null && o == null)
             || (elements[i] != null && elements[i].equals(o))) {
>>>>>>> minha-nova-branch
                return i;
            }
        }
        return -1;
    }
<<<<<<< HEAD

    public int lastIndexOf(Object element) {
        for (int i = size - 1; i >= 0; i--) {
            if ((elements[i] == null && element == null) ||
                (elements[i] != null && elements[i].equals(element))) {
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
=======
>>>>>>> minha-nova-branch
}
