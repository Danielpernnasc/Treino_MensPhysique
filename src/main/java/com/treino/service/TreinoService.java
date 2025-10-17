package com.treino.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.treino.model.Exercicios;
import com.treino.model.TrainClassicPhysique;
import com.treino.model.TrainMensPhysique;
import com.treino.model.TrainNaturalPhysique;
import com.treino.model.TrainOpenPhysique;
import com.treino.model.Treinos;


@Service
public class TreinoService implements Treinos  {


        
    private final TrainMensPhysique trainMensPhysique = new TrainMensPhysique();

    private final TrainClassicPhysique trainClassicPhysique = new TrainClassicPhysique();
    private final TrainOpenPhysique trainOpenPhysique = new TrainOpenPhysique();
    private final TrainNaturalPhysique trainNaturalPhysique = new TrainNaturalPhysique();
    

    public TrainMensPhysique getMP() {
        return trainMensPhysique;
    }
    public TrainClassicPhysique getCP() {
        return trainClassicPhysique;
    }
    public TrainOpenPhysique getOP() {
        return trainOpenPhysique;
    }
    public TrainNaturalPhysique getNP() {
        return trainNaturalPhysique;
    }

    public List<Exercicios> gettrainMP(){
         Map<String, List<Exercicios>> treinoMap = trainMensPhysique.initializeTrainMensPhisique();
        if (treinoMap != null) {
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }
        System.out.println("Treinos carregados: " + trainMensPhysique.initializeTrainMensPhisique());
        return new ArrayList<>(treinos.values().stream().findFirst().orElse(Collections.emptyList()));
    }


    public List<Exercicios> gettrainCP(){
        Map<String, List<Exercicios>> treinoMap = trainClassicPhysique.getTrainClassicPhysique();
        if (treinoMap != null) {
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }
        System.out.println("Treinos carregados: " + trainClassicPhysique.getTrainClassicPhysique());
        return new ArrayList<>(treinos.values().stream().findFirst().orElse(Collections.emptyList()));
    }

    public List<Exercicios> gettrainOP(){
        Map<String, List<Exercicios>> treinoMap = trainOpenPhysique.initializeTrainOpen();
        if (treinoMap != null) {
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }   
        return new ArrayList<>(treinos.values().stream().findFirst().orElse(Collections.emptyList()));
    }

    public List<Exercicios> gettrainNP(){
        Map<String, List<Exercicios>> treinoMap = trainNaturalPhysique.initializeTrainNaturalPhysique();
        if (treinoMap != null) {
            treinoMap.forEach((day, exercises) -> treinos.put(day, exercises));
        }   
        return new ArrayList<>(treinos.values().stream().findFirst().orElse(Collections.emptyList()));
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


    public String getDescricaoDoDia() {
        String dia = converterDia(LocalDate.now().getDayOfWeek());
        return descricaoDia.getOrDefault(dia, "");
    }



    
    public String trainingDescriptionFor(String trainingType) {
        switch (trainingType) {
            case "MensPhysique":
                trainMensPhysique.itsTrain();
                descricaoTreino.put("Tipo de Treino", "Mens Physique");
                return "Mens Physique";
            case "ClassicPhysique":
                trainClassicPhysique.itsTrain();
                descricaoTreino.put("Tipo de Treino", "Classic Physique");
                return "Classic Physique";
            case "OpenPhysique":
                trainOpenPhysique.itsTrain();
                descricaoTreino.put("Tipo de Treino", "Open Physique");
                return "Open Physique";
            case "NaturalPhysique":
                trainNaturalPhysique.itsTrain();
                descricaoTreino.put("Tipo de Treino", "Natural Physique");
                return "Natural Physique";
            default:
                throw new IllegalStateException("Unexpected training type: " + trainingType);
        }
    }
    
    }



