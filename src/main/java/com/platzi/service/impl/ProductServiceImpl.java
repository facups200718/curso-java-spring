package com.platzi.service.impl;

import com.platzi.entity.ProductEntity;
import com.platzi.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl {
    private ProductRepository productRepository;
    public List<ProductEntity> getAll() {
        return (List<ProductEntity>) productRepository.findAll();
    }
    public List<ProductEntity> getByCategoryId(Integer categoryId) {
        return productRepository.findByCategoryIdOrderByNameAsc(categoryId);
    }
    public Optional<List<ProductEntity>> getByStockAndState(Integer stock, Boolean state) {
        return productRepository.findByStockLessThanAndState(stock, state);
    }

    public Optional<ProductEntity> getById(Integer productId) {
        return productRepository.findById(productId);
    }

    public ProductEntity save(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public void delete(Integer productId) {
        productRepository.deleteById(productId);
    }
}
