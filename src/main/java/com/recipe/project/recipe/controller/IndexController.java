package com.recipe.project.recipe.controller;

import com.recipe.project.recipe.models.Category;
import com.recipe.project.recipe.models.UnitOfMeasure;
import com.recipe.project.recipe.repositories.CategoryRepository;
import com.recipe.project.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/home", "/index"})
    public String getIndexPage(){
        log.debug("index page triggred");
        log.info("hi there");
        Optional<Category>  categoryOptional = categoryRepository.findByDescription("America");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Cup");
        System.out.println("cat Id is : " + categoryOptional.get().getId());
        System.out.println("Uom Id is : " + unitOfMeasure.get().getId());
        return "index";
    }
    @RequestMapping("All")
    public String getAll(Model model){
        log.debug("all page triggred");
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("uom", unitOfMeasureRepository.findAll());
        return "all";
    }
}
