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
public class TreinosController {
    private final TreinoService treinoService;

    @Autowired
    public TreinosController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }



   @RequestMapping(value = "/trainMensPhysique", method = RequestMethod.GET)
    public String treinoMP(Model model) {
        List<Exercicios> lista = treinoService.gettrainMP();
        if (lista == null) {
            lista = Collections.emptyList();
        } else {
            lista.removeIf(Objects::isNull);
        }
        rotineExercise(model, lista);

        // Ensure the method always returns a value
        return "treino";
    }

    @RequestMapping(value = "/trainClassicPhysique", method = RequestMethod.GET)
    public String treinoCP(Model model) {
        List<Exercicios> lista = treinoService.gettrainCP();
        if (lista == null) {
            lista = Collections.emptyList();
        } else {
            lista.removeIf(Objects::isNull);
        }
        rotineExercise(model, lista);

        return "treino";
    }

    @RequestMapping(value = "/trainopenPhysique", method = RequestMethod.GET)
    public String treinoOP(Model model) {
        List<Exercicios> lista = treinoService.gettrainOP();
        if (lista == null) {
            lista = Collections.emptyList();
        } else {
            lista.removeIf(Objects::isNull);
        }
        rotineExercise(model, lista);

        return "treino";
    }

    // @RequestMapping(value = "/NaturalBodybuilding", method = RequestMethod.GET)
    // public String treinoNB(Model model) {
    //     List<Exercicios> lista = treinoService.gettrainNB();
    //     if (lista == null) {
    //         lista = Collections.emptyList();
    //     } else {
    //         lista.removeIf(Objects::isNull);
    //     }
    //     rotineExercise(model, lista);

    //     return "treino";
    // }


    public void rotineExercise(Model model, List<Exercicios> lista) {
            String diaNome = treinoService.getDiaNome(); 
            String descricao = treinoService.getDescricaoDoDia();
        
            model.addAttribute("treinos", lista);
            model.addAttribute("diaNome", diaNome);
            model.addAttribute("descricaoDia", descricao);
        }
}