package com.platzi.repository;

import com.platzi.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryIdOrderByNameAsc(Integer categoryId);
    Optional<List<ProductEntity>> findByStockLessThanAndState(Integer stock, Boolean state);
}
