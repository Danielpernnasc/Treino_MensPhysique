package com.treino.controller;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.treino.model.Exercicios;
import com.treino.service.TreinoService;

@Controller
public class TreinoController {
    private final TreinoService treinoService;
    @Autowired
    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }


    @RequestMapping(value = {"/", "/home", "/treino"}, method = RequestMethod.GET)
    public String home() {
        return "redirect:/trainMensPhysique"; // ou /trainClassicPhysique etc.
    }


    @RequestMapping(value = "/trainMensPhysique", method = RequestMethod.GET)
    public String treinoMP(Model model) {
        treinoService.getMP().initializeTrainMensPhisique(); // carrega o treino correto
        List<Exercicios> lista = treinoService.getTreinoDoDia(); // treino do dia
        if (lista == null) {
            lista = Collections.emptyList();
        } else {
            lista.removeIf(Objects::isNull);
        }
        rotineExercise(model, lista);
        String tipoTreino = treinoService.trainingDescriptionFor("MensPhysique");
        model.addAttribute("descricaoTreino", tipoTreino);
        model.addAttribute("selectedTipo", "MensPhysique");
        return "treino";
    }

    @RequestMapping(value = "/trainClassicPhysique", method = RequestMethod.GET)
    public String treinoCP(Model model) {
        treinoService.getCP().getTrainClassicPhysique(); // carrega o treino correto
        List<Exercicios> lista = treinoService.getTreinoDoDia(); // treino do dia
        if (lista == null) {
            lista = Collections.emptyList();
        } else {
            lista.removeIf(Objects::isNull);
        }
        rotineExercise(model, lista);
        String tipoTreino = treinoService.trainingDescriptionFor("ClassicPhysique");
        model.addAttribute("descricaoTreino", tipoTreino);
        model.addAttribute("selectedTipo", "ClassicPhysique");
        return "treino";
    }

    @RequestMapping(value = "/trainopenPhysique", method = RequestMethod.GET)
    public String treinoOP(Model model) {
        treinoService.getOP().initializeTrainOpen(); // carrega o treino correto
        List<Exercicios> lista = treinoService.getTreinoDoDia(); // treino do dia
        if (lista == null) {
            lista = Collections.emptyList();
        } else {
            lista.removeIf(Objects::isNull);
        }
        rotineExercise(model, lista);
        String tipoTreino = treinoService.trainingDescriptionFor("OpenPhysique");
        model.addAttribute("descricaoTreino", tipoTreino);
        model.addAttribute("selectedTipo", "Open");
        return "treino";
    }

    @RequestMapping(value = "/trainNaturalPhysique", method = RequestMethod.GET)
    public String treinoNP(Model model) {
       treinoService.getNP().initializeTrainNaturalPhysique();
        List<Exercicios> lista = treinoService.getTreinoDoDia(); // treino do dia
        if (lista == null) {
            lista = Collections.emptyList();
        } else {
            lista.removeIf(Objects::isNull);
        }
        rotineExercise(model, lista);
       
        String tipoTreino = treinoService.trainingDescriptionFor("NaturalPhysique");
        model.addAttribute("descricaoTreino", tipoTreino);
        model.addAttribute("selectedTipo", "Natural");
        return "treino";
    }

   

    public void rotineExercise(Model model, List<Exercicios> lista) {
            String diaNome = treinoService.getDiaNome(); 
            String descricao = treinoService.getDescricaoDoDia();
          

            model.addAttribute("treinos", lista);
            model.addAttribute("diaNome", diaNome);
            model.addAttribute("descricaoDia", descricao);
        }
}