package com.cloud.taco.project.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@Component
public class Taco {

    private String name;

    private Set<Ingredient> ingredients;
}
