package br.com.almaviva.desafio.array.etapa4;

import java.util.Objects;

public class MyMap<K, V> {
    private Object[] chaves;
    private Object[] valores;
    private int size;

    public MyMap() {
        chaves = new Object[10];
        valores = new Object[10];
        size = 0;
    }

    private void expandCapacity() {
        int newSize = chaves.length * 2;
        Object[] newChaves = new Object[newSize];
        Object[] newValores = new Object[newSize];
        System.arraycopy(chaves, 0, newChaves, 0, size);
        System.arraycopy(valores, 0, newValores, 0, size);
        chaves = newChaves;
        valores = newValores;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K chave) {
        return indexOfKey(chave) >= 0;
    }

    public boolean containsValue(V valor) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(valores[i], valor)) {
                return true;
            }
        }
        return false;
    }

    public V get(K chave) {
        int index = indexOfKey(chave);
        return index >= 0 ? (V) valores[index] : null;
    }

    public V put(K chave, V valor) {
        int index = indexOfKey(chave);
        if (index >= 0) {
            V oldValue = (V) valores[index];
            valores[index] = valor;
            return oldValue;
        }
        if (size == chaves.length) {
            expandCapacity();
        }
        chaves[size] = chave;
        valores[size] = valor;
        size++;
        return null;
    }

    public V remove(K chave) {
        int index = indexOfKey(chave);
        if (index >= 0) {
            V oldValue = (V) valores[index];
            for (int i = index; i < size - 1; i++) {
                chaves[i] = chaves[i + 1];
                valores[i] = valores[i + 1];
            }
            chaves[size - 1] = null;
            valores[size - 1] = null;
            size--;
            return oldValue;
        }
        return null;
    }

    private int indexOfKey(K chave) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(chaves[i], chave)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size; i++) {
            sb.append(chaves[i]).append("=").append(valores[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
