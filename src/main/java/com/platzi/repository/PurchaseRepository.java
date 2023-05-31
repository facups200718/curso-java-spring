package com.platzi.repository;

import com.platzi.dto.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseDTO> getAll();
    Optional<List<PurchaseDTO>> getByClient(String clientId);
    PurchaseDTO save(PurchaseDTO purchaseDTO);
}

