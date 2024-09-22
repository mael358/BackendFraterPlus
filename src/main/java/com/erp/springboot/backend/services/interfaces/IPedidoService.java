package com.erp.springboot.backend.services.interfaces;

import com.erp.springboot.backend.models.dtos.Pedidos.PedidoCreateDto;
import com.erp.springboot.backend.models.dtos.Pedidos.PedidoDto;
import com.erp.springboot.backend.models.entidades.Pedido;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPedidoService {

    List<PedidoDto> findAll();

    List<PedidoDto> findAll(Pageable pageable);

    PedidoDto findById(int id);

    PedidoDto save(PedidoCreateDto _pedido);

    PedidoDto updatePedido(PedidoCreateDto _pedido, int id);

    List<PedidoDto> findAllByNombre(String nombres);

    List<PedidoDto> findAllByEstado(Integer estadoid);

    void delete(int id);

}
