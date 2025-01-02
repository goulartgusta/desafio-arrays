package br.com.almaviva.desafio.array.etapa4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class MyMap<K, V> {
	private Entry<K, V>[] entries;
	private int size;

	@SuppressWarnings("unchecked")
	public MyMap() {
		entries = new Entry[10];
		size = 0;
	}

	static class Entry<K, V> {
		K key;
		V value;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private void aumentarTamanho() {
		Entry<K, V>[] newEntries = new Entry[entries.length * 2];
		for (int i = 0; i < size; i++) {
			newEntries[i] = entries[i];
		}
		entries = newEntries;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(K key) {
		for (int i = 0; i < size; i++) {
			if ((key == null && entries[i].key == null) || (key != null && key.equals(entries[i].key))) {
				return true;
			}
		}
		return false;
	}

	public boolean containsValue(V value) {
		for (int i = 0; i < size; i++) {
			if ((value == null && entries[i].value == null) || (value != null && value.equals(entries[i].value))) {
				return true;
			}
		}
		return false;
	}

	public V get(K key) {
		for (int i = 0; i < size; i++) {
			if ((key == null && entries[i].key == null) || (key != null && key.equals(entries[i].key))) {
				return entries[i].value;
			}
		}
		return null;
	}

	public V put(K key, V value) {
		for (int i = 0; i < size; i++) {
			if ((key == null && entries[i].key == null) || (key != null && key.equals(entries[i].key))) {
				V oldValue = entries[i].value;
				entries[i].value = value;
				return oldValue;
			}
		}
		if (size == entries.length) {
			aumentarTamanho();
		}
		entries[size++] = new Entry<>(key, value);
		return null;
	}

	public V remove(K key) {
		for (int i = 0; i < size; i++) {
			if ((key == null && entries[i].key == null) || (key != null && key.equals(entries[i].key))) {
				V value = entries[i].value;
				for (int j = i; j < size - 1; j++) {
					entries[j] = entries[j + 1];
				}
				entries[--size] = null;
				return value;
			}
		}
		return null;
	}

	public V replace(K key, V value) {
		for (int i = 0; i < size; i++) {
			if ((key == null && entries[i].key == null) || (key != null && key.equals(entries[i].key))) {
				V oldValue = entries[i].value;
				entries[i].value = value;
				return oldValue;
			}
		}
		return null;
	}

	public boolean replace(K key, V oldValue, V newValue) {
		for (int i = 0; i < size; i++) {
			if ((key == null && entries[i].key == null) || (key != null && key.equals(entries[i].key))) {
				if ((oldValue == null && entries[i].value == null)
						|| (oldValue != null && oldValue.equals(entries[i].value))) {
					entries[i].value = newValue;
					return true;
				}
			}
		}
		return false;
	}

	public void putAll(MyMap<K, V> m) {
		for (int i = 0; i < m.size; i++) {
			put(m.entries[i].key, m.entries[i].value);
		}
	}

	public void clear() {
		entries = new Entry[10];
		size = 0;
	}

	public List<K> keySet() {
		List<K> keys = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			keys.add(entries[i].key);
		}
		return keys;
	}

	public List<V> values() {
		List<V> v 	

	public List<Entry<K, V>> entrySet() {
		List<Entry<K, V>> entryList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			entryList.add(entries[i]);
		}
		return entryList;
	}

	public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
		for (int i = 0; i < size; i++) {
			entries[i].value = function.apply(entries[i].key, entries[i].value);
		}
	}

}
