package com.cloud.taco.project.repositories;

import com.cloud.taco.project.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Ingredient repository interface
 */

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
}
