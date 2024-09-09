package com.erp.springboot.backend.services;

import com.erp.springboot.backend.models.dao.IPedidoDao;
import com.erp.springboot.backend.models.dtos.PedidoDto;
import com.erp.springboot.backend.models.entidades.Pedido;
import com.erp.springboot.backend.services.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private IPedidoDao pedidoDao;

    /**
     * @return devuelve todos los registros de pedido
     */
    @Override
    @Transactional(readOnly=true)
    public List<PedidoDto> findAll() {
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        for (Pedido pedido : pedidoDao.findAll()) {
            pedidoDtos.add(new PedidoDto(pedido));
        }
        return pedidoDtos;
    }

    /**
     * @param pageable
     * @return resgistros de pedido paginados
     */
    @Override
    public List<PedidoDto> findAll(Pageable pageable) {
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        for (Pedido pedido : pedidoDao.findAll()) {
            pedidoDtos.add(new PedidoDto(pedido));
        }
        return pedidoDtos;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public PedidoDto findById(int id) {return new PedidoDto(pedidoDao.findById(id).get() );}

    /**
     * @param pedido
     * @return
     */
    @Override
    public PedidoDto save(Pedido pedido) { return new PedidoDto(pedidoDao.save(pedido)) ; }

    /**
     * @param id
     */
    @Override
    public void delete(int id) { pedidoDao.deleteById(id) ;}
}
