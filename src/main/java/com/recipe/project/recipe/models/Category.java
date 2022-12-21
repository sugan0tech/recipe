package com.recipe.project.recipe.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Recipe> recipes;
}
