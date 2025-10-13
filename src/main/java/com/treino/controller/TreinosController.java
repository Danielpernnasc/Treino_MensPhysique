package com.treino.controller;

// import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treino.model.Exercicios;
import com.treino.service.TreinoService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TreinosController {
    private final TreinoService treinoService;

    @Autowired
    public TreinosController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    // @RequestMapping("/")
    // public String treinoDoDia(Model model) {
    //     List<Exercicios> treinosDoDia = treinoService.getTreinoDoDia();
    //     if (treinosDoDia == null) {
    //         treinosDoDia = Collections.emptyList();
    //     }
    //     model.addAttribute("treinos", treinosDoDia);
    //     return "treino";
    // }
     @GetMapping("/api/treino")
    public List<Exercicios> treinoDoDia() {
        return treinoService.getTreinoDoDia();
    }
    
}