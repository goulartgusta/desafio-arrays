package br.com.almaviva.desafio.array.etapa2.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelTeste {

    @Test
    void deveriaConfigurarEObterId() {
        Model model = new Model();
        model.setId(10);
        assertEquals(10, model.getId());
    }

    @Test
    void deveriaConfigurarEObterNome() {
        Model model = new Model();
        model.setNome("TesteNome");
        assertEquals("TesteNome", model.getNome());
    }

    @Test
    void deveriaConfigurarEObterAno() {
        Model model = new Model();
        model.setAno(2022);
        assertEquals(2022, model.getAno());
    }
}
