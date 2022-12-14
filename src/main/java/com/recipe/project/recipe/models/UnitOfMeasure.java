package com.recipe.project.recipe.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public UnitOfMeasure(String description){
        this.description = description;
    }


}