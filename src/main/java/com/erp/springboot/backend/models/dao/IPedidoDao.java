package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface IPedidoDao extends CrudRepository<Pedido, Integer> {

}
