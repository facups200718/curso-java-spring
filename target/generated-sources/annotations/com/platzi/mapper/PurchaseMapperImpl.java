package com.platzi.mapper;

import com.platzi.dto.PurchaseDTO;
import com.platzi.dto.PurchaseItemDTO;
import com.platzi.entity.ProductPurchaseEntity;
import com.platzi.entity.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T18:26:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Override
    public PurchaseDTO toDTO(PurchaseEntity purchaseEntity) {
        if ( purchaseEntity == null ) {
            return null;
        }

        PurchaseDTO purchaseDTO = new PurchaseDTO();

        purchaseDTO.setPurchaseId( purchaseEntity.getPurchaseId() );
        purchaseDTO.setClientId( purchaseEntity.getClientId() );
        purchaseDTO.setDate( purchaseEntity.getDateTime() );
        purchaseDTO.setPaymentMethod( purchaseEntity.getPaymentMethod() );
        purchaseDTO.setComment( purchaseEntity.getObservations() );
        purchaseDTO.setState( purchaseEntity.getState() );
        purchaseDTO.setItems( productPurchaseEntityListToPurchaseItemDTOList( purchaseEntity.getProducts() ) );

        return purchaseDTO;
    }

    @Override
    public List<PurchaseDTO> toDTOs(List<PurchaseEntity> purchaseEntityList) {
        if ( purchaseEntityList == null ) {
            return null;
        }

        List<PurchaseDTO> list = new ArrayList<PurchaseDTO>( purchaseEntityList.size() );
        for ( PurchaseEntity purchaseEntity : purchaseEntityList ) {
            list.add( toDTO( purchaseEntity ) );
        }

        return list;
    }

    @Override
    public PurchaseEntity toEntity(PurchaseDTO purchaseDTO) {
        if ( purchaseDTO == null ) {
            return null;
        }

        PurchaseEntity purchaseEntity = new PurchaseEntity();

        purchaseEntity.setPurchaseId( purchaseDTO.getPurchaseId() );
        purchaseEntity.setClientId( purchaseDTO.getClientId() );
        purchaseEntity.setDateTime( purchaseDTO.getDate() );
        purchaseEntity.setPaymentMethod( purchaseDTO.getPaymentMethod() );
        purchaseEntity.setObservations( purchaseDTO.getComment() );
        purchaseEntity.setState( purchaseDTO.getState() );
        purchaseEntity.setProducts( purchaseItemDTOListToProductPurchaseEntityList( purchaseDTO.getItems() ) );

        return purchaseEntity;
    }

    protected PurchaseItemDTO productPurchaseEntityToPurchaseItemDTO(ProductPurchaseEntity productPurchaseEntity) {
        if ( productPurchaseEntity == null ) {
            return null;
        }

        PurchaseItemDTO purchaseItemDTO = new PurchaseItemDTO();

        purchaseItemDTO.setTotal( productPurchaseEntity.getTotal() );

        return purchaseItemDTO;
    }

    protected List<PurchaseItemDTO> productPurchaseEntityListToPurchaseItemDTOList(List<ProductPurchaseEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItemDTO> list1 = new ArrayList<PurchaseItemDTO>( list.size() );
        for ( ProductPurchaseEntity productPurchaseEntity : list ) {
            list1.add( productPurchaseEntityToPurchaseItemDTO( productPurchaseEntity ) );
        }

        return list1;
    }

    protected ProductPurchaseEntity purchaseItemDTOToProductPurchaseEntity(PurchaseItemDTO purchaseItemDTO) {
        if ( purchaseItemDTO == null ) {
            return null;
        }

        ProductPurchaseEntity productPurchaseEntity = new ProductPurchaseEntity();

        productPurchaseEntity.setTotal( purchaseItemDTO.getTotal() );

        return productPurchaseEntity;
    }

    protected List<ProductPurchaseEntity> purchaseItemDTOListToProductPurchaseEntityList(List<PurchaseItemDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductPurchaseEntity> list1 = new ArrayList<ProductPurchaseEntity>( list.size() );
        for ( PurchaseItemDTO purchaseItemDTO : list ) {
            list1.add( purchaseItemDTOToProductPurchaseEntity( purchaseItemDTO ) );
        }

        return list1;
    }
}
