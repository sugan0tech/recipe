package com.recipe.project.recipe.commands;

import com.recipe.project.recipe.models.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommands {
    private Long id;
    private Recipe recipe;
    private String recipeNotes;
}
