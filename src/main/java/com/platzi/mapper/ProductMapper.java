package com.platzi.mapper;

import com.platzi.dto.ProductDTO;
import com.platzi.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

//Con componentModel estamos indicando que este component es de los que se usan con el framework Spring
//Hay que poner "uses = { CategoryMapper.class }" para el mapeo automático de los Objetos de nombre "category"
@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    ProductDTO toProductDTO(ProductEntity productEntity);
    List<ProductDTO> toProductDTOS(List<ProductEntity> productEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "barcode", ignore = true),
            @Mapping(target = "purchases", ignore = true)
    })
    ProductEntity toProductEntity(ProductDTO productDTO);
    List<ProductEntity> toProductEntities(List<ProductDTO> productDTOS);
}