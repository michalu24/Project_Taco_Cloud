package com.cloud.taco.project.controllers;

import com.cloud.taco.project.domain.Type;
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

        model.addAttribute("wraps",ingredientService.findAllByType(Type.WRAP));
        model.addAttribute("proteins",ingredientService.findAllByType(Type.PROTEIN));
        model.addAttribute("veggies",ingredientService.findAllByType(Type.VEGGIES));
        model.addAttribute("cheeses",ingredientService.findAllByType(Type.CHEESE));
        model.addAttribute("sauces",ingredientService.findAllByType(Type.SAUCE));

        return "ingredients/index";
    }
}
