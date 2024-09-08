package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.Articulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IArticuloDao extends CrudRepository<Articulo, Long> {

    @Query("select p from Articulo p where p.nombre like %?1%")
    public List<Articulo> findByNombre(String term);

    public List<Articulo> findByNombreContainingIgnoreCase(String term);

    public List<Articulo> findByNombreStartingWithIgnoreCase(String term);
}
