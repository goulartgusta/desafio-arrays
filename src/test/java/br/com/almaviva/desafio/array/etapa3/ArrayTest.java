package br.com.almaviva.desafio.array.etapa3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Model;

class ArrayTest {

    private Array meuArray;

    @BeforeEach
    void setUp() {
        meuArray = new Array(3);
    }

    @Test
    void deveriaInserirEPesquisarComSucesso() {
        Model model1 = new Model();
        model1.setId(1);
        model1.setNome("Objeto1");
        model1.setAno(2020);

        meuArray.inserir(model1);
        Model pesquisado = meuArray.pesquisar(model1);

        assertNotNull(pesquisado);
        assertEquals("Objeto1", pesquisado.getNome());
    }
    
    @Test
    void deveriaFalharAoInserirEmArrayCheio() {
        Model m1 = new Model(); m1.setId(1);
        Model m2 = new Model(); m2.setId(2);
        Model m3 = new Model(); m3.setId(3);
        Model m4 = new Model(); m4.setId(4);

        meuArray.inserir(m1);
        meuArray.inserir(m2);
        meuArray.inserir(m3);

        meuArray.inserir(m4);

        Model[] itens = meuArray.getItens();
        assertNull(meuArray.pesquisar(m4));
        assertEquals(1, itens[0].getId());
    }
}
