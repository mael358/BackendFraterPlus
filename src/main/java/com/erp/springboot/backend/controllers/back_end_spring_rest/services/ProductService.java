package com.erp.springboot.backend.controllers.back_end_spring_rest.services;

import com.erp.springboot.backend.controllers.back_end_spring_rest.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Optional<Product> delete(Product product);

}
