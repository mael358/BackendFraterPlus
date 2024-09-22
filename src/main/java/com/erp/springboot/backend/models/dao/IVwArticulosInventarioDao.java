package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.vistas.VwArticulosInventario;
import org.springframework.data.repository.CrudRepository;

public interface IVwArticulosInventarioDao extends CrudRepository<VwArticulosInventario,Integer> {

}
