package com.platzi.service;

import com.platzi.dto.ProductDTO;
import com.platzi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDTO> getProduct(Integer productId) {
        return productRepository.getById(productId);
    }

    public Optional<List<ProductDTO>> getByCategoryId(Integer categoryId) {
        return productRepository.getByCategoryId(categoryId);
    }

    public ProductDTO save(ProductDTO productDTO) {
        return productRepository.save(productDTO);
    }

    public Boolean delete(Integer productId) {
        /*
        îf (getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
        */
        return getProduct(productId).map(productDTO -> {
            productRepository.delete(productId);
            return Boolean.TRUE;
        }).orElse(Boolean.FALSE);
    }
}
