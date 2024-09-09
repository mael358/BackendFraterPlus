package com.erp.springboot.backend.services.interfaces;

import com.erp.springboot.backend.models.dtos.PedidoDto;
import com.erp.springboot.backend.models.entidades.Pedido;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPedidoService {

    List<PedidoDto> findAll();

    List<PedidoDto> findAll(Pageable pageable);

    PedidoDto findById(int id);

    PedidoDto save(Pedido pedido);

    void delete(int id);

}
