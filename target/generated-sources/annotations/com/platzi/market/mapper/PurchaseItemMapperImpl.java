package com.platzi.market.mapper;

import com.platzi.market.dto.PurchaseItemDTO;
import com.platzi.market.entity.ProductPurchaseEntity;
import com.platzi.market.entity.ProductPurchasePK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-01T00:07:41-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public PurchaseItemDTO toDTO(ProductPurchaseEntity productPurchaseEntity) {
        if ( productPurchaseEntity == null ) {
            return null;
        }

        PurchaseItemDTO purchaseItemDTO = new PurchaseItemDTO();

        purchaseItemDTO.setProductId( productPurchaseEntityIdProductId( productPurchaseEntity ) );
        purchaseItemDTO.setQuantity( productPurchaseEntity.getAmount() );
        purchaseItemDTO.setTotal( productPurchaseEntity.getTotal() );
        purchaseItemDTO.setActive( productPurchaseEntity.getState() );

        return purchaseItemDTO;
    }

    @Override
    public ProductPurchaseEntity toEntity(PurchaseItemDTO purchaseItemDTO) {
        if ( purchaseItemDTO == null ) {
            return null;
        }

        ProductPurchaseEntity productPurchaseEntity = new ProductPurchaseEntity();

        productPurchaseEntity.setId( purchaseItemDTOToProductPurchasePK( purchaseItemDTO ) );
        productPurchaseEntity.setAmount( purchaseItemDTO.getQuantity() );
        productPurchaseEntity.setTotal( purchaseItemDTO.getTotal() );
        productPurchaseEntity.setState( purchaseItemDTO.getActive() );

        return productPurchaseEntity;
    }

    private Integer productPurchaseEntityIdProductId(ProductPurchaseEntity productPurchaseEntity) {
        if ( productPurchaseEntity == null ) {
            return null;
        }
        ProductPurchasePK id = productPurchaseEntity.getId();
        if ( id == null ) {
            return null;
        }
        Integer productId = id.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    protected ProductPurchasePK purchaseItemDTOToProductPurchasePK(PurchaseItemDTO purchaseItemDTO) {
        if ( purchaseItemDTO == null ) {
            return null;
        }

        ProductPurchasePK productPurchasePK = new ProductPurchasePK();

        productPurchasePK.setProductId( purchaseItemDTO.getProductId() );

        return productPurchasePK;
    }
}
