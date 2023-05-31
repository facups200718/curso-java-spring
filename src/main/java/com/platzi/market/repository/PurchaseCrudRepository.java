package com.platzi.market.repository;

import com.platzi.market.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {
    Optional<List<PurchaseEntity>> findByClientId(String clientId);
}
