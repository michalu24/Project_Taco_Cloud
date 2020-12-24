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
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @Column(name = "ingredient_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ingredient_name")
    private String name;

    private Type type;
}
