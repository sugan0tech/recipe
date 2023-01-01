package com.recipe.project.recipe.services;

import com.recipe.project.recipe.models.Recipe;
import com.recipe.project.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeServiceImpl;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeServiceImpl = new RecipeServiceImpl(recipeRepository, recipeToRecipeCommand, recipeCommandToRecipe);
    }
    @Test
    void getRecipes(){
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe = new Recipe();
        recipes.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipes);
        assertEquals(1, recipeServiceImpl.getRecipes().size());
        verify(recipeRepository).findAll();
//        verify(recipeRepository, times(2)).findAll();  for n times of calls
    }

    @Test
    void getRecipeById() {
        Recipe recipe = new Recipe();
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));
        assertEquals(recipe, recipeServiceImpl.getRecipeById(1L));
        verify(recipeRepository, times(1)).findById(anyLong());
    }


}