package com.platzi.repository;
import com.platzi.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategoryId(Integer categoryId);
    Optional<List<ProductDTO>> getByStockAndState(Integer stock, Boolean state);
    Optional<ProductDTO> getById(Integer productId);
    ProductDTO save(ProductDTO product);
    void delete(Integer productId);
}
