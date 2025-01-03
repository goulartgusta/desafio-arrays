package br.com.almaviva.desafio.array.etapa4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySetTeste {

    private MySet<String> conjunto;

    @BeforeEach
    void setUp() {
        conjunto = new MySet<>();
        conjunto.add("Elemento1");
        conjunto.add("Elemento2");
        conjunto.add("Elemento3");
    }

    @Test
    void deveriaRetornarTamanhoCorreto() {
        assertEquals(3, conjunto.size());
    }

    @Test
    void deveriaRetornarVerdadeiroSeConjuntoEstaVazio() {
        conjunto.clear();
        assertTrue(conjunto.isEmpty());
    }

    @Test
    void deveriaRetornarFalsoSeConjuntoNaoEstaVazio() {
        assertFalse(conjunto.isEmpty());
    }

    @Test
    void deveriaConterElementoExistente() {
        assertTrue(conjunto.contains("Elemento1"));
    }

    @Test
    void naoDeveriaConterElementoInexistente() {
        assertFalse(conjunto.contains("ElementoInexistente"));
    }

    @Test
    void deveriaAdicionarElementoUnico() {
        assertTrue(conjunto.add("Elemento4"));
        assertEquals(4, conjunto.size());
        assertTrue(conjunto.contains("Elemento4"));
    }

    @Test
    void naoDeveriaAdicionarElementoDuplicado() {
        assertFalse(conjunto.add("Elemento1"));
        assertEquals(3, conjunto.size());
    }

    @Test
    void deveriaRemoverElementoExistente() {
        assertTrue(conjunto.remove("Elemento2"));
        assertFalse(conjunto.contains("Elemento2"));
        assertEquals(2, conjunto.size());
    }

    @Test
    void naoDeveriaRemoverElementoInexistente() {
        assertFalse(conjunto.remove("ElementoInexistente"));
        assertEquals(3, conjunto.size());
    }

    @Test
    void deveriaLimparConjunto() {
        conjunto.clear();
        assertEquals(0, conjunto.size());
        assertTrue(conjunto.isEmpty());
    }

    @Test
    void deveriaConverterParaLista() {
        List<String> lista = conjunto.toList();
        assertEquals(3, lista.size());
        assertTrue(lista.contains("Elemento1"));
        assertTrue(lista.contains("Elemento2"));
        assertTrue(lista.contains("Elemento3"));
    }

    @Test
    void deveriaAumentarTamanhoQuandoCapacidadeAtingida() {
        for (int i = 4; i <= 10; i++) {
            conjunto.add("Elemento" + i);
        }
        assertEquals(10, conjunto.size());

        conjunto.add("Elemento11");
        assertEquals(11, conjunto.size());
        assertTrue(conjunto.contains("Elemento11"));
    }
}
