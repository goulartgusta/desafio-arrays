package br.com.almaviva.desafio.array.etapa4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyMapTeste {

    @Test
    public void deveriaAdicionarERecuperarValoresCorretamente() {
        MyMap<String, Integer> map = new MyMap<>();
        assertNull(map.put("Key1", 1));
        assertEquals(1, map.get("Key1"));
        assertNull(map.get("Key2"));
    }

    @Test
    public void deveriaSobrescreverValorExistente() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Key1", 1);
        assertEquals(1, map.put("Key1", 2));
        assertEquals(2, map.get("Key1"));
    }

    @Test
    public void deveriaRemoverValorExistente() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertEquals(1, map.remove("Key1"));
        assertNull(map.get("Key1"));
        assertEquals(1, map.size());
    }

    @Test
    public void deveriaRetornarTamanhoEVerificarSeEstaVazio() {
        MyMap<String, Integer> map = new MyMap<>();
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        map.put("Key1", 1);
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
    }

    @Test
    public void deveriaVerificarSeContemChaveOuValor() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertTrue(map.containsKey("Key1"));
        assertFalse(map.containsKey("Key3"));
        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(3));
    }

    @Test
    public void deveriaExpandirCapacidade() {
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
