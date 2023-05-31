package com.platzi.market.mapper;

import com.platzi.market.dto.CategoryDTO;
import com.platzi.market.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//Con componentModel estamos indicando que este component es de los que se usan con el framework Spring
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "description", target = "category")
    @Mapping(source = "state", target = "active")
    CategoryDTO toCategoryDTO(CategoryEntity categoryEntity);

    //Hereda el mapeo de arriba y lo invierte
    @InheritInverseConfiguration
    //Con esto estamos diciendo que no queremos aplicar mapeos para la lista de productos en CategoryEntity
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCategoryEntity(CategoryDTO categoryDTO);
}
