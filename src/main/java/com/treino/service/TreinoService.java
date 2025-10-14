package com.treino.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.treino.model.Exercicios;
import com.treino.model.TrainClassicPhysique;
import com.treino.model.TrainMensPhysique;
import com.treino.model.TrainNatural;
import com.treino.model.TrainOPEN;
import com.treino.model.Treino;



@Service
public class TreinoService implements Treino {  


    private final TrainMensPhysique trainMensPhysique = new TrainMensPhysique();

    private final TrainClassicPhysique trainClassicPhysique = new TrainClassicPhysique();

    private final TrainOPEN trainOPEN = new TrainOPEN();

    private final TrainNatural trainNatural = new TrainNatural();


    public final void oTreinoMP(){
        Map<String, List<Exercicios>> treinoMap = trainMensPhysique.getTrainMensPhysique();
        if (treinoMap != null) {
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }
        System.out.println("Treinos carregados: " + trainMensPhysique.getTrainMensPhysique());
        
    }

    public final void oTrainCP(){
        Map<String, List<Exercicios>> treinoMap = trainClassicPhysique.getTrainClassicPhysique();
        if(treinoMap != null){
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }
        System.out.println("Treinos carregados: " + trainClassicPhysique.getTrainClassicPhysique());
    }

    public final void oTrainOPEN(){
        Map<String, List<Exercicios>> treinoMap = trainOPEN.getTrainOPEN();
        if(treinoMap != null){
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }
        System.out.println("Treinos carregados: " + trainOPEN.getTrainOPEN());
    }

    public final void oTrainNatural(){
        Map<String, List<Exercicios>> treinoMap = trainNatural.getTrainNatural();
        if(treinoMap != null){
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }
        System.out.println("Treinos carregados: " + trainNatural.getTrainNatural());
    }

 

    public List<Exercicios> getTreinoDoDia() {
        DayOfWeek diaSemana = LocalDate.now().getDayOfWeek();
        String dia = converterDia(diaSemana); // usa o método que converte para "Segunda", "Terça"...
        List<Exercicios> treinoDoDia = treinos.get(dia);
        return treinoDoDia != null ? treinoDoDia : Collections.emptyList();
    }

    public String converterDia(DayOfWeek diaSemana) {
        return switch (diaSemana) {
            case MONDAY -> "Segunda";
            case TUESDAY -> "Terça";
            case WEDNESDAY -> "Quarta";
            case THURSDAY -> "Quinta";
            case FRIDAY -> "Sexta";
            case SATURDAY -> "Sábado";
            case SUNDAY -> "Domingo";
        };
    }



    
}
