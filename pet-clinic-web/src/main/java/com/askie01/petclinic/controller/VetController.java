package com.askie01.petclinic.controller;

import com.askie01.petclinic.service.VetService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Controller
public class VetController {

    private final VetService vetService;

    @GetMapping("vets.html")
    public String getVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vet/vets";
    }
}
