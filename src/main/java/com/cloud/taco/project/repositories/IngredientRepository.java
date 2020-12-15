package com.cloud.taco.project.repositories;

import com.cloud.taco.project.domain.Ingredient;
import com.cloud.taco.project.domain.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Ingredient repository interface
 */

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
    Set<Ingredient> findAllByType(Type type);
}
