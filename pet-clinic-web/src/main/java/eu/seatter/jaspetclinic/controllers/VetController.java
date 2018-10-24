package eu.seatter.jaspetclinic.controllers;

import eu.seatter.jaspetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index","/vets/index.html","/vets/vets.html"})
    public String listView(Model model) {
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
