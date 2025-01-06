package br.com.almaviva.desafio.array.etapa2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Bicicleta;
import br.com.almaviva.desafio.array.etapa2.models.Model;
import br.com.almaviva.desafio.array.exceptions.ModelCastException;

class ArrayBicicletaTeste {

	private ArrayBicicleta arrayBike;

	@BeforeEach
	void setUp() {
		arrayBike = new ArrayBicicleta(3);
	}

	@Test
	void deveriaInserirBicicletaComSucesso() {
		Bicicleta bike = new Bicicleta();
		bike.setId(1);
		bike.setMarca("Caloi");
		bike.setCor("Vermelha");
		bike.setTamanhoQuadro(17);

		arrayBike.inserir(bike);

		assertEquals(bike, arrayBike.pesquisar(bike));
	}

	@Test
	void deveriaLancarExcecaoAoInserirModelNaoBicicleta() {
		Model modelNaoBicicleta = new Model();
		modelNaoBicicleta.setId(10);

		assertThrows(ModelCastException.class, () -> arrayBike.inserir(modelNaoBicicleta));
	}

	@Test
	void deveriaRemoverBicicletaComSucesso() {
		Bicicleta bike = new Bicicleta();
		bike.setId(1);
		bike.setMarca("Caloi");
		bike.setCor("Azul");

		arrayBike.inserir(bike);
		arrayBike.remover(bike);

		assertNull(arrayBike.pesquisar(bike));
	}

	@Test
	void deveriaLancarExcecaoAoRemoverModelNaoBicicleta() {
		Model modelNaoBicicleta = new Model();
		modelNaoBicicleta.setId(10);

		assertThrows(ModelCastException.class, () -> arrayBike.remover(modelNaoBicicleta));
	}
	
	@Test
	void deveriaLancarExcecaoAoPesquisarModelNaoBicicleta() {
	    Model modelNaoBicicleta = new Model();
	    modelNaoBicicleta.setId(10);

	    assertThrows(ModelCastException.class, () -> arrayBike.pesquisar(modelNaoBicicleta));
	}


	@Test
	void deveriaOrdenarPorIdCrescenteComSucesso() {
		Bicicleta bike1 = new Bicicleta();
		bike1.setId(3);
		bike1.setMarca("Caloi");
		Bicicleta bike2 = new Bicicleta();
		bike2.setId(1);
		bike2.setMarca("Monark");
		Bicicleta bike3 = new Bicicleta();
		bike3.setId(2);
		bike3.setMarca("Trek");

		arrayBike.inserir(bike1);
		arrayBike.inserir(bike2);
		arrayBike.inserir(bike3);

		arrayBike.ordenarPorIdCrescente(0);

		assertEquals(bike2, arrayBike.getItens()[0]);
		assertEquals(bike3, arrayBike.getItens()[1]);
		assertEquals(bike1, arrayBike.getItens()[2]);
	}

	@Test
	void deveriaOrdenarPorIdDecrescenteComSucesso() {
		Bicicleta bike1 = new Bicicleta();
		bike1.setId(3);
		Bicicleta bike2 = new Bicicleta();
		bike2.setId(1);
		Bicicleta bike3 = new Bicicleta();
		bike3.setId(2);

		arrayBike.inserir(bike1);
		arrayBike.inserir(bike2);
		arrayBike.inserir(bike3);

		arrayBike.ordenarPorIdDecrescente(0);

		assertEquals(bike1, arrayBike.getItens()[0]);
		assertEquals(bike3, arrayBike.getItens()[1]);
		assertEquals(bike2, arrayBike.getItens()[2]);
	}

	@Test
	void deveriaAtualizarBicicletaComSucesso() {
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setId(1);
		bicicleta.setMarca("Caloi");
		bicicleta.setCor("Vermelha");

		arrayBike.inserir(bicicleta); // Insere a bicicleta original

		Bicicleta bicicletaAtualizada = new Bicicleta();
		bicicletaAtualizada.setId(1); // Mesmo ID
		bicicletaAtualizada.setMarca("Monark");
		bicicletaAtualizada.setCor("Azul");

		arrayBike.atualizar(bicicletaAtualizada); // Atualiza a bicicleta

		Bicicleta resultado = (Bicicleta) arrayBike.pesquisar(bicicletaAtualizada);

		assertEquals("Monark", resultado.getMarca());
		assertEquals("Azul", resultado.getCor());
	}

	@Test
	void deveriaLancarExcecaoAoAtualizarModelNaoBicicleta() {
		Model modelNaoBicicleta = new Model();
		modelNaoBicicleta.setId(10);

		assertThrows(ModelCastException.class, () -> arrayBike.atualizar(modelNaoBicicleta));
	}
}
