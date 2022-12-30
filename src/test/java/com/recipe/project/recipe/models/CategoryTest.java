package com.recipe.project.recipe.models;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
class CategoryTest {

    Category category;

    @BeforeEach
    public void SetUp(){
        log.info("before each");
        category = new Category();
    }

    @AfterEach
    public void ping(){
        log.info("Done");
    }
    @AfterAll
    public static void te(){
        log.info("last");
    }

    @Test
    @Timeout(value = 10000, unit =  TimeUnit.MICROSECONDS)
    void getId() {
        Long idValue = 4l;
        category.setId(idValue);
        assertEquals(4l, category.getId());
    }

    @Test
    void getDescription() {
        String description = "test_description";
        category.setDescription(description);
        assertEquals(description, category.getDescription());
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe);
        category.setRecipes(recipeSet);
        assertEquals(recipeSet, category.getRecipes());
    }
}