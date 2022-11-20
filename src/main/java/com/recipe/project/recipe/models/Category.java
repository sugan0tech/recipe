package com.recipe.project.recipe.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Category {

    @Id
    private Long id;
    private String description;
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<Recipe> recipes;
}
