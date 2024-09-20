package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.Articulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IArticuloDao extends CrudRepository<Articulo, Long> {

    @Query("select p from Articulo p where lower(p.nombre) like lower(concat('%', ?1, '%')) or lower(p.descripcion) like lower(concat('%', ?1, '%'))")
    List<Articulo> findByNombreOrDescripcionContainingIgnoreCase(String term);

    List<Articulo> findByNombreContainingIgnoreCase(String term);

    List<Articulo> findByNombreStartingWithIgnoreCase(String term);
}
