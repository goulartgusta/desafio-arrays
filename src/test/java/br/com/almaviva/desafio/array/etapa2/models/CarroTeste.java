package br.com.almaviva.desafio.array.etapa2.models;

import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Carro;

import static org.junit.jupiter.api.Assertions.*;

class CarroTeste{

    @Test
    void deveriaRetornarValoresCorretosNosGetters() {
        Carro carro = new Carro(1, "Toyota", "ABC-1234", 2022);

        assertEquals("Toyota", carro.getMarca());
        assertEquals("ABC-1234", carro.getPlaca());
        assertEquals(2022, carro.getAno());
    }

    @Test
    void deveriaAlterarValoresCorretamenteNosSetters() {
        Carro carro = new Carro(1, "Toyota", "ABC-1234", 2022);

        carro.setMarca("Honda");
        carro.setPlaca("XYZ-9876");
        carro.setAno(2020);

        assertEquals("Honda", carro.getMarca());
        assertEquals("XYZ-9876", carro.getPlaca());
        assertEquals(2020, carro.getAno());
    }

    @Test
    void naoDeveriaRetornarValoresIncorretosNosGetters() {
        Carro carro = new Carro(1, "Toyota", "ABC-1234", 2022);

        assertNotEquals("Honda", carro.getMarca());
        assertNotEquals("XYZ-9876", carro.getPlaca());
        assertNotEquals(2020, carro.getAno());
    }

    @Test
    void naoDeveriaAlterarParaValoresIncorretosNosSetters() {
        Carro carro = new Carro(1, "Toyota", "ABC-1234", 2022);

        carro.setMarca("Toyota");
        carro.setPlaca("ABC-1234");
        carro.setAno(2022);

        assertEquals("Toyota", carro.getMarca());
        assertEquals("ABC-1234", carro.getPlaca());
        assertEquals(2022, carro.getAno());
    }

    @Test
    void deveriaRetornarStringCorretaNoToString() {
        Carro carro = new Carro(1, "Toyota", "ABC-1234", 2022);

        String esperado = "Carro{id=1, marca='Toyota', placa='ABC-1234', ano=2022}";
        assertEquals(esperado, carro.toString());
    }

    @Test
    void naoDeveriaRetornarStringIncorretaNoToString() {
        Carro carro = new Carro(1, "Toyota", "ABC-1234", 2022);

        String incorreto = "Carro{id=2, marca='Honda', placa='XYZ-9876', ano=2020}";
        assertNotEquals(incorreto, carro.toString());
    }
}
