package com.cloud.taco.project.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Component
@Entity
@Table(name = "tacos")
public class Taco {
    @Id
    @Column(name = "taco_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5,message = "Pole imie musi mieć przynajmniej 5 znaków")
    private String name;

    @NotEmpty(message = "Musisz wybrać przynajmniej jeden składnik")
    @ManyToMany(targetEntity = Ingredient.class)
    private Set<Ingredient> ingredients;

}
