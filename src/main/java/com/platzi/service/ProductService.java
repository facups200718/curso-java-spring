package com.platzi.service;
import com.platzi.dto.ProductDTO;
import com.platzi.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategoryId(Integer categoryId);
    Optional<List<ProductDTO>> getByStockAndState(Integer stock, Boolean state);
    Optional<ProductDTO> getById(Integer productId);
    ProductDTO save(ProductDTO product);
    void delete(Integer productId);
}
