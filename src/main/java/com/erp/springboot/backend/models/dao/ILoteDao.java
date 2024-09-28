package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.Lote;
import org.springframework.data.repository.CrudRepository;

public interface ILoteDao extends CrudRepository<Lote, Integer> {
    Lote findByArticuloid_Id(long articuloId);
}

