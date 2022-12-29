package com.recipe.project.recipe.bootstrap;


import com.recipe.project.recipe.models.*;
import com.recipe.project.recipe.repositories.CategoryRepository;
import com.recipe.project.recipe.repositories.RecipeRepository;
import com.recipe.project.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public BootstrapData(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository,
                         RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category americanCategory = new Category();
        americanCategory.setDescription("America");
        Category italianCategory = new Category();
        italianCategory.setDescription("Italian");
        Category indianCategory = new Category();
        indianCategory.setDescription("Indian");
        Category mexicalCategory = new Category();
        mexicalCategory.setDescription("Mexican");
        Category fastFoodCategory = new Category();
        fastFoodCategory.setDescription("Fast Food");

        categoryRepository.save(americanCategory);
        categoryRepository.save(italianCategory);
        categoryRepository.save(indianCategory);
        categoryRepository.save(mexicalCategory);
        categoryRepository.save(fastFoodCategory);

        UnitOfMeasure cupUOM = new UnitOfMeasure();
        cupUOM.setDescription("Cup");
        UnitOfMeasure teaspoonUOM = new UnitOfMeasure();
        teaspoonUOM.setDescription("Teaspoon");
        UnitOfMeasure pinchUOM = new UnitOfMeasure();
        pinchUOM.setDescription("Pinch");
        UnitOfMeasure tablespoonUOM = new UnitOfMeasure();
        tablespoonUOM.setDescription("Tablespoon");
        UnitOfMeasure ounceUOM = new UnitOfMeasure();
        ounceUOM.setDescription("Ounce");

        unitOfMeasureRepository.save(cupUOM);
        unitOfMeasureRepository.save(teaspoonUOM);
        unitOfMeasureRepository.save(pinchUOM);
        unitOfMeasureRepository.save(tablespoonUOM);
        unitOfMeasureRepository.save(ounceUOM);


        Recipe guacamole = new Recipe();
        guacamole.setDescription("The perfect Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(5);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections("""
                1. Cut the avocado
                2. Mash the avocado flesh
                3. Add the remaining ingredients to taste
                4. Serve immediately
                """
                );
        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("""
                Be careful handling chilis! If using, it's best to wear food-safe gloves.
                If no gloves are available, wash your hands thoroughly after handling, and do not touch your eyes or the area near your eyes for several hours afterwards.
                """);

        guacamole.setNotes(guacamoleNotes);

        guacamole.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), cupUOM));
        guacamole.addIngredient(new Ingredient("salt", new BigDecimal(1), teaspoonUOM));
        guacamole.addIngredient(new Ingredient("fresh lime juice", new BigDecimal(2), ounceUOM));
        guacamole.addIngredient(new Ingredient("black pepper", new BigDecimal(2), teaspoonUOM));

        guacamole.getCategories().add(americanCategory);
        guacamole.getCategories().add(indianCategory);


        recipeRepository.save(guacamole);
        log.info(guacamole.toString());
    }

}
