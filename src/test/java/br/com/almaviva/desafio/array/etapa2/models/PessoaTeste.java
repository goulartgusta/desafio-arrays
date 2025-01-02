package br.com.almaviva.desafio.array.etapa2.models;

import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Pessoa;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTeste {

	@Test
	void deveriaRetornarValoresCorretosNosGetters() {
		Pessoa pessoa = new Pessoa(1, "João", 30, "123.456.789-00");

		assertEquals(1, pessoa.getId());
		assertEquals("João", pessoa.getNome());
		assertEquals(30, pessoa.getIdade());
		assertEquals("123.456.789-00", pessoa.getCpf());
	}

	@Test
	void deveriaAlterarValoresCorretamenteNosSetters() {
		Pessoa pessoa = new Pessoa(1, "João", 30, "123.456.789-00");

		pessoa.setNome("Maria");
		pessoa.setIdade(25);
		pessoa.setCpf("987.654.321-00");

		assertEquals("Maria", pessoa.getNome());
		assertEquals(25, pessoa.getIdade());
		assertEquals("987.654.321-00", pessoa.getCpf());
	}

	@Test
	void naoDeveriaRetornarValoresIncorretosNosGetters() {
		Pessoa pessoa = new Pessoa(1, "João", 30, "123.456.789-00");

		assertNotEquals(2, pessoa.getId());
		assertNotEquals("Maria", pessoa.getNome());
		assertNotEquals(25, pessoa.getIdade());
		assertNotEquals("987.654.321-00", pessoa.getCpf());
	}

	@Test
	void naoDeveriaAlterarParaValoresIncorretosNosSetters() {
		Pessoa pessoa = new Pessoa(1, "João", 30, "123.456.789-00");

		pessoa.setNome("João");
		pessoa.setIdade(30);
		pessoa.setCpf("123.456.789-00");

		assertEquals("João", pessoa.getNome());
		assertEquals(30, pessoa.getIdade());
		assertEquals("123.456.789-00", pessoa.getCpf());
	}

	@Test
	void naoDeveriaRetornarStringIncorretaNoToString() {
		Pessoa pessoa = new Pessoa(1, "João", 30, "123.456.789-00");

		String incorreto = "Pessoa{id=2, nome='Maria', idade=25, cpf='987.654.321-00'}";
		assertNotEquals(incorreto, pessoa.toString());
	}
}
