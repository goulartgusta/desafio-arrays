package br.com.almaviva.desafio.array.etapa2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Bicicleta;
import br.com.almaviva.desafio.array.etapa2.models.Carro;
import br.com.almaviva.desafio.array.exceptions.ModelCastException;

class ArrayBicicletaTeste {

    private ArrayBicicleta arrayBicicleta;

    @BeforeEach
    void setUp() {
        arrayBicicleta = new ArrayBicicleta(2);
    }

    @Test
    void deveriaPesquisarBicicletaComSucesso() {
        Bicicleta bike = new Bicicleta();
        bike.setId(2);
        arrayBicicleta.inserir(bike);

        Bicicleta encontrada = (Bicicleta) arrayBicicleta.pesquisar(bike);
        assertNotNull(encontrada);
        assertEquals(2, encontrada.getId());
    }

    @Test
    void deveriaLancarExcecaoAoPesquisarCarro() {
        Carro carro = new Carro();
        assertThrows(ModelCastException.class, () -> arrayBicicleta.pesquisar(carro));
    }

    @Test
    void deveriaLancarExcecaoAoAtualizarCarro() {
        Carro carro = new Carro();
        carro.setId(99);

        assertThrows(ModelCastException.class, () -> arrayBicicleta.atualizar(carro));
    }
}
