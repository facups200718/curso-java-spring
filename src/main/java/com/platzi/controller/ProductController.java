package com.platzi.controller;

import com.platzi.dto.ProductDTO;
import com.platzi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<ProductDTO> getProduct(@PathVariable Integer productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/categories/{categoryId}")
    public Optional<List<ProductDTO>> getByCategoryId(@PathVariable Integer categoryId) {
        return productService.getByCategoryId(categoryId);
    }

    @PostMapping()
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/{productId}")
    public Boolean delete(@PathVariable Integer productId) {
        return productService.delete(productId);
    }
}
