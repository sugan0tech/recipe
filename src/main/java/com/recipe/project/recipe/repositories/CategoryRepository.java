package com.recipe.project.recipe.repositories;

import com.recipe.project.recipe.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
