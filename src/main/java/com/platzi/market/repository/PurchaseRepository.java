package com.platzi.market.repository;

import com.platzi.market.dto.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseDTO> getAll();
    Optional<List<PurchaseDTO>> getByClient(String clientId);
    PurchaseDTO save(PurchaseDTO purchaseDTO);
}

