package br.com.almaviva.desafio.array.etapa4;

import java.util.Arrays;

public class MyMap<K, V> {

    private static final int CAPACIDADE_INICIAL = 10;
    private Entry<K, V>[] entradas;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public MyMap() {
        this.entradas = new Entry[CAPACIDADE_INICIAL];
        this.tamanho = 0;
    }

    static class Entry<K, V> {
        K chave;
        V valor;

        Entry(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    private void ensureCapacity() {
        if (tamanho >= entradas.length) {
            entradas = Arrays.copyOf(entradas, entradas.length * 2);
        }
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    public void clear() {
        Arrays.fill(entradas, 0, tamanho, null);
        tamanho = 0;
    }

    public boolean containsKey(K chave) {
        return indexOfKey(chave) >= 0;
    }

    public boolean containsValue(V valor) {
        for (int i = 0; i < tamanho; i++) {
            if ((entradas[i].valor == null && valor == null)
                    || (entradas[i].valor != null && entradas[i].valor.equals(valor))) {
                return true;
            }
        }
        return false;
    }

    public V get(K chave) {
        int indice = indexOfKey(chave);
        return (indice >= 0) ? entradas[indice].valor : null;
    }

    public V put(K chave, V valor) {
        for (int i = 0; i < tamanho; i++) {
            if (entradas[i].chave.equals(chave)) {
                V valorAntigo = entradas[i].valor;
                entradas[i].valor = valor;
                return valorAntigo;
            }
        }
        ensureCapacity();
        entradas[tamanho++] = new Entry<>(chave, valor);
        return null;
    }

    public V remove(K chave) {
        int indice = indexOfKey(chave);
        if (indice >= 0) {
            V valorAntigo = entradas[indice].valor;
            entradas[indice] = entradas[tamanho - 1];
            entradas[tamanho - 1] = null;
            tamanho--;
            return valorAntigo;
        }
        return null;
    }

    private int indexOfKey(K chave) {
        for (int i = 0; i < tamanho; i++) {
            K chaveAtual = entradas[i].chave;
            if ((chaveAtual == null && chave == null)
                    || (chaveAtual != null && chaveAtual.equals(chave))) {
                return i;
            }
        }
        return -1;
    }
}
