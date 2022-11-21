package com.recipe.project.recipe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CategoryTest {

    Category category;

    @BeforeEach
    public void SetUp(){
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 4l;
        category.setId(idValue);
        assertEquals(4l, category.getId());
    }

    @Test
    void getDescription() {
        String description = "test_description";
        category.setDescription(description);
        assertEquals(description, category.getDescription());
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe);
        category.setRecipes(recipeSet);
        assertEquals(recipeSet, category.getRecipes());
    }
}