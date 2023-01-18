package com.recipe.project.recipe.controller;

import com.recipe.project.recipe.commands.RecipeCommands;
import com.recipe.project.recipe.repositories.CategoryRepository;
import com.recipe.project.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class RecipeController {
    private final CategoryRepository categoryRepository;

    RecipeService recipeService;

    RecipeController(RecipeService recipeService,
                     CategoryRepository categoryRepository){
        this.recipeService = recipeService;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"/recipe/{id}/show"})
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.getRecipeById(Long.parseLong(id)));
        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommands());
        model.addAttribute("categories", categoryRepository.findAll());
        return "recipe/recipeform";
    }
    @PostMapping("recipe")
    public String saveRecipe(@ModelAttribute RecipeCommands command){
        RecipeCommands savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + savedCommand.getId()  + "/show";
    }
}
