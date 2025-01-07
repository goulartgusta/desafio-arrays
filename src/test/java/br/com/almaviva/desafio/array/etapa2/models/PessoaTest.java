package br.com.almaviva.desafio.array.etapa2.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void deveriaConfigurarEObterId() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(99);
        assertEquals(99, pessoa.getId());
    }

    @Test
    void deveriaConfigurarEObterNome() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("José");
        assertEquals("José", pessoa.getNome());
    }

    @Test
    void deveriaConfigurarEObterAno() {
        Pessoa pessoa = new Pessoa();
        pessoa.setAno(1985);
        assertEquals(1985, pessoa.getAno());
    }

    @Test
    void deveriaConfigurarEObterCpf() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("123.456.789-00");
        assertEquals("123.456.789-00", pessoa.getCpf());
    }

    @Test
    void deveriaConfigurarEObterSobrenome() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSobrenome("Silva");
        assertEquals("Silva", pessoa.getSobrenome());
    }

    @Test
    void deveriaConfigurarEObterEndereco() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEndereco("Rua A, 123");
        assertEquals("Rua A, 123", pessoa.getEndereco());
    }
}
