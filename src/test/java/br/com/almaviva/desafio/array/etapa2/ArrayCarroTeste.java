package br.com.almaviva.desafio.array.etapa2;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Bicicleta;
import br.com.almaviva.desafio.array.etapa2.models.Carro;
import br.com.almaviva.desafio.array.exceptions.ModelCastException;

class ArrayCarroTeste {

    private ArrayCarro arrayCarro;

    @BeforeEach
    void setUp() {
        arrayCarro = new ArrayCarro(2);
    }

    @Test
    void deveriaRemoverCarroComSucesso() {
        Carro c1 = new Carro();
        c1.setId(1);
        arrayCarro.inserir(c1);

        arrayCarro.remover(c1);
        assertNull(arrayCarro.pesquisar(c1));
    }

    @Test
    void deveriaLancarExcecaoAoRemoverBicicleta() {
        Bicicleta bike = new Bicicleta();
        assertThrows(ModelCastException.class, () -> arrayCarro.remover(bike));
    }

    @Test
    void deveriaLancarExcecaoAoOrdenarCarrosComIdNulo() {
        Carro c1 = new Carro(); c1.setId(null);
        Carro c2 = new Carro(); c2.setId(10);

        arrayCarro.inserir(c1);
        arrayCarro.inserir(c2);

        assertThrows(NullPointerException.class, () -> arrayCarro.ordenarPorIdDecrescente(0));
    }
}
