package com.recipe.project.recipe.repositories;

import com.recipe.project.recipe.models.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryTest {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Timeout(value = 240, unit = TimeUnit.MILLISECONDS)
    void findByDescription() {
        unitOfMeasureRepository.save(new UnitOfMeasure("Teaspoon"));
        Optional<UnitOfMeasure> unitOfMeasures = unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", unitOfMeasures.get().getDescription());
    }
}