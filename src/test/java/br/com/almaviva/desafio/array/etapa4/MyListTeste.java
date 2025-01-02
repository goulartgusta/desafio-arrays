package br.com.almaviva.desafio.array.etapa4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MyListTeste {

    private MyList<String> lista;

    @BeforeEach
    void setUp() {
        lista = new MyList<>();
        lista.add("Elemento1");
        lista.add("Elemento2");
        lista.add("Elemento3");
    }

    @Test
    void deveriaRetornarTamanhoCorreto() {
        assertEquals(3, lista.size());
    }

    @Test
    void deveriaRetornarVerdadeiroSeListaEstaVazia() {
        lista.clear();
        assertTrue(lista.isEmpty());
    }

    @Test
    void deveriaRetornarFalsoSeListaNaoEstaVazia() {
        assertFalse(lista.isEmpty());
    }

    @Test
    void deveriaConterElementoExistente() {
        assertTrue(lista.contains("Elemento1"));
    }

    @Test
    void naoDeveriaConterElementoInexistente() {
        assertFalse(lista.contains("ElementoInexistente"));
    }

    @Test
    void deveriaConverterParaArray() {
        Object[] array = lista.toArray();
        assertEquals(3, array.length);
        assertEquals("Elemento1", array[0]);
    }

    @Test
    void deveriaAdicionarElemento() {
        lista.add("Elemento4");
        assertEquals(4, lista.size());
        assertEquals("Elemento4", lista.get(3));
    }

    @Test
    void deveriaLimparLista() {
        lista.clear();
        assertEquals(0, lista.size());
    }

    @Test
    void deveriaAumentarCapacidade() {
        for (int i = 0; i < 15; i++) {
            lista.add("Elemento" + (i + 4));
        }
        assertTrue(lista.size() > 10);
    }

    @Test
    void deveriaObterElementoPorIndice() {
        assertEquals("Elemento2", lista.get(1));
    }

    @Test
    void deveriaLancarExcecaoParaIndiceInvalidoAoObter() {
        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(10));
    }

    @Test
    void deveriaSubstituirElementoPorIndice() {
        lista.set(1, "NovoElemento");
        assertEquals("NovoElemento", lista.get(1));
    }

    @Test
    void deveriaLancarExcecaoParaIndiceInvalidoAoSubstituir() {
        assertThrows(IndexOutOfBoundsException.class, () -> lista.set(10, "NovoElemento"));
    }

    @Test
    void deveriaRemoverElementoPorObjeto() {
        assertTrue(lista.remove("Elemento2"));
        assertFalse(lista.contains("Elemento2"));
        assertEquals(2, lista.size());
    }

    @Test
    void naoDeveriaRemoverElementoInexistente() {
        assertFalse(lista.remove("ElementoInexistente"));
    }

    @Test
    void deveriaRemoverElementoPorIndice() {
        String removido = lista.removeAt(1);
        assertEquals("Elemento2", removido);
        assertEquals(2, lista.size());
    }

    @Test
    void deveriaLancarExcecaoParaIndiceInvalidoAoRemoverPorIndice() {
        assertThrows(IndexOutOfBoundsException.class, () -> lista.removeAt(10));
    }

    @Test
    void deveriaRetornarIndiceDeElementoExistente() {
        assertEquals(1, lista.indexOf("Elemento2"));
    }

    @Test
    void deveriaRetornarMenosUmParaElementoInexistenteNoIndice() {
        assertEquals(-1, lista.indexOf("ElementoInexistente"));
    }

    @Test
    void deveriaRetornarUltimoIndiceDeElementoExistente() {
        lista.add("Elemento2");
        assertEquals(3, lista.lastIndexOf("Elemento2"));
    }

    @Test
    void deveriaRetornarMenosUmParaUltimoIndiceDeElementoInexistente() {
        assertEquals(-1, lista.lastIndexOf("ElementoInexistente"));
    }

    @Test
    void deveriaSubstituirTodosElementos() {
        lista.replaceAll(e -> e + "_Atualizado");
        assertEquals("Elemento1_Atualizado", lista.get(0));
        assertEquals("Elemento2_Atualizado", lista.get(1));
    }

    @Test
    void deveriaOrdenarElementos() {
        lista.add("Elemento0");
        lista.sort(Comparator.naturalOrder());
        assertEquals("Elemento0", lista.get(0));
        assertEquals("Elemento1", lista.get(1));
    }
}
