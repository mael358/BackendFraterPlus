package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.Proveedor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProveedorDao extends CrudRepository<Proveedor, Integer> {

    List<Proveedor> findByNombresContainsIgnoreCase(String nombre);
}
