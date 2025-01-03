package br.com.almaviva.desafio.array.etapa2.models;

import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Bicicleta;

import static org.junit.jupiter.api.Assertions.*;

class BicicletaTeste {

    @Test
    void deveriaRetornarValoresCorretosNosGetters() {
        Bicicleta bicicleta = new Bicicleta(1, "Caloi", "Vermelha", 2022);

        assertEquals("Caloi", bicicleta.getMarca());
        assertEquals("Vermelha", bicicleta.getCor());
        assertEquals(2022, bicicleta.getAnoFabricacao());
    }

    @Test
    void deveriaAlterarValoresCorretamenteNosSetters() {
        Bicicleta bicicleta = new Bicicleta(1, "Caloi", "Vermelha", 2022);

        bicicleta.setMarca("Monark");
        bicicleta.setCor("Azul");
        bicicleta.setAnoFabricacao(2021);

        assertEquals("Monark", bicicleta.getMarca());
        assertEquals("Azul", bicicleta.getCor());
        assertEquals(2021, bicicleta.getAnoFabricacao());
    }

    @Test
    void naoDeveriaRetornarValoresIncorretosNosGetters() {
        Bicicleta bicicleta = new Bicicleta(1, "Caloi", "Vermelha", 2022);

        assertNotEquals("Monark", bicicleta.getMarca());
        assertNotEquals("Azul", bicicleta.getCor());
        assertNotEquals(2021, bicicleta.getAnoFabricacao());
    }

    @Test
    void naoDeveriaAlterarParaValoresIncorretosNosSetters() {
        Bicicleta bicicleta = new Bicicleta(1, "Caloi", "Vermelha", 2022);

        bicicleta.setMarca("Caloi");
        bicicleta.setCor("Vermelha");
        bicicleta.setAnoFabricacao(2022);

        assertEquals("Caloi", bicicleta.getMarca());
        assertEquals("Vermelha", bicicleta.getCor());
        assertEquals(2022, bicicleta.getAnoFabricacao());
    }

    @Test
    void naoDeveriaRetornarStringIncorretaNoToString() {
        Bicicleta bicicleta = new Bicicleta(1, "Caloi", "Vermelha", 2022);

        String incorreto = "Bicicleta{id=2, marca='Monark', cor='Azul', anoFabricacao=2021}";
        assertNotEquals(incorreto, bicicleta.toString());
    }
}
