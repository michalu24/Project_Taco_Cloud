package com.cloud.taco.project.controllers;

import com.cloud.taco.project.domain.Taco;
import com.cloud.taco.project.domain.Type;
import com.cloud.taco.project.services.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Basic index Controller
 * @author Michał Urbański
 */
@Slf4j
@Controller
@RequestMapping({"/","/index",""})
public class IngredientsController {

    private final IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @ModelAttribute
    public void init(Model model) {
        model.addAttribute("wraps",ingredientService.findAllByType(Type.WRAP));
        model.addAttribute("proteins",ingredientService.findAllByType(Type.PROTEIN));
        model.addAttribute("veggies",ingredientService.findAllByType(Type.VEGGIES));
        model.addAttribute("cheeses",ingredientService.findAllByType(Type.CHEESE));
        model.addAttribute("sauces",ingredientService.findAllByType(Type.SAUCE));
    }

    @GetMapping
    public String getIndex(Model model) {

        model.addAttribute("taco",new Taco()); // Koniecznie w Getie trzeba przekazać nowy obiekt aby działało

        return "ingredients/index";
    }

    @PostMapping
    public String createTaco(@Valid @ModelAttribute("taco") Taco taco, Errors errors) {
        if (errors.hasErrors()) {
            return "ingredients/index";
        }
        log.debug("Taco created...");
        System.out.println(taco.toString());
        return "redirect:/order";
    }
}
