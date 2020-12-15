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
        initCheeses();
        initWraps();
        initProtein();
        initVeggies();
        initSauce();
    }

    public void initSauce() {

        Ingredient ingredient1 = Ingredient.builder()
                .name("Pikantny sos pomidorowy")
                .type(Type.SAUCE)
                .build();

        service.save(ingredient1);


        Ingredient ingredient2 = Ingredient.builder()
                .name("Smietana")
                .type(Type.SAUCE)
                .build();

        service.save(ingredient2);
    }

    public void initVeggies() {

        Ingredient ingredient1 = Ingredient.builder()
                .name("Pomidory krojone w kostkę")
                .type(Type.VEGGIES)
                .build();

        service.save(ingredient1);


        Ingredient ingredient2 = Ingredient.builder()
                .name("Sałata")
                .type(Type.VEGGIES)
                .build();

        service.save(ingredient2);
    }

    public void initProtein() {

        Ingredient ingredient1 = Ingredient.builder()
                .name("Mielona wołowina")
                .type(Type.PROTEIN)
                .build();

        service.save(ingredient1);


        Ingredient ingredient2 = Ingredient.builder()
                .name("Kawałki mięsa")
                .type(Type.PROTEIN)
                .build();

        service.save(ingredient2);
    }

    public void initCheeses() {

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


    public void initWraps() {

        Ingredient ingredient1 = Ingredient.builder()
                .name("Pszenna")
                .type(Type.WRAP)
                .build();

        service.save(ingredient1);


        Ingredient ingredient2 = Ingredient.builder()
                .name("Kukurydziana")
                .type(Type.WRAP)
                .build();

        service.save(ingredient2);


    }
}
