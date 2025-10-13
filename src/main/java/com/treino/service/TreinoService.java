package com.treino.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.treino.model.Exercicios;


@Service
public class TreinoService {
    
    private Map<String, List<Exercicios>> treinos = new HashMap<>();
    private final Map<String,String> descricaoDia = new HashMap<>();

    {
        treinos.put("Segunda", Arrays.asList(
            new Exercicios("Supino Reto barra", 4, "8-10", "90s", "Manter os pés no chão e a coluna neutra."),
            new Exercicios("Supino Inclinado halteres", 4, "10-12", "75s", "Controlar a descida dos halteres."),
            new Exercicios("Crossover polia alta", 3, "12-15", "60s", "Evitar sobrecarga nos ombros."),
            new Exercicios("Mergulho paralelas", 3, "10-12", "75s", "Manter o tronco levemente inclinado para frente."),
            new Exercicios("Tríceps testa barra W", 3, "10-12", "75s", "Evitar hiperextensão dos cotovelos."),
            new Exercicios("Tríceps corda polia alta", 3, "12-15", "60s", "Manter os cotovelos fixos ao lado do corpo.")
        ));

        treinos.put("Terça", Arrays.asList(
            new Exercicios("Puxada frente pegada aberta", 4,"10-12", "90", ""),
            new Exercicios("Remada curvada com barra", 4, "8-10", "90s", "Manter a coluna neutra durante o movimento."),
            new Exercicios("Remada unilateral com halteres", 3, "10-12", "75s", "Evitar girar o tronco durante o movimento."),
            new Exercicios("Rosca direta barra reta", 3, "10", "60s", "Manter os cotovelos fixos ao lado do corpo."),
            new Exercicios("Rosca alternada c/ rotação", 3, "12", "60s", "Controlar a descida dos halteres."),
            new Exercicios("Rosca martelo", 2, "15", "45s", "Manter os punhos neutros durante o movimento.")
        ));


        treinos.put("Quarta", Arrays.asList(
            new Exercicios("Descanso total ou outra atividade", 0, "", "", "")
        ));

        treinos.put("Quinta", Arrays.asList(
          new Exercicios("Cardio leve/moderado 30-45 min", 0, "", "", ""),
          new Exercicios("Abdominal infra banco", 3, "20", "45s", ""),
          new Exercicios("Prancha", 3, "45s", "45s", ""),
          new Exercicios("Abdominal lateral oblíquo", 3, "15 cada lado", "45s", "")
        ));

        treinos.put("Sexta", Arrays.asList(
            new Exercicios("Cadeira flexora", 4, "12", "60s", ""),
            new Exercicios("Stiff halteres", 4, "10–12", "90s", ""),
            new Exercicios("Agachamento livre/smith", 3, "8–10", "90s", ""),
            new Exercicios("Leg press", 3, "12", "75s", ""),
            new Exercicios("Cadeira extensora", 3, "15", "60s", ""),
            new Exercicios("Panturrilha em pé", 4, "20", "45s", "")
        ));

        treinos.put("Sábado", Arrays.asList(
            new Exercicios("Desenvolvimento halteres", 4, "8–10", "90s", ""),
            new Exercicios("Elevação lateral", 4, "12–15", "60s", ""),
            new Exercicios("Elevação frontal alternada", 3, "12", "60s", ""),
            new Exercicios("Crucifixo invertido", 3, "15", "60s", ""),
            new Exercicios("Encolhimento halteres", 3, "12–15", "60s", "")
        ));


        
    }

   
 
    public List<Exercicios> getTreinoDoDia() {
        // Pega o dia atual
        DayOfWeek hoje = LocalDate.now().getDayOfWeek();
        // Converte DayOfWeek para String compatível com o Map ("Segunda", "Terça"...)
        String dia = converterDia(hoje);
        // Retorna a lista de treinos do dia, ou lista vazia se não houver
        return treinos.getOrDefault(dia, Collections.emptyList());
    }
    
    // Helper para converter DayOfWeek para String
    private String converterDia(DayOfWeek dayOfWeek) {
        switch(dayOfWeek) {
            case MONDAY: return "Segunda";
            case TUESDAY: return "Terça";
            case WEDNESDAY: return "Quarta";
            case THURSDAY: return "Quinta";
            case FRIDAY: return "Sexta";
            case SATURDAY: return "Sábado";
            case SUNDAY: return "Domingo";
            default: return "";
        }
    }

    public String getDiaNome() {
        return converterDia(LocalDate.now().getDayOfWeek());
    }

    public TreinoService() {
        // ... seu código já existente que preenche treinos ...
        descricaoDia.put("Segunda", "Dia de Peito");
        descricaoDia.put("Terça", "Costas e Bíceps");
        descricaoDia.put("Quarta", "Descanso / Cardio leve");
        descricaoDia.put("Quinta", "Abdômen e Core");
        descricaoDia.put("Sexta", "Pernas");
        descricaoDia.put("Sábado", "Ombros e Trapézio");
        descricaoDia.put("Domingo", "Descanso");
    }

    public String getDescricaoDoDia() {
        String dia = converterDia(LocalDate.now().getDayOfWeek());
        return descricaoDia.getOrDefault(dia, "");
    }
}
