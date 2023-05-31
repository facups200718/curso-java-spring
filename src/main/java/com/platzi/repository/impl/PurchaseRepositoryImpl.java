package com.platzi.repository.impl;

import com.platzi.dto.PurchaseDTO;
import com.platzi.entity.PurchaseEntity;
import com.platzi.mapper.PurchaseMapper;
import com.platzi.repository.PurchaseCrudRepository;
import com.platzi.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<PurchaseDTO> getAll() {
        return purchaseMapper.toDTOs((List<PurchaseEntity>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId)
                .map(purchases -> purchaseMapper.toDTOs(purchases));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        PurchaseEntity purchaseEntity = purchaseMapper.toEntity(purchaseDTO);
        purchaseEntity.getProducts().forEach(product -> product.setPurchase(purchaseEntity));
        return purchaseMapper.toDTO(purchaseCrudRepository.save(purchaseEntity));
    }
}
