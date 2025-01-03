package br.com.almaviva.desafio.array.etapa4;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyListTeste {

	private MyList<String> lista;
=======
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
>>>>>>> minha-nova-branch

	@BeforeEach
	void setUp() {
		lista = new MyList<>();
		lista.add("Elemento1");
		lista.add("Elemento2");
		lista.add("Elemento3");
	}

<<<<<<< HEAD
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
	void deveriaObterElementoPorIndice() {
		assertEquals("Elemento2", lista.get(1));
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
=======
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
>>>>>>> minha-nova-branch
}
