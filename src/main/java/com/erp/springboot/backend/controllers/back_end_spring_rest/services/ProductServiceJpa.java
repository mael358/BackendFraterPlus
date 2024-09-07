package com.erp.springboot.backend.controllers.back_end_spring_rest.services;

import com.erp.springboot.backend.controllers.back_end_spring_rest.entities.Product;
import com.erp.springboot.backend.controllers.back_end_spring_rest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceJpa implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceJpa(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> delete(Product product) {
        Optional<Product> productOptional = findById(product.getId());
        productOptional.ifPresent(productRepository::delete);
        return productOptional;
    }

}
