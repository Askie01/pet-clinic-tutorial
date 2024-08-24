package com.askie01.petclinic.controller;

import com.askie01.petclinic.service.OwnerService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("owners")
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("find")
    public String findOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }
}
