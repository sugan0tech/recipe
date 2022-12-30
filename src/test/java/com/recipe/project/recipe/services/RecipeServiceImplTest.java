package com.recipe.project.recipe.services;

import com.recipe.project.recipe.models.Recipe;
import com.recipe.project.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {
    RecipeServiceImpl recipeServiceImpl;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
    }
    @Test
    void getRecipes(){
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe = new Recipe();
        recipes.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipes);
        assertEquals(1, recipeServiceImpl.getRecipes().size());
        verify(recipeRepository).findAll();
    }


}