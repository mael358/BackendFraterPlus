package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.Estado;
import org.springframework.data.repository.CrudRepository;

public interface IEstadoDao extends CrudRepository<Estado, Integer> {
}
