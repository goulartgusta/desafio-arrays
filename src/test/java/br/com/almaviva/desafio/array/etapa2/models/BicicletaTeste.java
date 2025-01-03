package br.com.almaviva.desafio.array.etapa2.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BicicletaTest {

    @Test
    void deveriaConfigurarEObterId() {
        Bicicleta bike = new Bicicleta();
        bike.setId(1);
        assertEquals(1, bike.getId());
    }

    @Test
    void deveriaConfigurarEObterNome() {
        Bicicleta bike = new Bicicleta();
        bike.setNome("Speed");
        assertEquals("Speed", bike.getNome());
    }

    @Test
    void deveriaConfigurarEObterAno() {
        Bicicleta bike = new Bicicleta();
        bike.setAno(2022);
        assertEquals(2022, bike.getAno());
    }

    @Test
    void deveriaConfigurarEObterCor() {
        Bicicleta bike = new Bicicleta();
        bike.setCor("Azul");
        assertEquals("Azul", bike.getCor());
    }

    @Test
    void deveriaConfigurarEObterMarca() {
        Bicicleta bike = new Bicicleta();
        bike.setMarca("Caloi");
        assertEquals("Caloi", bike.getMarca());
    }

    @Test
    void deveriaConfigurarEObterTamanhoAro() {
        Bicicleta bike = new Bicicleta();
        bike.setTamanhoQuadro(29);
        assertEquals(29, bike.getTamanhoQuadro());
    }
}
