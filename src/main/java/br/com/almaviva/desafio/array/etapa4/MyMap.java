package br.com.almaviva.desafio.array.etapa4;

import java.util.Arrays;

public class MyMap<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private Entry<K, V>[] entries;
    private int size;

    @SuppressWarnings("unchecked")
    public MyMap() {
        this.entries = new Entry[INITIAL_CAPACITY];
        this.size = 0;
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private void ensureCapacity() {
        if (size >= entries.length) {
            entries = Arrays.copyOf(entries, entries.length * 2);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(entries, 0, size, null);
        size = 0;
    }

    public boolean containsKey(K key) {
        return indexOfKey(key) >= 0;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < size; i++) {
            if ((entries[i].value == null && value == null)
             || (entries[i].value != null && entries[i].value.equals(value))) {
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        int idx = indexOfKey(key);
        return (idx >= 0) ? entries[idx].value : null;
    }

    public V put(K key, V value) {
        if (containsKey(key)) {
            throw new IllegalArgumentException("Chave duplicada: " + key);
        }
        ensureCapacity();
        entries[size++] = new Entry<>(key, value);
        return null; 
    }

    public V remove(K key) {
        int idx = indexOfKey(key);
        if (idx >= 0) {
            V oldValue = entries[idx].value;
            entries[idx] = entries[size - 1];
            entries[size - 1] = null;
            size--;
            return oldValue;
        }
        return null;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = entries[i].key;
            if ((currentKey == null && key == null)
             || (currentKey != null && currentKey.equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
