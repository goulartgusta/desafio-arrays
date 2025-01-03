package br.com.almaviva.desafio.array.etapa4;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MyListTeste {

    private MyList<String> list;

    @BeforeEach
    void setup() {
        list = new MyList<>();
    }

    @Test
    void deveriaEstarVaziaAoIniciar() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void deveriaAdicionarERecuperarElementos() {
        list.add("A");
        list.add("B");
        list.add("A"); 
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("A", list.get(2));
    }

    @Test
    void deveriaPermitirAdicionarNulo() {
        list.add(null);
        assertEquals(1, list.size());
        assertNull(list.get(0));
        assertTrue(list.contains(null));
    }

    @Test
    void deveriaAtualizarElementoComSet() {
        list.add("X");
        list.add("Y");
        assertEquals("X", list.set(0, "Z"));
        assertEquals("Z", list.get(0));
    }

    @Test
    void deveriaLancarExcecaoParaSetComIndiceInvalido() {
        list.add("OnlyOne");
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, "Fail"));
    }

    @Test
    void deveriaRemoverElementoPorIndice() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertFalse(list.contains("B"));
    }

    @Test
    void deveriaLancarExcecaoParaRemoverPorIndiceInvalido() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void deveriaRemoverElementoPorObjeto() {
        list.add("X");
        list.add("Y");
        assertTrue(list.remove("X"));
        assertFalse(list.remove("Z")); // não existe
        assertEquals(1, list.size());
    }

    @Test
    void deveriaVerificarSeContemElemento() {
        list.add("test");
        assertTrue(list.contains("test"));
        assertFalse(list.contains("other"));
        list.add(null);
        assertTrue(list.contains(null));
    }

    @Test
    void deveriaLimparLista() {
        list.add("A");
        list.add("B");
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void deveriaLancarExcecaoParaGetComIndiceInvalido() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add("Value");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }
}
