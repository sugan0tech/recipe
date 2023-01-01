package com.recipe.project.recipe.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.recipe.project.recipe.commands.CategoryCommands;
import com.recipe.project.recipe.models.Category;

public class CategoryCommandToCategory implements Converter<CategoryCommands, Category> {
    @Override
    public Category convert(CategoryCommands source) {
        if(source == null)
            return null;
        Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
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
