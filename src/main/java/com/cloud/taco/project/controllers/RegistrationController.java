package com.cloud.taco.project.controllers;

import com.cloud.taco.project.config.RegistrationForm;
import com.cloud.taco.project.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository repository;
    private PasswordEncoder encoder;

    public RegistrationController(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }
    @GetMapping
    public String registrationForm() {
        return "registration/index";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        repository.save(form.toUser(encoder));
        return "redirect:/login";
    }


}
