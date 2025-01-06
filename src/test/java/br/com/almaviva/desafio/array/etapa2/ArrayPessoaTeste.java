package br.com.almaviva.desafio.array.etapa2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Pessoa;
import br.com.almaviva.desafio.array.etapa2.models.Model;
import br.com.almaviva.desafio.array.exceptions.ModelCastException;

class ArrayPessoaTeste {

	private ArrayPessoa arrayPessoa;

	@BeforeEach
	void setUp() {
		arrayPessoa = new ArrayPessoa(3);
	}

	@Test
	void deveriaInserirPessoaComSucesso() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
		pessoa.setNome("João");
		pessoa.setCpf("123.456.789-00");
		pessoa.setSobrenome("Silva");
		pessoa.setEndereco("Rua A, 123");

		arrayPessoa.inserir(pessoa);

		assertEquals(pessoa, arrayPessoa.pesquisar(pessoa));
	}

	@Test
	void deveriaLancarExcecaoAoInserirModelNaoPessoa() {
		Model modelNaoPessoa = new Model();
		modelNaoPessoa.setId(10);

		assertThrows(ModelCastException.class, () -> arrayPessoa.inserir(modelNaoPessoa));
	}

	@Test
	void deveriaRemoverPessoaComSucesso() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
		pessoa.setNome("Maria");
		pessoa.setCpf("987.654.321-00");

		arrayPessoa.inserir(pessoa);
		arrayPessoa.remover(pessoa);

		assertNull(arrayPessoa.pesquisar(pessoa));
	}

	@Test
	void deveriaLancarExcecaoAoRemoverModelNaoPessoa() {
		Model modelNaoPessoa = new Model();
		modelNaoPessoa.setId(10);

		assertThrows(ModelCastException.class, () -> arrayPessoa.remover(modelNaoPessoa));
	}

	@Test
	void deveriaAtualizarPessoaComSucesso() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
		pessoa.setNome("Ana");
		pessoa.setCpf("111.222.333-44");
		pessoa.setSobrenome("Oliveira");

		arrayPessoa.inserir(pessoa);

		Pessoa pessoaAtualizada = new Pessoa();
		pessoaAtualizada.setId(1); 
		pessoaAtualizada.setNome("Ana Clara");
		pessoaAtualizada.setCpf("111.222.333-44");
		pessoaAtualizada.setSobrenome("Oliveira Silva");
		pessoaAtualizada.setEndereco("Rua B, 456");

		arrayPessoa.atualizar(pessoaAtualizada);

		Pessoa resultado = (Pessoa) arrayPessoa.pesquisar(pessoaAtualizada);

		assertEquals("Ana Clara", resultado.getNome());
		assertEquals("Oliveira Silva", resultado.getSobrenome());
		assertEquals("Rua B, 456", resultado.getEndereco());
	}

	@Test
	void deveriaLancarExcecaoAoAtualizarModelNaoPessoa() {
		Model modelNaoPessoa = new Model();
		modelNaoPessoa.setId(10);

		assertThrows(ModelCastException.class, () -> arrayPessoa.atualizar(modelNaoPessoa));
	}

	@Test
	void deveriaOrdenarPorIdCrescenteComSucesso() {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setId(3);
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setId(1);
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setId(2);

		arrayPessoa.inserir(pessoa1);
		arrayPessoa.inserir(pessoa2);
		arrayPessoa.inserir(pessoa3);

		arrayPessoa.ordenarPorIdCrescente(0);

		assertEquals(pessoa2, arrayPessoa.getItens()[0]);
		assertEquals(pessoa3, arrayPessoa.getItens()[1]);
		assertEquals(pessoa1, arrayPessoa.getItens()[2]);
	}

	@Test
	void deveriaOrdenarPorIdDecrescenteComSucesso() {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setId(3);
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setId(1);
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setId(2);

		arrayPessoa.inserir(pessoa1);
		arrayPessoa.inserir(pessoa2);
		arrayPessoa.inserir(pessoa3);

		arrayPessoa.ordenarPorIdDecrescente(0);

		assertEquals(pessoa1, arrayPessoa.getItens()[0]);
		assertEquals(pessoa3, arrayPessoa.getItens()[1]);
		assertEquals(pessoa2, arrayPessoa.getItens()[2]);
	}

	@Test
	void deveriaLancarExcecaoAoPesquisarModelNaoPessoa() {
		Model modelNaoPessoa = new Model();
		modelNaoPessoa.setId(10);

		assertThrows(ModelCastException.class, () -> arrayPessoa.pesquisar(modelNaoPessoa));
	}
}
