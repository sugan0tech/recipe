package com.recipe.project.recipe.controller;

import com.recipe.project.recipe.models.Category;
import com.recipe.project.recipe.models.UnitOfMeasure;
import com.recipe.project.recipe.repositories.CategoryRepository;
import com.recipe.project.recipe.repositories.RecipeRepository;
import com.recipe.project.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.PreUpdate;
import java.util.Optional;

@Slf4j
@Controller
public class IndexController {
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository,
                           RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"", "/", "/home", "/index"})
    public String getIndexPage(){
        log.debug("index page triggred");
        log.info("hi there");
        Optional<Category>  categoryOptional = categoryRepository.findByDescription("America");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");
        categoryOptional.ifPresent(category -> log.info("cat Id is : " + category.getId()));
        unitOfMeasureOptional.ifPresent(unitOfMeasure -> log.info("Uom Id is : " + unitOfMeasure.getId()));
        return "index";
    }
    @RequestMapping("All")
    public String getAll(Model model){
        log.debug("all page triggred");
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("uom", unitOfMeasureRepository.findAll());
        return "all";
    }
    @RequestMapping({"Recipes", "rec"})
    public String getRecipes(Model model){
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes";
    }

}
