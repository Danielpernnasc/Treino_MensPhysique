package com.treino.controller;




import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.treino.model.Treinos;
import com.treino.service.TreinoService;

public class TreinoControllerTest {


    private TreinoController controller;


    @Before
    public void setUp() {
        Treinos.treinos.clear();
        Treinos.descricaoDia.clear();
        Treinos.descricaoTreino.clear();


        TreinoService service = new TreinoService();
        this.controller = new TreinoController(service);
    }

    @Test
    public void home_redirect_para_mensPhysique() {
        String view = controller.home();
        assertEquals("redirect:/trainMensPhysique", view);
    }

    @Test
    public void  trinoeMP_retorna_view_e_povoa_model(){
          Model model = new ExtendedModelMap();

        String view = controller.treinoMP(model);

        assertEquals("treino", view);
        assertTrue(model.containsAttribute("treinos"));
        assertTrue(model.containsAttribute("diaNome"));
        assertTrue(model.containsAttribute("descricaoDia"));
        assertTrue(model.containsAttribute("descricaoTreino"));
        assertEquals("MensPhysique", model.asMap().get("selectedTipo"));
        // título esperado do service
        assertEquals("Mens Physique", model.asMap().get("descricaoTreino"));
    }

    @Test
    public void treinoCP_retorna_view_e_povoa_model() {
        Model model = new ExtendedModelMap();

        String view = controller.treinoCP(model);

        assertEquals("treino", view);
        assertTrue(model.containsAttribute("treinos"));
        assertTrue(model.containsAttribute("diaNome"));
        assertTrue(model.containsAttribute("descricaoDia"));
        assertTrue(model.containsAttribute("descricaoTreino"));
        assertEquals("ClassicPhysique", model.asMap().get("selectedTipo"));
        assertEquals("Classic Physique", model.asMap().get("descricaoTreino"));
    }

    @Test
    public void treinoOP_retorna_view_e_povoa_model() {
        Model model = new ExtendedModelMap();

        String view = controller.treinoOP(model);

        assertEquals("treino", view);
        assertTrue(model.containsAttribute("treinos"));
        assertTrue(model.containsAttribute("diaNome"));
        assertTrue(model.containsAttribute("descricaoDia"));
        assertTrue(model.containsAttribute("descricaoTreino"));
        assertEquals("Open", model.asMap().get("selectedTipo"));
        assertEquals("Open Physique", model.asMap().get("descricaoTreino"));
    }

    @Test
    public void treinoNP_retorna_view_e_povoa_model() {
        Model model = new ExtendedModelMap();

        String view = controller.treinoNP(model);

        assertEquals("treino", view);
        assertTrue(model.containsAttribute("treinos"));
        assertTrue(model.containsAttribute("diaNome"));
        assertTrue(model.containsAttribute("descricaoDia"));
        assertTrue(model.containsAttribute("descricaoTreino"));
        assertEquals("Natural", model.asMap().get("selectedTipo"));
        assertEquals("Natural Physique", model.asMap().get("descricaoTreino"));
    }

}
