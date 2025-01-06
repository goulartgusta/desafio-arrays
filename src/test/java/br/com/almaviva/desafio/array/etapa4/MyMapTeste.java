package br.com.almaviva.desafio.array.etapa4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyMapTeste {

    private MyMap<String, String> map;

    @BeforeEach
    void setup() {
        map = new MyMap<>();
    }

    @Test
    void deveriaIniciarVazio() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    void deveriaAdicionarParesChaveValor() {
        map.put("k1", "v1");
        map.put("k2", "v2");
        assertEquals(2, map.size());
        assertEquals("v1", map.get("k1"));
        assertEquals("v2", map.get("k2"));
    }

    @Test
    void deveriaSubstituirValorParaMesmaChave() {
        map.put("k1", "v1");
        map.put("k1", "v2");
        assertEquals("v2", map.get("k1"));
    }

    @Test
    void deveriaRemoverChave() {
        map.put("k1", "v1");
        assertEquals("v1", map.remove("k1"));
        assertFalse(map.containsKey("k1"));
        assertEquals(0, map.size());
    }

    @Test
    void deveriaConterChaveEValor() {
        map.put("k1", "v1");
        map.put("k2", null);
        assertTrue(map.containsKey("k1"));
        assertTrue(map.containsValue("v1"));
        assertTrue(map.containsValue(null));
    }

    @Test
    void deveriaLimparMapa() {
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.clear();
        assertTrue(map.isEmpty());
    }

    @Test
    void deveriaAceitarChaveNula() {
        map.put(null, "valorNulo");
        assertEquals("valorNulo", map.get(null));
    }
}
