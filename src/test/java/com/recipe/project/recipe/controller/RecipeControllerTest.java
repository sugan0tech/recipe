package com.recipe.project.recipe.controller;

import com.recipe.project.recipe.models.Recipe;
import com.recipe.project.recipe.repositories.CategoryRepository;
import com.recipe.project.recipe.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeControllerTest {
    @Mock
    RecipeService recipeService;

    @Mock
    CategoryRepository categoryRepository;

    RecipeController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new RecipeController(recipeService, categoryRepository);
    }

    @Test
    @Timeout(value = 900, unit = TimeUnit.MILLISECONDS)
    void showById() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeService.getRecipeById(1L)).thenReturn(recipe);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(get("/recipe/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    @Timeout(value = 1000, unit =  TimeUnit.MILLISECONDS)
    void newRecipe() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(get("/recipe/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"))
                .andExpect(model().attributeExists("categories"));
    }
}