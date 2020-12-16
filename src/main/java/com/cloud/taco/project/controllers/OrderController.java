package com.cloud.taco.project.controllers;

import com.cloud.taco.project.domain.Ingredient;
import com.cloud.taco.project.domain.Order;
import com.cloud.taco.project.domain.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {


    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("order", new Order());
        return "order/index";
    }

    @PostMapping("/create")
    public String createTaco(@ModelAttribute("order") Order order) {
        log.debug("Order created...");
        return "redirect:/confirmation/index";
    }
}
