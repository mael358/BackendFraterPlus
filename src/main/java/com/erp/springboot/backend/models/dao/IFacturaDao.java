package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.Cliente;
import com.erp.springboot.backend.models.entidades.Factura;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFacturaDao extends CrudRepository<Factura, Long> {

    @EntityGraph(attributePaths = {"detalle_factura", "detalle_factura.articuloid"})
    @Query("select fc from Factura fc where fc.tipo_factura = :tipoFactura")
    List<Factura> findAllByTipoFactura(boolean tipoFactura);
}
