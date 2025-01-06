package br.com.almaviva.desafio.array.etapa2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Carro;
import br.com.almaviva.desafio.array.etapa2.models.Model;
import br.com.almaviva.desafio.array.exceptions.ModelCastException;

class ArrayCarroTeste {

    private ArrayCarro arrayCarro;

    @BeforeEach
    void setUp() {
        arrayCarro = new ArrayCarro(3);
    }

    @Test
    void deveriaInserirCarroComSucesso() {
        Carro carro = new Carro();
        carro.setId(1);
        carro.setMarca("Toyota");
        carro.setPlaca("ABC-1234");
        carro.setCor("Preto");

        arrayCarro.inserir(carro);

        assertEquals(carro, arrayCarro.pesquisar(carro));
    }

    @Test
    void deveriaLancarExcecaoAoInserirModelNaoCarro() {
        Model modelNaoCarro = new Model();
        modelNaoCarro.setId(10);

        assertThrows(ModelCastException.class, () -> arrayCarro.inserir(modelNaoCarro));
    }

    @Test
    void deveriaRemoverCarroComSucesso() {
        Carro carro = new Carro();
        carro.setId(1);
        carro.setMarca("Honda");
        carro.setPlaca("DEF-5678");
        carro.setCor("Azul");

        arrayCarro.inserir(carro);
        arrayCarro.remover(carro);

        assertNull(arrayCarro.pesquisar(carro));
    }

    @Test
    void deveriaLancarExcecaoAoRemoverModelNaoCarro() {
        Model modelNaoCarro = new Model();
        modelNaoCarro.setId(10);

        assertThrows(ModelCastException.class, () -> arrayCarro.remover(modelNaoCarro));
    }

    @Test
    void deveriaOrdenarPorIdCrescenteComSucesso() {
        Carro carro1 = new Carro();
        carro1.setId(3);
        carro1.setMarca("Toyota");
        Carro carro2 = new Carro();
        carro2.setId(1);
        carro2.setMarca("Honda");
        Carro carro3 = new Carro();
        carro3.setId(2);
        carro3.setMarca("Chevrolet");

        arrayCarro.inserir(carro1);
        arrayCarro.inserir(carro2);
        arrayCarro.inserir(carro3);

        arrayCarro.ordenarPorIdCrescente(0);

        assertEquals(carro2, arrayCarro.getItens()[0]);
        assertEquals(carro3, arrayCarro.getItens()[1]);
        assertEquals(carro1, arrayCarro.getItens()[2]);
    }

    @Test
    void deveriaOrdenarPorIdDecrescenteComSucesso() {
        Carro carro1 = new Carro();
        carro1.setId(3);
        Carro carro2 = new Carro();
        carro2.setId(1);
        Carro carro3 = new Carro();
        carro3.setId(2);

        arrayCarro.inserir(carro1);
        arrayCarro.inserir(carro2);
        arrayCarro.inserir(carro3);

        arrayCarro.ordenarPorIdDecrescente(0);

        assertEquals(carro1, arrayCarro.getItens()[0]);
        assertEquals(carro3, arrayCarro.getItens()[1]);
        assertEquals(carro2, arrayCarro.getItens()[2]);
    }

    @Test
    void deveriaAtualizarCarroComSucesso() {
        Carro carro = new Carro();
        carro.setId(1);
        carro.setMarca("Fiat");
        carro.setPlaca("GHI-9876");
        carro.setCor("Branco");

        arrayCarro.inserir(carro);

        Carro carroAtualizado = new Carro();
        carroAtualizado.setId(1); // Mesmo ID
        carroAtualizado.setMarca("Chevrolet");
        carroAtualizado.setPlaca("JKL-4321");
        carroAtualizado.setCor("Vermelho");

        arrayCarro.atualizar(carroAtualizado);

        Carro resultado = (Carro) arrayCarro.pesquisar(carroAtualizado);

        assertEquals("Chevrolet", resultado.getMarca());
        assertEquals("JKL-4321", resultado.getPlaca());
        assertEquals("Vermelho", resultado.getCor());
    }

    @Test
    void deveriaLancarExcecaoAoAtualizarModelNaoCarro() {
        Model modelNaoCarro = new Model();
        modelNaoCarro.setId(10);

        assertThrows(ModelCastException.class, () -> arrayCarro.atualizar(modelNaoCarro));
    }

    @Test
    void deveriaLancarExcecaoAoPesquisarModelNaoCarro() {
        Model modelNaoCarro = new Model();
        modelNaoCarro.setId(10);

        assertThrows(ModelCastException.class, () -> arrayCarro.pesquisar(modelNaoCarro));
    }
}
