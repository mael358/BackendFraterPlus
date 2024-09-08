package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long> {

}
