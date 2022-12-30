package com.recipe.project.recipe.controller;

import com.recipe.project.recipe.repositories.CategoryRepository;
import com.recipe.project.recipe.repositories.RecipeRepository;
import com.recipe.project.recipe.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


class IndexControllerTest {

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    CategoryRepository categoryRepository;
    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Mock
    Model model;

    IndexController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        controller = new IndexController(categoryRepository, unitOfMeasureRepository, recipeRepository);

    }

    @Test
    @Timeout(1)
    void getIndexPage() {
        String viewName = controller.getIndexPage();
        assertEquals("index", viewName);
        verify(categoryRepository, times(1)).findByDescription(anyString());
        verify(unitOfMeasureRepository, times(1)).findByDescription(anyString());
    }

    @Test
    void getAll() {
        String viewName = controller.getAll(model);
        assertEquals("all", viewName);
        verify(categoryRepository, times(1)).findAll();
        verify(unitOfMeasureRepository, times(1)).findAll();
        verify(model, times(2)).addAttribute(anyString(), anyIterable());
    }

    @Test
    void getRecipes() {
        String viewName = controller.getRecipes(model);
        assertEquals("recipes", viewName);
        verify(recipeRepository, times(1)).findAll();
        verify(model, times(1)).addAttribute(anyString(), anyIterable());
    }

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void testMockMVCForAll() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/All"))
                .andExpect(status().isOk())
                .andExpect(view().name("all"));

    }

    @Test
    void testMockMVCForRecipes() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/Recipes"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes"));

    }
}