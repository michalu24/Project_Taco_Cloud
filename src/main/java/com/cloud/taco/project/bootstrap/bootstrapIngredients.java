package com.cloud.taco.project.bootstrap;

import com.cloud.taco.project.domain.Ingredient;
import com.cloud.taco.project.domain.Type;
import com.cloud.taco.project.services.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Bootstrap class for Ingredient init in DB on run
 * @author Michał Urbański
 */

@Component
@Slf4j
public class bootstrapIngredients implements CommandLineRunner {

    private final IngredientService service;

    public bootstrapIngredients(IngredientService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        initIngredients();
    }

    public void initIngredients() {

        Ingredient ingredient = Ingredient.builder()
                .name("Cheddar")
                .type(Type.CHEESE)
                .build();

        service.save(ingredient);

        Ingredient ingredient2 = Ingredient.builder()
                .name("Parmigioano Reggiano")
                .type(Type.CHEESE)
                .build();

        service.save(ingredient2);

        service.save(ingredient);

        Ingredient ingredient3 = Ingredient.builder()
                .name("Blue Cheese")
                .type(Type.CHEESE)
                .build();

        service.save(ingredient3);
    }
}
