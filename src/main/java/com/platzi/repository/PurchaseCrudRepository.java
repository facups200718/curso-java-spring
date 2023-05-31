package com.platzi.repository;

import com.platzi.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {
    Optional<List<PurchaseEntity>> findByClientId(String clientId);
}
