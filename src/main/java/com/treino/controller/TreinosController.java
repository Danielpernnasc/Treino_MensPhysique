package com.treino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("treinos", treinoService.getTreinos());
        return "treino";
    }
}