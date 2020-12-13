package com.cloud.taco.project.controllers;

import com.cloud.taco.project.services.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Basic index Controller
 * @author Michał Urbański
 */

@Controller
@RequestMapping({"/","/index"})
public class IngredientsController {

    private final IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }



    @GetMapping
    public String getIndex(Model model) {

        model.addAttribute("ingredients",ingredientService.findAll());

        return "ingredients/index";
    }
}
