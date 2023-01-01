package com.recipe.project.recipe.services;

import com.recipe.project.recipe.commands.RecipeCommands;
import com.recipe.project.recipe.models.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe getRecipeById(Long id);
    RecipeCommands saveRecipeCommand(RecipeCommands recipeCommands);
}
