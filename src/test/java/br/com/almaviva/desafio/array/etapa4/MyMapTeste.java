package br.com.almaviva.desafio.array.etapa4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyMapTeste {

    @Test
    public void deveriaRetornarTamanhoCorreto() {
        MyMap<String, Integer> map = new MyMap<>();
        assertEquals(0, map.size());
        map.put("Key1", 1);
        assertEquals(1, map.size());
    }

    @Test
    public void deveriaRetornarSeEstaVazio() {
        MyMap<String, Integer> map = new MyMap<>();
        assertTrue(map.isEmpty());
        map.put("Key1", 1);
        assertFalse(map.isEmpty());
    }

    @Test
    public void deveriaAdicionarERecuperarValor() {
        MyMap<String, Integer> map = new MyMap<>();
        assertNull(map.put("Key1", 1));
        assertEquals(1, map.get("Key1"));
    }

    @Test
    public void deveriaSobrescreverValorExistente() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Key1", 1);
        assertEquals(1, map.put("Key1", 2));
        assertEquals(2, map.get("Key1"));
    }

    @Test
    public void deveriaRemoverValor() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertEquals(1, map.remove("Key1"));
        assertNull(map.get("Key1"));
        assertEquals(1, map.size());
    }

    @Test
    public void deveriaRetornarNullParaRemocaoInexistente() {
        MyMap<String, Integer> map = new MyMap<>();
        assertNull(map.remove("Key1"));
    }

    @Test
    public void deveriaVerificarSeContemChave() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Key1", 1);
        assertTrue(map.containsKey("Key1"));
        assertFalse(map.containsKey("Key2"));
    }

    @Test
    public void deveriaVerificarSeContemValor() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Key1", 1);
        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(2));
    }

    @Test
    public void deveriaRetornarChaves() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Key1", 1);
        map.put("Key2", 2);
        Object[] keys = map.keys();
        assertArrayEquals(new Object[]{"Key1", "Key2"}, keys);
    }

    @Test
    public void deveriaRetornarValores() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Key1", 1);
        map.put("Key2", 2);
        Object[] values = map.values();
        assertArrayEquals(new Object[]{1, 2}, values);
    }

    @Test
    public void deveriaExpandirArrayAutomaticamente() {
        MyMap<Integer, String> map = new MyMap<>();
        for (int i = 0; i < 15; i++) {
            map.put(i, "Value" + i);
        }
        assertEquals(15, map.size());
        for (int i = 0; i < 15; i++) {
            assertEquals("Value" + i, map.get(i));
        }
    }

    @Test
    public void deveriaRetornarStringCorreta() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertEquals("{Key1=1, Key2=2}", map.toString());
    }
}
