package com.treino.model;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;



public class TrainNaturalPhysiqueTest {
    private TrainNaturalPhysique natural;

    @Before
    public void setUp() {
        Treinos.treinos.clear();
        Treinos.descricaoDia.clear();
        Treinos.descricaoTreino.clear();
            natural = new TrainNaturalPhysique();
        }
    
        @Test
        public void testNaturalInitialization() {
           Map<String, List<Exercicios>> mapa = natural.initializeTrainNaturalPhysique();
           assertNotNull(mapa);

            assertTrue(mapa.containsKey("Segunda"));
            assertTrue(mapa.containsKey("Terça"));
            assertTrue(mapa.containsKey("Quarta"));
            assertTrue(mapa.containsKey("Quinta"));
            assertTrue(mapa.containsKey("Sexta"));
            assertTrue(mapa.containsKey("Sábado"));
            assertTrue(mapa.containsKey("Domingo"));

            // Quantidades por dia (conforme a sua lista)
            assertEquals(6, mapa.get("Segunda").size());
            assertEquals(5, mapa.get("Terça").size());
            assertEquals(5, mapa.get("Quarta").size());
            assertEquals(3, mapa.get("Quinta").size());
            assertEquals(5, mapa.get("Sexta").size());
            assertEquals(5, mapa.get("Sábado").size());
            assertEquals(1, mapa.get("Domingo").size());

                // Domingo deve ser "Descanso"
            List<Exercicios> domingo = mapa.get("Domingo");
            assertEquals(1, domingo.size());
            // Se sua classe Exercicios tem getNome(), descomente a linha abaixo:
            // assertEquals("Descanso", domingo.get(0).getNome());

            // descricaoDia também deve ter sido preenchida
            assertEquals("Costas + Glúteo Médio + Abdômen", Treinos.descricaoDia.get("Segunda"));
            assertEquals("Peito + Bíceps + Abdômen", Treinos.descricaoDia.get("Terça"));
            assertEquals("Posterior de Coxa + Quadríceps + Panturrilha", Treinos.descricaoDia.get("Quarta"));
            assertEquals("Descanso ativo (cárdio leve + mobilidade + core)", Treinos.descricaoDia.get("Quinta"));
            assertEquals("Ombros + Triceps + Abdômen", Treinos.descricaoDia.get("Sexta"));
            assertEquals("Quadríceps + Glúteos", Treinos.descricaoDia.get("Sábado"));
            assertEquals("Descanso total", Treinos.descricaoDia.get("Domingo"));
        }

        @Test
        public void rotineTrainNaturalPovoaDescricaoDia(){

            natural.rotineTrainNatural();

            assertEquals("Costas + Glúteo Médio + Abdômen", Treinos.descricaoDia.get("Segunda"));
            assertEquals("Peito + Bíceps + Abdômen", Treinos.descricaoDia.get("Terça"));
            assertEquals("Posterior de Coxa + Quadríceps + Panturrilha", Treinos.descricaoDia.get("Quarta"));
            assertEquals("Descanso ativo (cárdio leve + mobilidade + core)", Treinos.descricaoDia.get("Quinta"));
            assertEquals("Ombros + Triceps + Abdômen", Treinos.descricaoDia.get("Sexta"));
            assertEquals("Quadríceps + Glúteos", Treinos.descricaoDia.get("Sábado"));
            assertEquals("Descanso total", Treinos.descricaoDia.get("Domingo"));
        }
}

