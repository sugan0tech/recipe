package com.recipe.project.recipe.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.recipe.project.recipe.commands.RecipeCommands;
import com.recipe.project.recipe.models.Recipe;

public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommands> {
    @Override
    public RecipeCommands convert(Recipe source) {
        if(source == null)
            return null;
        RecipeCommands recipeCommands = new RecipeCommands();
        recipeCommands.setId(source.getId());
        recipeCommands.setDescription(source.getDescription());
        recipeCommands.setPrepTime(source.getPrepTime());
        recipeCommands.setCookTime(source.getCookTime());
        recipeCommands.setServings(source.getServings());
        recipeCommands.setSource(source.getSource());
        recipeCommands.setUrl(source.getUrl());
        recipeCommands.setDirections(source.getDirections());
        recipeCommands.setDifficulty(source.getDifficulty());
        recipeCommands.setIngredients(source.getIngredients());
        recipeCommands.setCategories(source.getCategories());
        recipeCommands.setNotes(source.getNotes());
        return recipeCommands;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
