package com.cloud.taco.project.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
/**
 * Ingredient class
 * @author Michał Urbański
 */
@Data
@Builder
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ingredient_name")
    private String name;

    private final Type type;
}
