package com.platzi.market.mapper;

import com.platzi.market.dto.CategoryDTO;
import com.platzi.market.entity.CategoryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-01T01:11:06-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO toCategoryDTO(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategoryId( categoryEntity.getCategoryId() );
        categoryDTO.setCategory( categoryEntity.getDescription() );
        categoryDTO.setActive( categoryEntity.getState() );

        return categoryDTO;
    }

    @Override
    public CategoryEntity toCategoryEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategoryId( categoryDTO.getCategoryId() );
        categoryEntity.setDescription( categoryDTO.getCategory() );
        categoryEntity.setState( categoryDTO.getActive() );

        return categoryEntity;
    }
}
