package com.askie01.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("owner")
public class OwnerController {

    @GetMapping("index")
    public String getIndex() {
        return "owner/index";
    }
}
