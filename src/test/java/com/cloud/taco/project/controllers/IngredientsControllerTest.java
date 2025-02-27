package com.cloud.taco.project.controllers;

import com.cloud.taco.project.domain.Ingredient;
import com.cloud.taco.project.domain.Type;
import com.cloud.taco.project.services.impl.IngredientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.LinkedHashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class IngredientsControllerTest {
    @Mock
    IngredientServiceImpl service;

    @Mock
    Model model;

    @InjectMocks
    IngredientsController controller;

    Set<Ingredient> ingredientSet = new LinkedHashSet<>();

    @BeforeEach
    void setUp() {
        Ingredient ingredient = Ingredient.builder()
                .id(1L)
                .name("Bread")
                .type(Type.WRAP)
                .build();
        ingredientSet.add(ingredient);

    }

    @Test
    void shouldReturnIndex() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("wraps", service.findAllByType(Type.WRAP)))
                .andExpect(model().attribute("proteins", service.findAllByType(Type.PROTEIN)))
                .andExpect(model().attribute("veggies", service.findAllByType(Type.VEGGIES)))
                .andExpect(model().attribute("cheeses", service.findAllByType(Type.CHEESE)))
                .andExpect(model().attribute("sauces", service.findAllByType(Type.SAUCE)))
                .andExpect(view().name("ingredients/index"));

    }

    @Test
    void modelShouldBeExecutedOnceForEachAttribute() {

        String viewName = controller.getIndex(model);
        verify(model, times(1)).addAttribute(eq("wraps"),any());
        verify(model, times(1)).addAttribute(eq("proteins"),any());
        verify(model, times(1)).addAttribute(eq("veggies"),any());
        verify(model, times(1)).addAttribute(eq("cheeses"),any());
        verify(model, times(1)).addAttribute(eq("sauces"),any());
    }
}