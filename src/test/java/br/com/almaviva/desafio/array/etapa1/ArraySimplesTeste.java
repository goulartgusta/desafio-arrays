package br.com.almaviva.desafio.array.etapa1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArraySimplesTeste {

	private char[] letras;
	private int[] numeros;
	private int[][] matriz;

	@BeforeEach
	void setUp() {
		letras = new char[] { 'A', 'B', 'C' };
		numeros = new int[] { 10, 20, 30, 40 };
		matriz = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	}

	@Test
	void testArrayDeLetras() {
		assertEquals(3, letras.length);

		assertArrayEquals(new char[] { 'A', 'B', 'C' }, letras);
	}

	@Test
	void testArrayDeNumeros() {
		assertEquals(4, numeros.length);

		assertEquals(10, numeros[0]);
		assertEquals(40, numeros[3]);
	}

	@Test
	void testArrayBidimensional() {
		assertEquals(3, matriz.length);
		assertEquals(3, matriz[0].length);

		assertEquals(1, matriz[0][0]);
		assertEquals(9, matriz[2][2]);
	}

	@Test
	void testAlteracaoDeValores() {
		letras[0] = 'Z';
		numeros[3] = 99;

		assertEquals('Z', letras[0]);
		assertEquals(99, numeros[3]);
	}

	@Test
	void testIndiceInvalido() {
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			int valor = numeros[10];
		});

		assertTrue(exception.getMessage().contains("Index 10"));
	}

	@Test
	void testArrayComValoresPadrao() {
		int[] arrayVazio = new int[5];

		assertEquals(5, arrayVazio.length);

		for (int valor : arrayVazio) {
			assertEquals(0, valor);
		}
	}
}
