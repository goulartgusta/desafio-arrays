package br.com.almaviva.desafio.array.etapa4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyListTest {

    private MyList<String> lista;

    @BeforeEach
    void setUp() {
        lista = new MyList<>();
    }

    @Test
    void deveriaEstarVaziaAoInicializar() {
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
    }

    @Test
    void deveriaAdicionarElementosComSucesso() {
        lista.add("Elemento1");
        lista.add("Elemento2");
        assertEquals(2, lista.size());
        assertEquals("Elemento1", lista.get(0));
        assertEquals("Elemento2", lista.get(1));
    }

    @Test
    void deveriaAdicionarElementoNulo() {
        lista.add(null);
        assertEquals(1, lista.size());
        assertNull(lista.get(0));
    }

    @Test
    void deveriaRemoverElementoPorIndice() {
        lista.add("Elemento1");
        lista.add("Elemento2");
        lista.add("Elemento3");

        assertEquals("Elemento2", lista.removeByIndex(1));
        assertEquals(2, lista.size());
        assertFalse(lista.contains("Elemento2"));
    }

    @Test
    void deveriaLancarExcecaoParaIndiceInvalidoAoRemover() {
        lista.add("Elemento1");
        assertThrows(IndexOutOfBoundsException.class, () -> lista.removeByIndex(1));
    }

    @Test
    void deveriaRemoverElementoPorObjeto() {
        lista.add("Elemento1");
        lista.add("Elemento2");
        assertTrue(lista.remove("Elemento1"));
        assertEquals(1, lista.size());
        assertFalse(lista.contains("Elemento1"));
    }

    @Test
    void naoDeveriaRemoverElementoInexistente() {
        lista.add("Elemento1");
        assertFalse(lista.remove("ElementoInexistente"));
    }

    @Test
    void deveriaAtualizarElementoComSucesso() {
        lista.add("Elemento1");
        lista.add("Elemento2");

        assertEquals("Elemento1", lista.set(0, "ElementoAtualizado"));
        assertEquals("ElementoAtualizado", lista.get(0));
    }

    @Test
    void deveriaLancarExcecaoParaIndiceInvalidoAoAtualizar() {
        lista.add("Elemento1");
        assertThrows(IndexOutOfBoundsException.class, () -> lista.set(1, "NovoElemento"));
    }

    @Test
    void deveriaLimparTodosOsElementos() {
        lista.add("Elemento1");
        lista.add("Elemento2");
        lista.clear();
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
    }

    @Test
    void deveriaLancarExcecaoParaIndiceInvalidoAoBuscar() {
        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(0));
    }

    @Test
    void deveriaConterElemento() {
        lista.add("Elemento1");
        assertTrue(lista.contains("Elemento1"));
        assertFalse(lista.contains("ElementoInexistente"));
    }
}
