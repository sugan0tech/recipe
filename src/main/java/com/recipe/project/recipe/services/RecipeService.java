package com.recipe.project.recipe.services;

import com.recipe.project.recipe.models.Recipe;

import java.util.Set;

public interface RecipeService {
    public Set<Recipe> getRecipes();
}