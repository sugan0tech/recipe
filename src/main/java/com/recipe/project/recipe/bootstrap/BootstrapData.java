package com.recipe.project.recipe.bootstrap;


import com.recipe.project.recipe.models.Category;
import com.recipe.project.recipe.models.UnitOfMeasure;
import com.recipe.project.recipe.repositories.CategoryRepository;
import com.recipe.project.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapData(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category();
        category1.setDescription("America");
        Category category2 = new Category();
        category2.setDescription("Italian");
        Category category3 = new Category();
        category3.setDescription("Indian");
        Category category4 = new Category();
        category4.setDescription("Mexican");
        Category category5 = new Category();
        category5.setDescription("Fast Food");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);
        categoryRepository.save(category5);

        UnitOfMeasure unitOfMeasure1 = new UnitOfMeasure();
        unitOfMeasure1.setDescription("Cup");
        UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
        unitOfMeasure2.setDescription("Teaspoon");
        UnitOfMeasure unitOfMeasure3 = new UnitOfMeasure();
        unitOfMeasure3.setDescription("Pinch");
        UnitOfMeasure unitOfMeasure4 = new UnitOfMeasure();
        unitOfMeasure4.setDescription("Tablespoon");
        UnitOfMeasure unitOfMeasure5 = new UnitOfMeasure();
        unitOfMeasure5.setDescription("Ounce");

        unitOfMeasureRepository.save(unitOfMeasure1);
        unitOfMeasureRepository.save(unitOfMeasure2);
        unitOfMeasureRepository.save(unitOfMeasure3);
        unitOfMeasureRepository.save(unitOfMeasure4);
        unitOfMeasureRepository.save(unitOfMeasure5);
    }

}
