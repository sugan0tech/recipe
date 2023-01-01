package com.recipe.project.recipe.commands;

import com.recipe.project.recipe.models.Category;
import com.recipe.project.recipe.models.Difficulty;
import com.recipe.project.recipe.models.Ingredient;
import com.recipe.project.recipe.models.Notes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommands {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Set<Ingredient> ingredients = new HashSet<>();
    private  Set<Category> categories = new HashSet<>();
    private Notes notes;
}
