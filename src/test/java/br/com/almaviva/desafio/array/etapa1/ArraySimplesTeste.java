package br.com.almaviva.desafio.array.etapa1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArraySimplesTeste {
<<<<<<< HEAD
    private int[] arrayInteiros;
    private char[] arrayCaracteres;
    private double[] arrayDecimais;
    private int[][] matrizBidimensional;

    @BeforeEach
    void setUp() {
        arrayInteiros = new int[]{1, 2, 3, 4, 5};
        arrayCaracteres = new char[]{'a', 'b', 'c', 'd', 'e'};
        arrayDecimais = new double[]{1.1, 2.2, 3.3, 4.4, 5.5};
        matrizBidimensional = new int[][] {
            {1, 2, 3},
            {4, 5, 6}
        };
    }

    @Test
    void testeTamanhoArrayDeInteiros() {
        assertEquals(5, arrayInteiros.length);
    }

    @Test
    void testeAcessoEModificacaoArrayDeInteiros() {
        assertEquals(1, arrayInteiros[0]);
        arrayInteiros[0] = 10;
        assertEquals(10, arrayInteiros[0]);
    }

    @Test
    void testeIteracaoArrayDeInteiros() {
        int soma = 0;
        for (int n : arrayInteiros) soma += n;
        assertEquals(15, soma);
    }

    @Test
    void testeTamanhoArrayDeCaracteres() {
        assertEquals(5, arrayCaracteres.length);
    }

    @Test
    void testeAcessoEModificacaoArrayDeCaracteres() {
        assertEquals('a', arrayCaracteres[0]);
        arrayCaracteres[0] = 'z';
        assertEquals('z', arrayCaracteres[0]);
    }

    @Test
    void testeIteracaoArrayDeCaracteres() {
        StringBuilder sb = new StringBuilder();
        for (char c : arrayCaracteres) sb.append(c);
        assertEquals("abcde", sb.toString());
    }

    @Test
    void testeForaDoLimiteArrayDeCaracteres() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            char x = arrayCaracteres[5];
        });
    }

    @Test
    void testeTamanhoArrayDeDecimais() {
        assertEquals(5, arrayDecimais.length);
    }

    @Test
    void testeAcessoEModificacaoArrayDeDecimais() {
        assertEquals(1.1, arrayDecimais[0]);
        arrayDecimais[0] = 9.9;
        assertEquals(9.9, arrayDecimais[0]);
    }

    @Test
    void testeIteracaoArrayDeDecimais() {
        double soma = 0;
        for (double d : arrayDecimais) soma += d;
        assertEquals(16.5, soma);
    }

    @Test
    void testeForaDoLimiteArrayDeDecimais() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            double x = arrayDecimais[5];
        });
    }

    @Test
    void testeDimensoesMatrizBidimensional() {
        assertEquals(2, matrizBidimensional.length);
        assertEquals(3, matrizBidimensional[0].length);
    }

    @Test
    void testeAcessoEModificacaoMatrizBidimensional() {
        assertEquals(1, matrizBidimensional[0][0]);
        matrizBidimensional[0][0] = 99;
        assertEquals(99, matrizBidimensional[0][0]);
    }

    @Test
    void testeIteracaoMatrizBidimensional() {
        int soma = 0;
        for (int[] linha : matrizBidimensional) {
            for (int valor : linha) soma += valor;
        }
        assertEquals(21, soma);
    }

    @Test
    void testeForaDoLimiteMatrizBidimensional() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int x = matrizBidimensional[1][3];
        });
    }
=======
	private int[] arrayInteiros;
	private char[] arrayCaracteres;
	private double[] arrayDecimais;
	private int[][] matrizBidimensional;

	@BeforeEach
	void setUp() {
		arrayInteiros = new int[] { 1, 2, 3, 4, 5 };
		arrayCaracteres = new char[] { 'a', 'b', 'c', 'd', 'e' };
		arrayDecimais = new double[] { 1.1, 2.2, 3.3, 4.4, 5.5 };
		matrizBidimensional = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
	}

	@Test
	void testeTamanhoArrayDeInteiros() {
		assertEquals(5, arrayInteiros.length);
	}

	@Test
	void testeAcessoEModificacaoArrayDeInteiros() {
		assertEquals(1, arrayInteiros[0]);
		arrayInteiros[0] = 10;
		assertEquals(10, arrayInteiros[0]);
	}

	@Test
	void testeIteracaoArrayDeInteiros() {
		int soma = 0;
		for (int n : arrayInteiros)
			soma += n;
		assertEquals(15, soma);
	}

	@Test
	void testeTamanhoArrayDeCaracteres() {
		assertEquals(5, arrayCaracteres.length);
	}

	@Test
	void testeAcessoEModificacaoArrayDeCaracteres() {
		assertEquals('a', arrayCaracteres[0]);
		arrayCaracteres[0] = 'z';
		assertEquals('z', arrayCaracteres[0]);
	}

	@Test
	void testeIteracaoArrayDeCaracteres() {
		StringBuilder sb = new StringBuilder();
		for (char c : arrayCaracteres)
			sb.append(c);
		assertEquals("abcde", sb.toString());
	}

	@Test
	void testeTamanhoArrayDeDecimais() {
		assertEquals(5, arrayDecimais.length);
	}

	@Test
	void testeAcessoEModificacaoArrayDeDecimais() {
		assertEquals(1.1, arrayDecimais[0]);
		arrayDecimais[0] = 9.9;
		assertEquals(9.9, arrayDecimais[0]);
	}

	@Test
	void testeIteracaoArrayDeDecimais() {
		double soma = 0;
		for (double d : arrayDecimais)
			soma += d;
		assertEquals(16.5, soma);
	}

	@Test
	void testeForaDoLimiteArrayDeDecimais() {

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			double x = arrayDecimais[5];
		});
	}
	

	@Test
	void testeDimensoesMatrizBidimensional() {
		assertEquals(2, matrizBidimensional.length);
		assertEquals(3, matrizBidimensional[0].length);
	}

	@Test
	void testeAcessoEModificacaoMatrizBidimensional() {
		assertEquals(1, matrizBidimensional[0][0]);
		matrizBidimensional[0][0] = 99;
		assertEquals(99, matrizBidimensional[0][0]);
	}

	@Test
	void testeIteracaoMatrizBidimensional() {
		int soma = 0;
		for (int[] linha : matrizBidimensional) {
			for (int valor : linha)
				soma += valor;
		}
		assertEquals(21, soma);
	}

	@Test
	void testeForaDoLimiteMatrizBidimensional() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			int x = matrizBidimensional[1][3];
		});
	}
>>>>>>> minha-nova-branch
}
