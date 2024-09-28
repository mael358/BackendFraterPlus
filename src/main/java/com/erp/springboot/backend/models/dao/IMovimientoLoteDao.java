package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.MovimientoLote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IMovimientoLoteDao extends CrudRepository<MovimientoLote, Integer> {

    @Query("select dc from MovimientoLote dc where dc.ReferenciaDetalleFactura = :referenciaDetalleFactura")
    MovimientoLote findByReferenciaDetalleFactura(Integer referenciaDetalleFactura);

}
