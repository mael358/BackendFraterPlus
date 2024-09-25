package com.erp.springboot.backend.services.interfaces;

import com.erp.springboot.backend.models.entidades.Articulo;

import java.util.List;
import java.util.Optional;

public interface ArticuloService {

    List<Articulo> findAll();

    Optional<Articulo> findById(Long id);

    Articulo save(Articulo product);

    Optional<Articulo> delete(Articulo product);

}
