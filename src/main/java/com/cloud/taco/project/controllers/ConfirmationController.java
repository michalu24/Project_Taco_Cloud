package com.cloud.taco.project.controllers;

import com.cloud.taco.project.domain.Result;
import com.cloud.taco.project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ConfirmationController {
    @Autowired
    private Result result;

    @ModelAttribute
    void init(Model model) {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        User user = (User) authentication.getPrincipal();

        model.addAttribute("user", user);
    }

    @GetMapping("/confirmation/index")
    public String getConfirmation(Model model) {
        model.addAttribute("result", result);
        return "confirmation/index";
    }
}
