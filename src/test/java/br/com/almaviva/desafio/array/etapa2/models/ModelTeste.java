package br.com.almaviva.desafio.array.etapa2.models;

import org.junit.jupiter.api.Test;

import br.com.almaviva.desafio.array.etapa2.models.Model;

import static org.junit.jupiter.api.Assertions.*;

class ModelTeste {

    @Test
    void deveriaRetornarValoresCorretosNoGetter() {
        Model model = new Model(1) {};
        assertEquals(1, model.getId());
    }

    @Test
    void deveriaAlterarValoresCorretamenteNoSetter() {
        Model model = new Model(1) {};
        model.setId(2);
        assertEquals(2, model.getId());
    }

    @Test
    void naoDeveriaRetornarValoresIncorretosNoGetter() {
        Model model = new Model(1) {};
        assertNotEquals(2, model.getId());
    }


    @Test
    void naoDeveriaConsiderarObjetosComIDsDiferentesIguais() {
        Model model1 = new Model(1) {};
        Model model2 = new Model(2) {};

        assertNotEquals(model1, model2);
    }

   

    @Test
    void deveriaRetornarStringCorretaNoToString() {
        Model model = new Model(1) {};
        String esperado = "Model{id=1}";
        assertEquals(esperado, model.toString());
    }

    @Test
    void naoDeveriaRetornarStringIncorretaNoToString() {
        Model model = new Model(1) {};
        String incorreto = "Model{id=2}";
        assertNotEquals(incorreto, model.toString());
    }

    @Test
    void naoDeveriaCompararComObjetoNulo() {
        Model model = new Model(1) {};
        assertNotEquals(null, model);
    }

    @Test
    void naoDeveriaCompararComObjetoDeOutraClasse() {
        Model model = new Model(1) {};
        String outroObjeto = "OutroObjeto";
        assertNotEquals(model, outroObjeto);
    }
}
