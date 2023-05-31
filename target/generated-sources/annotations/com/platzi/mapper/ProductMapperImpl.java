package com.platzi.mapper;

import com.platzi.dto.ProductDTO;
import com.platzi.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T18:26:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ProductDTO toDTO(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId( productEntity.getProductId() );
        productDTO.setName( productEntity.getName() );
        productDTO.setCategoryId( productEntity.getCategoryId() );
        productDTO.setPrice( productEntity.getPrice() );
        productDTO.setStock( productEntity.getStock() );
        productDTO.setActive( productEntity.getState() );
        productDTO.setCategory( categoryMapper.toCategoryDTO( productEntity.getCategory() ) );

        return productDTO;
    }

    @Override
    public List<ProductDTO> toDTOs(List<ProductEntity> productEntities) {
        if ( productEntities == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( productEntities.size() );
        for ( ProductEntity productEntity : productEntities ) {
            list.add( toDTO( productEntity ) );
        }

        return list;
    }

    @Override
    public ProductEntity toEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductId( productDTO.getProductId() );
        productEntity.setName( productDTO.getName() );
        productEntity.setCategoryId( productDTO.getCategoryId() );
        productEntity.setPrice( productDTO.getPrice() );
        productEntity.setStock( productDTO.getStock() );
        productEntity.setState( productDTO.getActive() );
        productEntity.setCategory( categoryMapper.toCategoryEntity( productDTO.getCategory() ) );

        return productEntity;
    }
}
