package com.erp.springboot.backend.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.springboot.backend.models.entidades.Cliente;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c where lower(c.nombres) like lower(concat('%', ?1, '%')) or lower(c.dpi) like lower(concat('%', ?1, '%')) or lower(c.nit) like lower(concat('%', ?1, '%')) or cast(c.id as string) like ?1")
    List<Cliente> findByIdOrNombresOrDpiOrNitContainingIgnoreCase(String term);
}
