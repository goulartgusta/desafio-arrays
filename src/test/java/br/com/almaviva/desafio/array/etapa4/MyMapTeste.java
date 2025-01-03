package br.com.almaviva.desafio.array.etapa4;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MyMapTeste {

    private MyMap<String, String> map;

    @BeforeEach
    void setup() {
        map = new MyMap<>();
    }

    @Test
    void deveriaEstarVazioAoIniciar() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    void deveriaAdicionarERecuperarElementos() {
        map.put("k1", "v1");
        map.put("k2", "v2");
        assertFalse(map.isEmpty());
        assertEquals("v1", map.get("k1"));
        assertEquals("v2", map.get("k2"));
        assertNull(map.get("inexistente"));
        assertEquals(2, map.size());
    }

    @Test
    void deveriaLancarExcecaoParaChaveDuplicada() {
        map.put("k1", "v1");
        assertThrows(IllegalArgumentException.class, () -> map.put("k1", "v2"));
    }

    @Test
    void deveriaRemoverElemento() {
        map.put("A", "Alpha");
        map.put("B", "Beta");
        assertEquals("Beta", map.remove("B"));
        assertNull(map.remove("B"));
        assertEquals(1, map.size());
        assertFalse(map.containsKey("B"));
    }

    @Test
    void deveriaVerificarSeContemChaveEValor() {
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
    void deveriaLimparMapa() {
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.clear();
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        assertFalse(map.containsKey("k1"));
    }

    @Test
    void deveriaPermitirChaveNula() {
        map.put(null, "valorNulo");
        assertEquals("valorNulo", map.get(null));
    }
}
