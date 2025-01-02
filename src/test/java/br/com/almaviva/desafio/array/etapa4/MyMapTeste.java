package br.com.almaviva.desafio.array.etapa4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTeste {

    private MyMap<String, String> mapa;

    @BeforeEach
    void setUp() {
        mapa = new MyMap<>();
        mapa.put("key1", "value1");
        mapa.put("key2", "value2");
        mapa.put("key3", "value3");
    }


    @Test
    void deveriaRetornarTamanhoCorreto() {
        assertEquals(3, mapa.size());
    }

    @Test
    void deveriaRetornarVerdadeiroSeMapaEstaVazio() {
        mapa.clear();
        assertTrue(mapa.isEmpty());
    }

    @Test
    void deveriaRetornarFalsoSeMapaNaoEstaVazio() {
        assertFalse(mapa.isEmpty());
    }

    @Test
    void deveriaConterChaveExistente() {
        assertTrue(mapa.containsKey("key1"));
    }

    @Test
    void naoDeveriaConterChaveInexistente() {
        assertFalse(mapa.containsKey("nonExistentKey"));
    }

    @Test
    void deveriaConterValorExistente() {
        assertTrue(mapa.containsValue("value1"));
    }

    @Test
    void naoDeveriaConterValorInexistente() {
        assertFalse(mapa.containsValue("nonExistentValue"));
    }

    @Test
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
    void deveriaAtualizarValorComPut() {
        mapa.put("key1", "newValue1");
        assertEquals("newValue1", mapa.get("key1"));
    }

    @Test
    void deveriaRemoverElementoExistente() {
        mapa.remove("key2");
        assertFalse(mapa.containsKey("key2"));
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
        assertTrue(entries.stream().anyMatch(entry -> entry.key.equals("key1") && entry.value.equals("value1")));
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

    @Test
    void deveriaAumentarCapacidadeQuandoNecessario() {
        for (int i = 1; i <= 15; i++) {
            mapa.put("key" + i, "value" + i);
        }
        assertEquals(15, mapa.size());
        assertEquals("value15", mapa.get("key15"));
    }
}
