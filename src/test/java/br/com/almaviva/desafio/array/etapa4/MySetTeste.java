package br.com.almaviva.desafio.array.etapa4;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MySetTeste {

    private MySet<String> set;

    @BeforeEach
    void setup() {
        set = new MySet<>();
    }

    @Test
    void deveriaEstarVazioAoIniciar() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    void deveriaAdicionarElementosUnicos() {
        assertTrue(set.add("A"));
        assertTrue(set.add("B"));
        assertEquals(2, set.size());
        assertTrue(set.contains("A"));
        assertTrue(set.contains("B"));
    }

    @Test
    void naoDeveriaPermitirElementosDuplicados() {
        assertTrue(set.add("X"));
        assertFalse(set.add("X"));
        assertEquals(1, set.size());
    }

    @Test
    void deveriaPermitirAdicionarNulo() {
        assertTrue(set.add(null));
        assertFalse(set.add(null));
        assertEquals(1, set.size());
        assertTrue(set.contains(null));
    }

    @Test
    void deveriaRemoverElemento() {
        set.add("A");
        set.add("B");
        assertTrue(set.remove("B"));
        assertFalse(set.contains("B"));
        assertFalse(set.remove("B"));
        assertEquals(1, set.size());
    }

    @Test
    void deveriaRemoverNulo() {
        set.add(null);
        set.add("X");
        assertTrue(set.remove(null));
        assertFalse(set.contains(null));
        assertEquals(1, set.size());
    }

    @Test
    void deveriaLimparConjunto() {
        set.add("A");
        set.add("B");
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        assertFalse(set.contains("A"));
    }
}
