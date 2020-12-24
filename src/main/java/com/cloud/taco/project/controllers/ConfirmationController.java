package com.cloud.taco.project.controllers;

import com.cloud.taco.project.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfirmationController {
    @Autowired
    private Result result;



    @GetMapping("/confirmation/index")
    public String getConfirmation(Model model) {
        model.addAttribute("result", result);
        return "confirmation/index";
    }
}
