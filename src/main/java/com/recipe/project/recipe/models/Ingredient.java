package com.recipe.project.recipe.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    @OneToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
     private UnitOfMeasure uom;
    @ManyToOne
    @ToString.Exclude
     private Recipe recipe;

    public Ingredient(){

    }
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

}
