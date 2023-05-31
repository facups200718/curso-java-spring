package com.platzi.market.mapper;

import com.platzi.market.dto.PurchaseDTO;
import com.platzi.market.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring", uses = { PurchaseMapper.class })
public interface PurchaseMapper {
    @Mapping(source = "purchaseId", target = "purchaseId")
    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "dateTime", target = "date")
    @Mapping(source = "paymentMethod", target = "paymentMethod")
    @Mapping(source = "observations", target = "comment")
    @Mapping(source = "state", target = "state")
    @Mapping(source = "products", target = "items")
    PurchaseDTO toDTO(PurchaseEntity purchaseEntity);
    List<PurchaseDTO> toDTOs(List<PurchaseEntity> purchaseEntityList);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    PurchaseEntity toEntity(PurchaseDTO purchaseDTO);
}
