package com.recipe.project.recipe.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.recipe.project.recipe.commands.IngredientsCommands;
import com.recipe.project.recipe.models.Ingredient;

public class IngredientCommandToIngredient implements Converter<IngredientsCommands, Ingredient> {
    @Override
    public Ingredient convert(IngredientsCommands source) {
       if(source == null)
            return null;
       Ingredient ingredient = new Ingredient();
       ingredient.setId(source.getId());
       ingredient.setUom(source.getUom());
       ingredient.setRecipe(source.getRecipe());
       ingredient.setDescription(source.getDescription());
       ingredient.setAmount(source.getAmount());
       return ingredient;
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
