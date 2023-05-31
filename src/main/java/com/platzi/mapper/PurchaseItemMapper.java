package com.platzi.mapper;

import com.platzi.dto.PurchaseItemDTO;
import com.platzi.entity.ProductPurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PurchaseItemMapper {

    @Mapping(source = "id.productId", target = "productId")
    @Mapping(source = "amount", target = "quantity")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "state", target = "active")
    PurchaseItemDTO toDTO(ProductPurchaseEntity productPurchaseEntity);

    @InheritInverseConfiguration
    @Mapping(target = "purchase", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "id.purchaseId", ignore = true)
    ProductPurchaseEntity toEntity(PurchaseItemDTO purchaseItemDTO);
}
