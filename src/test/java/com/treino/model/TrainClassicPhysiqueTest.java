package com.treino.model;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class TrainClassicPhysiqueTest {
    private TrainClassicPhysique classicPhysique;

    @Before
    public void setUp() {
        Treinos.treinos.clear();
        Treinos.descricaoDia.clear();
        Treinos.descricaoTreino.clear();
        classicPhysique = new TrainClassicPhysique();
    }

    @Test
    public void testClassicPhysique() {
      Map<String, List<Exercicios>> mapa = classicPhysique.getTrainClassicPhysique();
      assertNotNull(mapa);

        assertTrue(mapa.containsKey("Segunda"));
        assertTrue(mapa.containsKey("Terça"));
        assertTrue(mapa.containsKey("Quarta"));
        assertTrue(mapa.containsKey("Quinta"));
        assertTrue(mapa.containsKey("Sexta"));
        assertTrue(mapa.containsKey("Sábado"));
        assertTrue(mapa.containsKey("Domingo"));

        assertEquals(7, mapa.get("Segunda").size());
        assertEquals(6, mapa.get("Terça").size());
        assertEquals(6, mapa.get("Quarta").size());
        assertEquals(7, mapa.get("Quinta").size());
        assertEquals(6, mapa.get("Sexta").size());
        assertEquals(6, mapa.get("Sábado").size());
        assertEquals(1, mapa.get("Domingo").size());
    }

    @Test
    public void rotineTrainClassicPhysique_PovoaDescricaoDia(){
        classicPhysique.rotineTrainclassicPhysique();

        assertEquals("Dia de Peito/Ombros", Treinos.descricaoDia.get("Segunda"));
        assertEquals("Costas e Abdômen", Treinos.descricaoDia.get("Terça"));
        assertEquals("Quadriceps", Treinos.descricaoDia.get("Quarta"));
        assertEquals("Ombros e Tríceps", Treinos.descricaoDia.get("Quinta"));
        assertEquals("Costa e Bíceps", Treinos.descricaoDia.get("Sexta"));
        assertEquals("Pernas B (Posterior/Glúteos/Panturrilha)", Treinos.descricaoDia.get("Sábado"));
        assertEquals("Descanso", Treinos.descricaoDia.get("Domingo"));
    }
    
}
