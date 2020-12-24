package com.cloud.taco.project.controllers;

import com.cloud.taco.project.domain.Order;
import com.cloud.taco.project.domain.Result;
import com.cloud.taco.project.services.OrderService;
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

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private Result result;

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("order", new Order());
        System.out.println(result);
        return "order/index";
    }

    @PostMapping("/create")
    public String createTaco(@Valid @ModelAttribute("order") Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "order/index";
        }
        log.debug("Order created...");
        order.setTacos(result.getTacos());
        orderService.save(order);
        result.setOrder(order);
        System.out.println(order.toString());
        return "redirect:/confirmation/index";
    }
}