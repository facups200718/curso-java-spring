package com.platzi.market.mapper;

import com.platzi.market.dto.CategoryDTO;
import com.platzi.market.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * <p>Esta interfaz es un Mapper para pasar {@link CategoryDTO} a {@link CategoryEntity} y viceversa</p>
 * @author Facundo Pérez Schneider
 * @since 1.0.0
 * @version 18/06/2023
 * @see com.platzi.market.dto.CategoryDTO
 * @see com.platzi.market.entity.CategoryEntity
 * */
//Indicamos que los @Component que se consumen para crear el Mapper son los del Spring framework.
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    /**
     * Método del mapper que pasa de {@link CategoryEntity} a {@link CategoryDTO}
     * @param categoryEntity Objeto de tipo {@link CategoryEntity} que queremos pasar a {@link CategoryDTO}
     * @return El objeto {@link CategoryDTO}
     * */
    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "description", target = "category")
    @Mapping(source = "state", target = "active")
    CategoryDTO toCategoryDTO(CategoryEntity categoryEntity);

    /**
     * Método del mapper que pasa de {@link CategoryDTO} a {@link CategoryEntity}
     * @param categoryDTO Objeto de tipo {@link CategoryDTO} que queremos pasar a {@link CategoryEntity}
     * @return El objeto {@link CategoryEntity}
     * */
    //Hereda el mapeo de arriba y lo invierte
    @InheritInverseConfiguration
    //Con esto estamos diciendo que no queremos aplicar mapeos para la lista de productos en CategoryEntity
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCategoryEntity(CategoryDTO categoryDTO);
}
