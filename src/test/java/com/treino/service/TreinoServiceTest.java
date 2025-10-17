package com.treino.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.treino.model.Exercicios;
import com.treino.model.Treinos;

public class TreinoServiceTest {
      private TreinoService service;

    @Before
    public void setUp() {
        service = new TreinoService();
        // Limpa estado compartilhado (os Maps da interface são estáticos)
        Treinos.treinos.clear();
        Treinos.descricaoDia.clear();
        Treinos.descricaoTreino.clear();
    }

    // ---------- trainingDescriptionFor ----------
    @Test
    public void trainingDescriptionFor_MensPhysique_ok() {
        String desc = service.trainingDescriptionFor("MensPhysique");
        assertEquals("Mens Physique", desc);
        assertEquals("Mens Physique", Treinos.descricaoTreino.get("Tipo de Treino"));
    }

    @Test
    public void trainingDescriptionFor_ClassicPhysique_ok() {
        String desc = service.trainingDescriptionFor("ClassicPhysique");
        assertEquals("Classic Physique", desc);
        assertEquals("Classic Physique", Treinos.descricaoTreino.get("Tipo de Treino"));
    }

    @Test
    public void trainingDescriptionFor_OpenPhysique_ok() {
        String desc = service.trainingDescriptionFor("OpenPhysique");
        assertEquals("Open Physique", desc);
        assertEquals("Open Physique", Treinos.descricaoTreino.get("Tipo de Treino"));
    }

    @Test
    public void trainingDescriptionFor_NaturalPhysique_ok() {
        String desc = service.trainingDescriptionFor("NaturalPhysique");
        assertEquals("Natural Physique", desc);
        assertEquals("Natural Physique", Treinos.descricaoTreino.get("Tipo de Treino"));
    }

    @Test(expected = IllegalStateException.class)
    public void trainingDescriptionFor_tipoInvalido_lancaExcecao() {
        service.trainingDescriptionFor("QualquerCoisa");
    }

    // ---------- getDescricaoDoDia ----------
    @Test
    public void getDescricaoDoDia_retornaDescricaoPreenchidaParaHoje() {
        String hojeNome = service.getDiaNome(); // "Segunda", "Terça", ...
        Treinos.descricaoDia.put(hojeNome, "Peito e tríceps");
        assertEquals("Peito e tríceps", service.getDescricaoDoDia());
    }

    @Test
    public void getDescricaoDoDia_semDescricao_retornaVazio() {
        // Não popula descricaoDia
        assertEquals("", service.getDescricaoDoDia());
    }

    // ---------- getTreinoDoDia ----------
    @Test
    public void getTreinoDoDia_retornaListaDoDiaQuandoExistir() {
        String hojeNome = service.getDiaNome();
        List<Exercicios> lista = new ArrayList<>(); // pode estar vazia, é só pra apontar a estrutura
        Treinos.treinos.put(hojeNome, lista);

        List<Exercicios> resultado = service.getTreinoDoDia();
        assertSame("Deve retornar a mesma lista associada ao dia de hoje", lista, resultado);
    }

    @Test
    public void getTreinoDoDia_semEntradaParaHoje_retornaListaVazia() {
        List<Exercicios> resultado = service.getTreinoDoDia();
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
}
