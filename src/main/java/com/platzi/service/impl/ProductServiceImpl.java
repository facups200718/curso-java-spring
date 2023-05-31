package com.platzi.service.impl;

import com.platzi.dto.ProductDTO;
import com.platzi.entity.ProductEntity;
import com.platzi.mapper.ProductMapper;
import com.platzi.repository.ProductRepository;
import com.platzi.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public List<ProductDTO> getAll() {
        List<ProductEntity> productEntityList = (List<ProductEntity>) productRepository.findAll();
        return productMapper.toProductDTOS(productEntityList);
    }
    public Optional<List<ProductDTO>> getByCategoryId(Integer categoryId) {
        List<ProductEntity> productEntityList = productRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toProductDTOS(productEntityList));
    }
    public Optional<List<ProductDTO>> getByStockAndState(Integer stock, Boolean state) {
        Optional<List<ProductEntity>> productEntityList = productRepository.findByStockLessThanAndState(stock, state);
        return productEntityList.map(products -> productMapper.toProductDTOS(products));
    }

    public Optional<ProductDTO> getById(Integer productId) {
        return productRepository.findById(productId).map(product -> productMapper.toProductDTO(product));
    }

    public ProductDTO save(ProductDTO productDTO) {
        ProductEntity productEntity = productRepository.save(productMapper.toProductEntity(productDTO));
        return productMapper.toProductDTO(productEntity);
    }

    public void delete(Integer productId) {
        productRepository.deleteById(productId);
    }
}
