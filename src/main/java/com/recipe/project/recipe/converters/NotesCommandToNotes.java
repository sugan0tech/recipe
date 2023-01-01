package com.recipe.project.recipe.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.recipe.project.recipe.commands.NotesCommands;
import com.recipe.project.recipe.models.Notes;

public class NotesCommandToNotes implements Converter<NotesCommands, Notes> {

    @Override
    public Notes convert(NotesCommands source) {
        if(source == null)
            return null;
        Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipe(source.getRecipe());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
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
