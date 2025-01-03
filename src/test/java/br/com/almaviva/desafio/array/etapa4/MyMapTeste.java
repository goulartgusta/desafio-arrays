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
<<<<<<< HEAD
    void deveriaRetornarValorPorChave() {
        assertEquals("value1", mapa.get("key1"));
    }

    @Test
    void deveriaRetornarNuloParaChaveInexistente() {
        assertNull(mapa.get("nonExistentKey"));
    }

    @Test
    void deveriaAdicionarElementoComPut() {
        mapa.put("key4", "value4");
        assertEquals("value4", mapa.get("key4"));
    }

    @Test
    void naoDeveriaRemoverElementoInexistente() {
        assertNull(mapa.remove("nonExistentKey"));
    }

    @Test
    void deveriaSubstituirValorCondicionalmenteComReplace() {
        assertTrue(mapa.replace("key1", "value1", "newValue1"));
        assertEquals("newValue1", mapa.get("key1"));
    }

    @Test
    void naoDeveriaSubstituirValorSeCondicaoFalhar() {
        assertFalse(mapa.replace("key1", "wrongValue", "newValue1"));
    }

    @Test
    void deveriaRetornarTodasAsChaves() {
        List<String> keys = mapa.keySet();
        assertEquals(3, keys.size());
        assertTrue(keys.contains("key1"));
        assertTrue(keys.contains("key2"));
        assertTrue(keys.contains("key3"));
    }

    @Test
    void deveriaRetornarTodasAsEntradas() {
        List<MyMap.Entry<String, String>> entries = mapa.entrySet();
        assertEquals(3, entries.size());
    }

    @Test
    void deveriaSubstituirTodosOsValoresComReplaceAll() {
        mapa.replaceAll((key, value) -> value + "_updated");
        assertEquals("value1_updated", mapa.get("key1"));
        assertEquals("value2_updated", mapa.get("key2"));
    }

    @Test
    void deveriaAdicionarTodosOsElementosDeOutroMapaComPutAll() {
        MyMap<String, String> outroMapa = new MyMap<>();
        outroMapa.put("key4", "value4");
        outroMapa.put("key5", "value5");

        mapa.putAll(outroMapa);

        assertEquals(5, mapa.size());
        assertEquals("value4", mapa.get("key4"));
        assertEquals("value5", mapa.get("key5"));
    }

=======
    void deveriaPermitirChaveNula() {
        map.put(null, "valorNulo");
        assertEquals("valorNulo", map.get(null));
    }
>>>>>>> minha-nova-branch
}
