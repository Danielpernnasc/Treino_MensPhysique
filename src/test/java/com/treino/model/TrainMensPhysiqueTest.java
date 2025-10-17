package com.treino.model;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;



public class TrainMensPhysiqueTest {
    private TrainMensPhysique mensPhysique;

        @Before
        public void setUp() {
            Treinos.treinos.clear();
            Treinos.descricaoDia.clear();
            Treinos.descricaoTreino.clear();
            mensPhysique = new TrainMensPhysique();
        }

        @Test
        public void testMensPhysique(){
            Map<String, java.util.List<Exercicios>> mapa = mensPhysique.initializeTrainMensPhisique();
            assertNotNull(mapa);

                assertTrue(mapa.containsKey("Segunda"));
                assertTrue(mapa.containsKey("Terça"));
                assertTrue(mapa.containsKey("Quarta"));
                assertTrue(mapa.containsKey("Quinta"));
                assertTrue(mapa.containsKey("Sexta"));
                assertTrue(mapa.containsKey("Sábado"));
                assertTrue(mapa.containsKey("Domingo"));

                assertEquals(6, mapa.get("Segunda").size());
                assertEquals(6, mapa.get("Terça").size());
                assertEquals(1, mapa.get("Quarta").size());
                assertEquals(4, mapa.get("Quinta").size());
                assertEquals(6, mapa.get("Sexta").size());
                assertEquals(5, mapa.get("Sábado").size());
                assertEquals(1, mapa.get("Domingo").size());
        }
        
        @Test
        public void rotineTrainMensPhysique_PovaDescricaoDia(){
            
            mensPhysique.rotineTrainMensPhysique();
            assertEquals("Dia de Peito", Treinos.descricaoDia.get("Segunda"));
            assertEquals("Costas e Bíceps", Treinos.descricaoDia.get("Terça"));
            assertEquals("Descanso / Cardio leve", Treinos.descricaoDia.get("Quarta"));
            assertEquals("Abdômen e Core", Treinos.descricaoDia.get("Quinta"));
            assertEquals("Pernas", Treinos.descricaoDia.get("Sexta"));
            assertEquals("Ombros e Trapézio", Treinos.descricaoDia.get("Sábado"));
            assertEquals("Descanso", Treinos.descricaoDia.get("Domingo"));
        }


        @Test
        public void initializeTrainOpen_idempotente_emTamanho() {
            mensPhysique.initializeTrainMensPhisique();
            Map<String, List<Exercicios>> primeira = Treinos.treinos;
            // Chama de novo — não deve “duplicar” itens (você faz put, sobrescrevendo)
            mensPhysique.initializeTrainMensPhisique();
            Map<String, List<Exercicios>> segunda = Treinos.treinos;

            assertEquals(primeira.get("Segunda").size(), segunda.get("Segunda").size());
            assertEquals(primeira.get("Domingo").size(), segunda.get("Domingo").size());
        }

            
    }
    

