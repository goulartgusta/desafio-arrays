package br.com.almaviva.desafio.array.etapa4;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MyMap<Chave, Valor> {

    private Object[] chaves;
    private Object[] valores;
    private int size;

    public MyMap() {
        chaves = new Object[10];
        valores = new Object[10];
        size = 0;
    }

    private void ampliarArray() {
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

    public boolean containsKey(Chave chave) {
        return indexOfKey(chave) >= 0;
    }

    public boolean containsValue(Valor valor) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(valores[i], valor)) {
                return true;
            }
        }
        return false;
    }

    public Valor get(Chave chave) {
        int index = indexOfKey(chave);
        return index >= 0 ? (Valor) valores[index] : null;
    }

    public Valor put(Chave chave, Valor valor) {
        int index = indexOfKey(chave);
        if (index >= 0) {
            Valor oldValue = (Valor) valores[index];
            valores[index] = valor;
            return oldValue;
        }
        if (size == chaves.length) {
            ampliarArray();
        }
        chaves[size] = chave;
        valores[size] = valor;
        size++;
        return null;
    }

    public void putAll(MyMap<? extends Chave, ? extends Valor> other) {
        for (int i = 0; i < other.size(); i++) {
            this.put((Chave) other.chaves[i], (Valor) other.valores[i]);
        }
    }

    public Valor putIfAbsent(Chave chave, Valor valor) {
        int index = indexOfKey(chave);
        if (index >= 0) {
            return (Valor) valores[index];
        }
        put(chave, valor);
        return null;
    }

    public Valor remove(Chave chave) {
        int index = indexOfKey(chave);
        if (index >= 0) {
            Valor oldValue = (Valor) valores[index];
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

    public boolean remove(Chave chave, Valor valor) {
        int index = indexOfKey(chave);
        if (index >= 0 && Objects.equals(valores[index], valor)) {
            remove(chave);
            return true;
        }
        return false;
    }

    public Valor replace(Chave chave, Valor valor) {
        int index = indexOfKey(chave);
        if (index >= 0) {
            Valor oldValue = (Valor) valores[index];
            valores[index] = valor;
            return oldValue;
        }
        return null;
    }

    public boolean replace(Chave chave, Valor oldValue, Valor newValue) {
        int index = indexOfKey(chave);
        if (index >= 0 && Objects.equals(valores[index], oldValue)) {
            valores[index] = newValue;
            return true;
        }
        return false;
    }

    public void replaceAll(BiFunction<? super Chave, ? super Valor, ? extends Valor> function) {
        for (int i = 0; i < size; i++) {
            valores[i] = function.apply((Chave) chaves[i], (Valor) valores[i]);
        }
    }

    public void forEach(BiConsumer<? super Chave, ? super Valor> action) {
        for (int i = 0; i < size; i++) {
            action.accept((Chave) chaves[i], (Valor) valores[i]);
        }
    }

    public Valor compute(Chave chave, BiFunction<? super Chave, ? super Valor, ? extends Valor> remappingFunction) {
        int index = indexOfKey(chave);
        Valor newValue = remappingFunction.apply(chave, index >= 0 ? (Valor) valores[index] : null);
        if (newValue == null) {
            if (index >= 0) {
                remove(chave);
            }
        } else {
            if (index >= 0) {
                valores[index] = newValue;
            } else {
                put(chave, newValue);
            }
        }
        return newValue;
    }

    public Valor computeIfAbsent(Chave chave, Function<? super Chave, ? extends Valor> mappingFunction) {
        int index = indexOfKey(chave);
        if (index < 0) {
            Valor newValue = mappingFunction.apply(chave);
            if (newValue != null) {
                put(chave, newValue);
            }
            return newValue;
        }
        return (Valor) valores[index];
    }

    public Valor computeIfPresent(Chave chave, BiFunction<? super Chave, ? super Valor, ? extends Valor> remappingFunction) {
        int index = indexOfKey(chave);
        if (index >= 0) {
            Valor newValue = remappingFunction.apply(chave, (Valor) valores[index]);
            if (newValue == null) {
                remove(chave);
            } else {
                valores[index] = newValue;
            }
            return newValue;
        }
        return null;
    }

    public Valor merge(Chave chave, Valor valor, BiFunction<? super Valor, ? super Valor, ? extends Valor> remappingFunction) {
        int index = indexOfKey(chave);
        if (index >= 0) {
            Valor newValue = remappingFunction.apply((Valor) valores[index], valor);
            if (newValue == null) {
                remove(chave);
            } else {
                valores[index] = newValue;
            }
            return newValue;
        } else {
            put(chave, valor);
            return valor;
        }
    }

    public Object[] keys() {
        Object[] result = new Object[size];
        System.arraycopy(chaves, 0, result, 0, size);
        return result;
    }

    public Object[] values() {
        Object[] result = new Object[size];
        System.arraycopy(valores, 0, result, 0, size);
        return result;
    }

    private int indexOfKey(Chave chave) {
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
