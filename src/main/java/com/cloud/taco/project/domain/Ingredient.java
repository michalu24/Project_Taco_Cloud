package com.cloud.taco.project.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Ingredient class
 * @author Michał Urbański
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ingredient_name")
    private String name;

    private Type type;
}
