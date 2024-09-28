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


    @EntityGraph(attributePaths = {"detalle_factura", "detalle_factura.articuloid","proveedor_id"})
    @Query("select fc from Factura fc where fc.id = :id")
    Factura findByIdCompra(long id);

    @EntityGraph(attributePaths = {"detalle_factura", "detalle_factura.articuloid","cliente_id"})
    @Query("select fc from Factura fc where fc.id = :id")
    Factura findByIdVenta(long id);

    @EntityGraph(attributePaths = {"detalle_factura", "detalle_factura.articuloid"})
    @Query("select fc from Factura fc where fc.id = :id")
    Factura findById(long id);
}
