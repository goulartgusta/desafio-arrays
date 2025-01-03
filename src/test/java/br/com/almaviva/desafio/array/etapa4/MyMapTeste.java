package br.com.almaviva.desafio.array.etapa4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMapTest {

    private MyMap<String, String> map;

    @BeforeEach
    void setup() {
        map = new MyMap<>();
    }

    @Test
    void testInitialState() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    void testPutAndGet() {
        map.put("k1", "v1");
        map.put("k2", "v2");
        assertFalse(map.isEmpty());
        assertEquals("v1", map.get("k1"));
        assertEquals("v2", map.get("k2"));
        assertNull(map.get("inexistente"));
        assertEquals(2, map.size());
    }

    @Test
    void testPutChaveDuplicada() {
        map.put("k1", "v1");
        assertThrows(IllegalArgumentException.class, () -> map.put("k1", "v2"));
    }

    @Test
    void testRemove() {
        map.put("A", "Alpha");
        map.put("B", "Beta");
        assertEquals("Beta", map.remove("B"));
        assertNull(map.remove("B")); // já removido
        assertEquals(1, map.size());
        assertFalse(map.containsKey("B"));
    }

    @Test
    void testContainsKeyAndValue() {
        map.put("X", "xVal");
        map.put("Y", null);
        assertTrue(map.containsKey("X"));
        assertFalse(map.containsKey("Z"));
        assertTrue(map.containsValue("xVal"));
        assertFalse(map.containsValue("xyz"));
        assertTrue(map.containsKey("Y"));
        assertTrue(map.containsValue(null));
    }

    @Test
    void testClear() {
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.clear();
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        assertFalse(map.containsKey("k1"));
    }

    @Test
    void testPutChaveNula() {
        map.put(null, "valorNulo");
        assertEquals("valorNulo", map.get(null));
    }
}
