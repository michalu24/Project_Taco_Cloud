package com.cloud.taco.project.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Component
public class Taco {

    @NotNull
    @Size(min = 5,message = "Pole imie musi mieć przynajmniej 5 znaków")
    private String name;

    @NotEmpty(message = "Musisz wybrać przynajmniej jeden składnik")
    private Set<Ingredient> ingredients;
}
