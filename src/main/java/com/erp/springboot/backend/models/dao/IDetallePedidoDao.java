package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.PedidoDetalle;
import org.springframework.data.repository.CrudRepository;

public interface IDetallePedidoDao extends CrudRepository<PedidoDetalle,Integer>{

}
