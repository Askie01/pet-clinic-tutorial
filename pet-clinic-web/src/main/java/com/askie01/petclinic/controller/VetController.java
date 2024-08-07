package com.askie01.petclinic.controller;

import com.askie01.petclinic.service.VetService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("vet")
public class VetController {

    private final VetService vetService;

    @GetMapping("index")
    public String getIndex(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vet/index";
    }
}
