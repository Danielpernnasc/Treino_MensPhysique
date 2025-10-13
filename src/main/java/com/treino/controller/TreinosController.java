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

   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String treino(Model model) {
        List<Exercicios> lista = treinoService.getTreinoDoDia();
        if(lista == null){
            lista = Collections.emptyList();
        }else {
            lista.removeIf(Objects::isNull);
        }
        // System.out.println("Debug - treinosDoDia size=" + lista.size());
        // lista.forEach(t-> System.out.println("Debug - Exercicios: " + t.getNome()));
        String diaNome = treinoService.getDiaNome(); // ou crie getter público em service
        String descricao = treinoService.getDescricaoDoDia();
    
        model.addAttribute("treinos", lista);
        model.addAttribute("diaNome", diaNome);
        model.addAttribute("descricaoDia", descricao);
        return "treino";
    
    }
}