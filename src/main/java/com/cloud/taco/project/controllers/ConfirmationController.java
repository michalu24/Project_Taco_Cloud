package com.cloud.taco.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfirmationController {


    @GetMapping("/confirmation/index")
    public String getConfirmation() {
        return "confirmation/index";
    }
}
