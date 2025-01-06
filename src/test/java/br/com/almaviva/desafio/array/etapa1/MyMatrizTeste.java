package br.com.almaviva.desafio.array.etapa1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.exceptions.MatrizClassException;

class MyMatrizTeste {

    private MyMatriz matriz;

    @BeforeEach
    void setUp() {
        Character[] caracteres = { 'A', 'B', 'C', 'D', 'E' };
        Integer[] numeros = { 1, 2, 3, 4, 5 };
        matriz = new MyMatriz(caracteres, numeros);
    }

    @Test
    void deveriaInserirCaractereComSucesso() {
        matriz.inserirCaractere(3, 'Z');
        assertEquals('Z', matriz.buscarCaractere(3));
    }

    @Test
    void deveriaLancarExcecaoAoInserirCaractereInvalido() {
        assertThrows(MatrizClassException.class, () -> matriz.inserirCaractere(10, 'Z'));
        assertEquals('A', matriz.buscarCaractere(0));
        assertEquals('B', matriz.buscarCaractere(1));
    }

    @Test
    void deveriaInserirNumeroComSucesso() {
        matriz.inserirNumero(3, 10);
        assertEquals(10, matriz.buscarNumero(3));
    }

    @Test
    void deveriaLancarExcecaoAoInserirNumeroInvalido() {
        MatrizClassException exception = assertThrows(MatrizClassException.class, () -> matriz.inserirNumero(10, 20));
        assertEquals(1, matriz.buscarNumero(0));
        assertEquals(2, matriz.buscarNumero(1));
    }

    @Test
    void deveriaBuscarCaractereComSucesso() {
        assertEquals('A', matriz.buscarCaractere(0));
        assertEquals('B', matriz.buscarCaractere(1));
    }

    @Test
    void deveriaLancarExcecaoAoBuscarCaractereInvalido() {
        MatrizClassException exception = assertThrows(MatrizClassException.class, () -> matriz.buscarCaractere(10));
        assertEquals('C', matriz.buscarCaractere(2));
    }

    @Test
    void deveriaBuscarNumeroComSucesso() {
        assertEquals(1, matriz.buscarNumero(0));
        assertEquals(2, matriz.buscarNumero(1));
    }

    @Test
    void deveriaLancarExcecaoAoBuscarNumeroInvalido() {
        assertThrows(MatrizClassException.class, () -> matriz.buscarNumero(10));
        assertEquals(3, matriz.buscarNumero(2));
    }

    @Test
    void deveriaRemoverCaractereComSucesso() {
        matriz.removerCaractere(0);
        assertNull(matriz.buscarCaractere(0));
    }

    @Test
    void deveriaLancarExcecaoAoRemoverCaractereInvalido() {
        MatrizClassException exception = assertThrows(MatrizClassException.class, () -> matriz.removerCaractere(10));
        assertEquals('A', matriz.buscarCaractere(0));
    }

    @Test
    void deveriaRemoverNumeroComSucesso() {
        matriz.removerNumero(0);
        assertNull(matriz.buscarNumero(0));
    }

    @Test
    void deveriaLancarExcecaoAoRemoverNumeroInvalido() {
        assertThrows(MatrizClassException.class, () -> matriz.removerNumero(10));
        assertEquals(1, matriz.buscarNumero(0));
    }

    @Test
    void deveriaManterEstadoAposExcecoes() {
        assertThrows(MatrizClassException.class, () -> matriz.inserirCaractere(10, 'X'));
        assertEquals('A', matriz.buscarCaractere(0));
        assertEquals('B', matriz.buscarCaractere(1));
        assertThrows(MatrizClassException.class, () -> matriz.inserirNumero(10, 100));
        assertEquals(1, matriz.buscarNumero(0));
        assertEquals(2, matriz.buscarNumero(1));
    }
}
