package br.com.almaviva.desafio.array.etapa4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MySetTest {

    private MySet<String> conjunto;

    @BeforeEach
    void setUp() {
        conjunto = new MySet<>();
    }

    @Test
    void deveriaEstarVazioAoInicializar() {
        assertTrue(conjunto.isEmpty());
        assertEquals(0, conjunto.size());
    }

    @Test
    void deveriaAdicionarElementosUnicos() {
        assertTrue(conjunto.add("Elemento1"));
        assertTrue(conjunto.add("Elemento2"));
        assertEquals(2, conjunto.size());
        assertTrue(conjunto.contains("Elemento1"));
        assertTrue(conjunto.contains("Elemento2"));
    }

    @Test
    void naoDeveriaAdicionarElementosDuplicados() {
        assertTrue(conjunto.add("Elemento1"));
        assertFalse(conjunto.add("Elemento1"));
        assertEquals(1, conjunto.size());
    }

    @Test
    void deveriaAdicionarElementoNulo() {
        assertTrue(conjunto.add(null));
        assertFalse(conjunto.add(null));
        assertEquals(1, conjunto.size());
        assertTrue(conjunto.contains(null));
    }

    @Test
    void deveriaRemoverElemento() {
        conjunto.add("Elemento1");
        conjunto.add("Elemento2");
        assertTrue(conjunto.remove("Elemento2"));
        assertFalse(conjunto.contains("Elemento2"));
        assertFalse(conjunto.remove("Elemento2"));
        assertEquals(1, conjunto.size());
    }

    @Test
    void deveriaRemoverElementoNulo() {
        conjunto.add(null);
        conjunto.add("Elemento1");
        assertTrue(conjunto.remove(null));
        assertFalse(conjunto.contains(null));
        assertEquals(1, conjunto.size());
    }

    @Test
    void deveriaLimparTodosOsElementos() {
        conjunto.add("Elemento1");
        conjunto.add("Elemento2");
        conjunto.clear();
        assertTrue(conjunto.isEmpty());
        assertEquals(0, conjunto.size());
        assertFalse(conjunto.contains("Elemento1"));
    }

    @Test
    void deveriaConterElemento() {
        conjunto.add("Elemento1");
        assertTrue(conjunto.contains("Elemento1"));
        assertFalse(conjunto.contains("ElementoInexistente"));
    }
}
