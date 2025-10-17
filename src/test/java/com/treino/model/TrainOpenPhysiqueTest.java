package com.treino.model;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TrainOpenPhysiqueTest {
     private TrainOpenPhysique open;

    @Before
    public void setUp() {
        // Limpa estado global compartilhado da interface
        Treinos.treinos.clear();
        Treinos.descricaoDia.clear();
        Treinos.descricaoTreino.clear();

        open = new TrainOpenPhysique();
    }

    @Test
    public void initializeTrainOpen_povoaTodosOsDias_comQuantidadesEsperadas() {
        Map<String, List<Exercicios>> mapa = open.initializeTrainOpen();

        assertNotNull(mapa);

        // Verifica presença de todos os dias
        assertTrue(mapa.containsKey("Segunda"));
        assertTrue(mapa.containsKey("Terça"));
        assertTrue(mapa.containsKey("Quarta"));
        assertTrue(mapa.containsKey("Quinta"));
        assertTrue(mapa.containsKey("Sexta"));
        assertTrue(mapa.containsKey("Sábado"));
        assertTrue(mapa.containsKey("Domingo"));

        // Quantidades por dia (conforme a sua lista)
        assertEquals(7, mapa.get("Segunda").size());
        assertEquals(6, mapa.get("Terça").size());
        assertEquals(7, mapa.get("Quarta").size());
        assertEquals(7, mapa.get("Quinta").size());
        assertEquals(7, mapa.get("Sexta").size());
        assertEquals(6, mapa.get("Sábado").size());
        assertEquals(1, mapa.get("Domingo").size());

        // Domingo deve ser "Descanso"
        List<Exercicios> domingo = mapa.get("Domingo");
        assertEquals(1, domingo.size());
        // Se sua classe Exercicios tem getNome(), descomente a linha abaixo:
        // assertEquals("Descanso", domingo.get(0).getNome());

        // descricaoDia também deve ter sido preenchida
        assertEquals("Peito e ombros (ênfase superior)", Treinos.descricaoDia.get("Segunda"));
        assertEquals("Costas e posteriores de ombro", Treinos.descricaoDia.get("Terça"));
        assertEquals("Pernas completas (quadríceps e posteriores)", Treinos.descricaoDia.get("Quarta"));
        assertEquals("Braços (bíceps + tríceps)", Treinos.descricaoDia.get("Quinta"));
        assertEquals("Peito e costas (treino combinado — densidade)", Treinos.descricaoDia.get("Sexta"));
        assertEquals("(ênfase glúteo e posterior)", Treinos.descricaoDia.get("Sábado"));
        assertEquals("Descanso", Treinos.descricaoDia.get("Domingo"));
    }

    @Test
    public void rotineTrainOPEN_povoaDescricaoDia() {
        // Chama só o método de rotina
        open.rotineTrainOPEN();

        assertEquals("Peito e ombros (ênfase superior)", Treinos.descricaoDia.get("Segunda"));
        assertEquals("Costas e posteriores de ombro", Treinos.descricaoDia.get("Terça"));
        assertEquals("Pernas completas (quadríceps e posteriores)", Treinos.descricaoDia.get("Quarta"));
        assertEquals("Braços (bíceps + tríceps)", Treinos.descricaoDia.get("Quinta"));
        assertEquals("Peito e costas (treino combinado — densidade)", Treinos.descricaoDia.get("Sexta"));
        assertEquals("(ênfase glúteo e posterior)", Treinos.descricaoDia.get("Sábado"));
        assertEquals("Descanso", Treinos.descricaoDia.get("Domingo"));
    }

    @Test
    public void initializeTrainOpen_idempotente_emTamanho() {
        open.initializeTrainOpen();
        Map<String, List<Exercicios>> primeira = Treinos.treinos;
        // Chama de novo — não deve “duplicar” itens (você faz put, sobrescrevendo)
        open.initializeTrainOpen();
        Map<String, List<Exercicios>> segunda = Treinos.treinos;

        assertEquals(primeira.get("Segunda").size(), segunda.get("Segunda").size());
        assertEquals(primeira.get("Domingo").size(), segunda.get("Domingo").size());
    }
}
