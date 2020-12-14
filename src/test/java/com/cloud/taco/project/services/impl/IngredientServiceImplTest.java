package com.cloud.taco.project.services.impl;

import com.cloud.taco.project.domain.Ingredient;
import com.cloud.taco.project.domain.Type;
import com.cloud.taco.project.repositories.IngredientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IngredientServiceImplTest {

    @Mock
    IngredientRepository ingredientRepository;

    @InjectMocks
    IngredientServiceImpl ingredientService;

    Ingredient ingredient1;
    Ingredient ingredient2;

    Set<Ingredient> ingredientSet = new LinkedHashSet<>();

    @BeforeEach
    void setUp() {
        ingredient1 = Ingredient.builder()
                .id(1L)
                .name("Ketchup")
                .type(Type.SAUCE)
                .build();

        ingredientSet.add(ingredient1);

        ingredient2 = Ingredient.builder()
                .id(2L)
                .name("Meat")
                .type(Type.PROTEIN)
                .build();

        ingredientSet.add(ingredient2);
    }

    @Test
    void shouldSaveIngredient() {
        //given
        when(ingredientRepository.save(any())).thenReturn(ingredient1);
        //when
        Ingredient saveIng = ingredient1;
        //then
        assertThat(ingredientService.save(saveIng), equalTo(ingredient1));

    }

    @Test
    void shouldFindAllIngredients() {
        //given
        when(ingredientRepository.findAll()).thenReturn(ingredientSet);
        //when
        Set<Ingredient> ingredients = ingredientService.findAll();
        //then
        assertThat(ingredients,allOf(
                notNullValue(),
                hasSize(2)

        ));
    }

    @Test
    void shouldFindIngredientById() {
        //given
        when(ingredientRepository.findById(anyLong())).thenReturn(Optional.of(ingredient1));
        //when
        Ingredient ingredient = ingredientService.findById(1L);
        //then
        assertThat(ingredient,allOf(
                notNullValue(),
                equalTo(ingredient1)
        ));
    }

    @Test
    void shouldDeleteIngredient() {
        //given
        //when
        ingredientService.delete(ingredient1);
        //then
        verify(ingredientRepository,times(1)).delete(ingredient1);
    }

    @Test
    void shouldDeleteIngredientById() {
        //given
        //when
        ingredientService.deleteById(1L);
        //then
        verify(ingredientRepository,times(1)).deleteById(1L);

    }

    @Test
    void shouldUpdateIngredient() {
        //given
        //when
        ingredientService.update(ingredient1);
        //then
        verify(ingredientRepository, times(1)).save(ingredient1);
    }
}