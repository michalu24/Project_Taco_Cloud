package com.cloud.taco.project.services.impl;

import com.cloud.taco.project.domain.Ingredient;
import com.cloud.taco.project.repositories.IngredientRepository;
import com.cloud.taco.project.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Implementation of Ingredient service
 * @author Michał Urbański
 */

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository repository;

    public IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient save(Ingredient object) {
        return repository.save(object);
    }

    @Override
    public Set<Ingredient> findAll() {
        Set<Ingredient> ingredients = new LinkedHashSet<>();
        repository.findAll().iterator().forEachRemaining(ingredients::add);
        return ingredients;
    }

    @Override
    public Ingredient findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Ingredient object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Ingredient object) {
        repository.save(object);
    }
}
