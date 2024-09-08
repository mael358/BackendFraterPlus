package com.erp.springboot.backend.services;


import com.erp.springboot.backend.models.entidades.Articulo;
import com.erp.springboot.backend.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceJpa implements ArticuloService {

    private final ArticuloRepository productRepository;

    @Autowired
    public ArticuloServiceJpa(ArticuloRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Articulo> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Articulo save(Articulo product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Articulo> delete(Articulo product) {
        Optional<Articulo> productOptional = findById(product.getId());
        productOptional.ifPresent(productRepository::delete);
        return productOptional;
    }

}
