package br.com.almaviva.desafio.array.etapa2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Bicicleta;
import br.com.almaviva.desafio.array.etapa2.models.Pessoa;
import br.com.almaviva.desafio.array.exceptions.ModelCastException;

class ArrayPessoaTeste {

    private ArrayPessoa arrayPessoa;

    @BeforeEach
    void setUp() {
        arrayPessoa = new ArrayPessoa(2);
    }

    @Test
    void deveriaInserirPessoaComSucesso() {
        Pessoa p = new Pessoa();
        p.setId(100);
        p.setNome("Fulano");

        assertDoesNotThrow(() -> arrayPessoa.inserir(p));
    }

    @Test
    void deveriaLancarExcecaoAoInserirBicicleta() {
        Bicicleta bike = new Bicicleta();
        bike.setId(999);

        assertThrows(ModelCastException.class, () -> arrayPessoa.inserir(bike));
    }

    @Test
    void deveriaLancarExcecaoAoOrdenarPessoasComIdNulo() {
        Pessoa p1 = new Pessoa(); p1.setId(null);
        Pessoa p2 = new Pessoa(); p2.setId(10);

        arrayPessoa.inserir(p1);
        arrayPessoa.inserir(p2);

        assertThrows(NullPointerException.class, () -> arrayPessoa.ordenarPorIdCrescente(0));
    }
}
