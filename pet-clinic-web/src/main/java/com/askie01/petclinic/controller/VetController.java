package com.askie01.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vet")
public class VetController {

    @GetMapping("getIndex")
    public String getIndex() {
        return "vet/index";
    }
}
