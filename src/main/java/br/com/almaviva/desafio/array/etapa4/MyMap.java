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

    private void expandirTamanho() {
        int novoTamanho = chaves.length * 2;
        Object[] novasChaves = new Object[novoTamanho];
        Object[] novosValores = new Object[novoTamanho];

        for (int i = 0; i < size; i++) {
            novasChaves[i] = chaves[i];
            novosValores[i] = valores[i];
        }

        chaves = novasChaves;
        valores = novosValores;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K chave) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(chaves[i], chave)) {
                return true;
            }
        }
        return false;
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
        for (int i = 0; i < size; i++) {
            if (Objects.equals(chaves[i], chave)) {
                return (V) valores[i];
            }
        }
        return null;
    }

    public V put(K chave, V valor) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(chaves[i], chave)) {
                V antigoValor = (V) valores[i];
                valores[i] = valor;
                return antigoValor;
            }
        }

        if (size == chaves.length) {
            expandirTamanho();
        }

        chaves[size] = chave;
        valores[size] = valor;
        size++;
        return null;
    }

    public V remove(K chave) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(chaves[i], chave)) {
                V valorRemovido = (V) valores[i];

                for (int j = i; j < size - 1; j++) {
                    chaves[j] = chaves[j + 1];
                    valores[j] = valores[j + 1];
                }

                chaves[size - 1] = null;
                valores[size - 1] = null;
                size--;
                return valorRemovido;
            }
        }
        return null;
    }

    public Object[] keys() {
        Object[] resultado = new Object[size];
        for (int i = 0; i < size; i++) {
            resultado[i] = chaves[i];
        }
        return resultado;
    }

    public Object[] values() {
        Object[] resultado = new Object[size];
        for (int i = 0; i < size; i++) {
            resultado[i] = valores[i];
        }
        return resultado;
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
