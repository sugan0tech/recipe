package com.recipe.project.recipe.controller;

import com.recipe.project.recipe.repositories.CategoryRepository;
import com.recipe.project.recipe.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


class IndexControllerTest {
    CategoryRepository categoryRepository ;
    UnitOfMeasureRepository unitOfMeasureRepository;
    @Mock
    Model model;
    IndexController indexController;
    @Before
    public void setUp() throws Exception {
        indexController = new IndexController(categoryRepository, unitOfMeasureRepository);
    }
}