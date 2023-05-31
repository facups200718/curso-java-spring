package com.platzi.repository.impl;

import com.platzi.dto.ProductDTO;
import com.platzi.entity.ProductEntity;
import com.platzi.mapper.ProductMapper;
import com.platzi.repository.ProductCrudRepository;
import com.platzi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Por qué creo esto si ya tengo ProductCrudRepository?
//Para reducir el acomplamiento entre la lógica del negocio y la persistencia.
//Si vemos ProductService, podemos notar que ProductService NO sabe que actualmente se está utilizando
//en la capa de persistencia un CrudRepository, y NUNCA va a saber cómo es la capa de persistencia que usamos,
//ni qué métodos ofrece para Java (como el findAll(), el deleteById(), el findById() o los query methods).
//Si cambia la BD, la capa de lógica queda intacta. No es el mejor ejemplo este ya que no hay mucha lógica de negocio.
//Tambien podemos ver que la capa service NUNCA va a saber NADA sobre el objeto de modelo de BD (el Entity), lo cual
//hace a la aplicacion mas segura; tampoco sabe sobre los mappers.
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> getAll() {
        List<ProductEntity> productEntityList = (List<ProductEntity>) productCrudRepository.findAll();
        return productMapper.toDTOs(productEntityList);
    }
    public Optional<List<ProductDTO>> getByCategoryId(Integer categoryId) {
        List<ProductEntity> productEntityList = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toDTOs(productEntityList));
    }
    public Optional<List<ProductDTO>> getByStockAndState(Integer stock, Boolean state) {
        Optional<List<ProductEntity>> productEntityList = productCrudRepository.findByStockLessThanAndState(stock, state);
        return productEntityList.map(products -> productMapper.toDTOs(products));
    }

    public Optional<ProductDTO> getById(Integer productId) {
        return productCrudRepository.findById(productId).map(product -> productMapper.toDTO(product));
    }

    public ProductDTO save(ProductDTO productDTO) {
        ProductEntity productEntity = productCrudRepository.save(productMapper.toEntity(productDTO));
        return productMapper.toDTO(productEntity);
    }

    public void delete(Integer productId) {
        productCrudRepository.deleteById(productId);
    }
}
