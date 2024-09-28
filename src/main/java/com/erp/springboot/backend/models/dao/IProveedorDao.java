package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.Proveedor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProveedorDao extends CrudRepository<Proveedor, Integer> {

    List<Proveedor> findByNombresContainsIgnoreCase(String nombre);

    @Query("select p from Proveedor p where lower(p.nombres) like lower(concat('%', ?1, '%')) or lower(p.direccion) like lower(concat('%', ?1, '%')) or lower(p.nit) like lower(concat('%', ?1, '%')) or lower(p.telefono) like lower(concat('%', ?1, '%')) or lower(p.correo) like lower(concat('%', ?1, '%'))")
    List<Proveedor> findByNombresOrDireccionOrNitOrTelefonoOrCorreoContainingIgnoreCase(String term);
}
