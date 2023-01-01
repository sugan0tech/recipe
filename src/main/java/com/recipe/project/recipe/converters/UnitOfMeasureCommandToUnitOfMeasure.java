package com.recipe.project.recipe.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.recipe.project.recipe.commands.UnitOfMeasureCommands;
import com.recipe.project.recipe.models.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.lang.Nullable;

public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommands, UnitOfMeasure> {
    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommands source) {
        if(source == null)
            return null;

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
