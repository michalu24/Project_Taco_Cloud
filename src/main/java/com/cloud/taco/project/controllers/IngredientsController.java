package com.cloud.taco.project.controllers;

import com.cloud.taco.project.domain.Result;
import com.cloud.taco.project.domain.Taco;
import com.cloud.taco.project.domain.Type;
import com.cloud.taco.project.services.IngredientService;
import com.cloud.taco.project.services.TacoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping({"/","/index"})
public class IngredientsController {


    @Autowired
    private Result result;


    private final IngredientService ingredientService;

    private final TacoService tacoService;


    public IngredientsController(IngredientService ingredientService, TacoService tacoService) {
        this.ingredientService = ingredientService;
        this.tacoService = tacoService;
    }


    @ModelAttribute
    public void init(Model model) {
        model.addAttribute("wraps",ingredientService.findAllByType(Type.WRAP));
        model.addAttribute("proteins",ingredientService.findAllByType(Type.PROTEIN));
        model.addAttribute("veggies",ingredientService.findAllByType(Type.VEGGIES));
        model.addAttribute("cheeses",ingredientService.findAllByType(Type.CHEESE));
        model.addAttribute("sauces",ingredientService.findAllByType(Type.SAUCE));

        model.addAttribute("taco", new Taco());
    }

    @GetMapping
    public String getIndex(Model model) {

        System.out.println(result);
        return "ingredients/index";
    }
    //TODO Try stuff with radio buttons to create single group req. attribute name in html 09.01.2021
    @PostMapping("/create")
    public String createTaco(@Valid @ModelAttribute("taco") Taco taco, Errors errors) {
        if (errors.hasErrors()) {
            return "ingredients/index";
        }
        log.debug("Taco created...");

        tacoService.save(taco);
        result.getTacos().add(taco);

        System.out.println(taco.toString());
        System.out.println(result.getTacos().toString());

        return "redirect:/confirm";
    }

    @GetMapping("/confirm")
    public String confirmStatus() {
        return "ingredients/confirm";
    }
}
