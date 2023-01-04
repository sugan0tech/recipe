package com.recipe.project.recipe.services;

import com.recipe.project.recipe.commands.RecipeCommands;
import com.recipe.project.recipe.converters.RecipeCommandToRecipe;
import com.recipe.project.recipe.converters.RecipeToRecipeCommand;
import com.recipe.project.recipe.models.Recipe;
import com.recipe.project.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    private final RecipeCommandToRecipe recipeCommandToRecipe;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeToRecipeCommand recipeToRecipeCommand, RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeRepository = recipeRepository;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        return recipeOptional.orElseGet(Recipe::new);
    }

    @Override
    @Transactional
    public RecipeCommands saveRecipeCommand(RecipeCommands recipeCommands) {
        Recipe recipe = recipeCommandToRecipe.convert(recipeCommands);
        Recipe savedRecipe = recipeRepository.save(recipe);
        log.debug("saved Recipie ID :" + savedRecipe.getId()) ;
        return recipeToRecipeCommand.convert(savedRecipe);
    }

}
