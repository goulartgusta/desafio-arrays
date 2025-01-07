package br.com.almaviva.desafio.array.etapa2.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarroTest {

    @Test
    void deveriaConfigurarEObterId() {
        Carro carro = new Carro();
        carro.setId(100);
        assertEquals(100, carro.getId());
    }

    @Test
    void deveriaConfigurarEObterNome() {
        Carro carro = new Carro();
        carro.setNome("MeuCarro");
        assertEquals("MeuCarro", carro.getNome());
    }

    @Test
    void deveriaConfigurarEObterAno() {
        Carro carro = new Carro();
        carro.setAno(2023);
        assertEquals(2023, carro.getAno());
    }

    @Test
    void deveriaConfigurarEObterMarca() {
        Carro carro = new Carro();
        carro.setMarca("Volkswagen");
        assertEquals("Volkswagen", carro.getMarca());
    }

    @Test
    void deveriaConfigurarEObterPlaca() {
        Carro carro = new Carro();
        carro.setPlaca("ABC-1234");
        assertEquals("ABC-1234", carro.getPlaca());
    }

    @Test
    void deveriaConfigurarEObterCor() {
        Carro carro = new Carro();
        carro.setCor("Preto");
        assertEquals("Preto", carro.getCor());
    }
}
