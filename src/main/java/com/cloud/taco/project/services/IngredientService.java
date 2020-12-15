package com.cloud.taco.project.services;

import com.cloud.taco.project.domain.Ingredient;
import com.cloud.taco.project.domain.Type;

import java.util.Set;

/**
 * Ingredient Service interface
 * @author Michał Urbański
 */
public interface IngredientService extends CrudService<Ingredient,Long>{
    Set<Ingredient> findAllByType(Type type);
}
