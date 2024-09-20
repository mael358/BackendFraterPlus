package com.erp.springboot.backend.models.dao;
import com.erp.springboot.backend.models.entidades.Pedido;
import com.erp.springboot.backend.models.entidades.PedidoDetalle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPedidoDao extends CrudRepository<Pedido, Integer> {

    // Obetener Detalles de los pedidos
    @Query("select dp from PedidoDetalle dp where dp.pedidoid.id = :_idPedido")
    public List<PedidoDetalle> detallesPedido(@Param("_idPedido")int _idPedido);
}
