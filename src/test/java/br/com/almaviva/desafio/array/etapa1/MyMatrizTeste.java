package br.com.almaviva.desafio.array.etapa1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.exceptions.MatrizClassException;

class MyMatrizTeste {

    private MyMatriz matriz;

    @BeforeEach
    void setUp() {
        Character[] caracteres = {'A', 'B', 'C', 'D', 'E'};
        Integer[] numeros = {1, 2, 3, 4, 5};
        matriz = new MyMatriz(caracteres, numeros);
    }

    @Test
    void deveInserirCaractereComSucesso() {
        matriz.inserirCaractere(3, 'D');
        assertEquals('D', matriz.buscarCaractere(3));
    }

    @Test
    void deveLancarExcecaoAoInserirCaractereInvalido() {
        assertThrows(MatrizClassException.class, () -> matriz.inserirCaractere(3, 123));
    }

    @Test
    void deveInserirNumeroComSucesso() {
        matriz.inserirNumero(3, 10);
        assertEquals(10, matriz.buscarNumero(3));
    }

    @Test
    void deveLancarExcecaoAoInserirNumeroInvalido() {
        assertThrows(MatrizClassException.class, () -> matriz.inserirNumero(3, 'X'));
    }

    @Test
    void deveBuscarCaractereComSucesso() {
        assertEquals('A', matriz.buscarCaractere(0));
    }

    @Test
    void deveBuscarNumeroComSucesso() {
        assertEquals(1, matriz.buscarNumero(0));
    }

    @Test
    void deveRemoverCaractereComSucesso() {
        matriz.removerCaractere(0);
        assertNull(matriz.buscarCaractere(0));
    }

    @Test
    void deveRemoverNumeroComSucesso() {
        matriz.removerNumero(0);
        assertNull(matriz.buscarNumero(0));
    }
    
}
