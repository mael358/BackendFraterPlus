package com.erp.springboot.backend.services;

import com.erp.springboot.backend.models.dao.*;
import com.erp.springboot.backend.models.dtos.Pedidos.PedidoCreateDto;
import com.erp.springboot.backend.models.dtos.Pedidos.PedidoDetalleDto;
import com.erp.springboot.backend.models.dtos.Pedidos.PedidoDto;
import com.erp.springboot.backend.models.entidades.Pedido;
import com.erp.springboot.backend.models.entidades.PedidoDetalle;
import com.erp.springboot.backend.models.entidades.vistas.VwArticulosInventario;
import com.erp.springboot.backend.services.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private IPedidoDao pedidoDao;

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IEstadoDao estadoDao;

    @Autowired
    private IArticuloDao articuloDao;

    @Autowired
    private IDetallePedidoDao detallePedidoDao;

    @Autowired
    private IVwArticulosInventarioDao vwArticulosInventarioDao;

    /**
     * @return devuelve todos los registros de pedido
     */
    @Override
    @Transactional(readOnly=true)
    public List<PedidoDto> findAll() {
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        for (Pedido pedido : pedidoDao.findAll()) {
            pedidoDtos.add(new PedidoDto(pedido,pedidoDao.detallesPedido(pedido.getId())));
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
            pedidoDtos.add(new PedidoDto(pedido,pedidoDao.detallesPedido(pedido.getId())));
        }
        return pedidoDtos;
    }

    /**
     * @param nombres string a buscar dentro de los clientes de los pedidos
     * @return Lista de pedidos filtrada por nombres
     */
    @Override
    public List<PedidoDto> findAllByNombre(String nombres) {
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        for (Pedido pedido : pedidoDao.findByClienteNombresContainingIgnoreCase(nombres)) {
            pedidoDtos.add(new PedidoDto(pedido,pedidoDao.detallesPedido(pedido.getId())));
        }
        return pedidoDtos;
    }

    /**
     * @param estadoid
     * @return
     */
    @Override
    public List<PedidoDto> findAllByEstado(Integer estadoid) {
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        for (Pedido pedido : pedidoDao.findByEstadoid_Id(estadoid)) {
            pedidoDtos.add(new PedidoDto(pedido,pedidoDao.detallesPedido(pedido.getId())));
        }
        return pedidoDtos;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public PedidoDto findById(int id){
        PedidoDto pedido = new PedidoDto(pedidoDao.findById(id).get(),pedidoDao.detallesPedido(id) );
        for (PedidoDetalleDto detalleDto : pedido.getDetalles()) {
            detalleDto.setCantidadDisponible(obtenerExistencia(((int)detalleDto.getArticuloId())));
        }
        return pedido;
    }

    /**
     * @param _pend
     * @return
     */
    @Override
    @Transactional
    public PedidoDto save(PedidoCreateDto _pend) {
        // Crear el pedido sin guardarlo aún
        Pedido pedido = new Pedido(
                _pend,
                clienteDao.findById((long)_pend.getCliente()).get(),
                estadoDao.findById(_pend.getEstado()).get()
        );

        int linea = 1;

        // Crear y asociar los detalles con el pedido
        for (var detalle : _pend.getDetalles()) {
            PedidoDetalle nuevoDetalle = new PedidoDetalle(
                    linea, // Número de línea
                    detalle.getCantidad(),
                    articuloDao.findById(detalle.getArticulo()).get(),
                    pedido,
                    detalle.getPrecio()
            );
            pedido.getDetalles().add(nuevoDetalle); // Añadir el detalle al pedido
            linea++;
        }

        // Guardar el pedido junto con los detalles
        Pedido pedidoGuardado = pedidoDao.save(pedido);

        // Retornar el Pedido con los detalles guardados
        return new PedidoDto(pedidoGuardado, pedidoGuardado.getDetalles());
    }


    /**
     * @param _pedido
     * @param pedidoId
     * @return
     */
    @Override
    public PedidoDto updatePedido(PedidoCreateDto _pedido,int pedidoId ) {
        // Buscar el pedido existente
        Pedido pedidoExistente = pedidoDao.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        // Actualizar las propiedades del pedido con los nuevos datos
        pedidoExistente.setClienteid(clienteDao.findById((long)_pedido.getCliente()).get());
        pedidoExistente.setEstadoid(estadoDao.findById(_pedido.getEstado()).get());

        // Buscar los detalles actuales del pedido
        List<PedidoDetalle> detallesExistentes = pedidoDao.detallesPedido(pedidoExistente.getId());

        // Mapear los detalles existentes por número de línea para compararlos
        Map<Integer, PedidoDetalle> detalleMap = detallesExistentes.stream()
                .collect(Collectors.toMap(PedidoDetalle::getLinea, Function.identity()));

        List<PedidoDetalle> detallesActualizados = new ArrayList<>();
        List<PedidoDetalle> detallesNuevos = new ArrayList<>();
        List<PedidoDetalle> detallesParaEliminar = new ArrayList<>(detallesExistentes);

        // Recorrer los nuevos detalles recibidos
        for (var detalleDto : _pedido.getDetalles()) {
            if (detalleMap.containsKey(detalleDto.getLinea())) {
                // Si el detalle ya existe, actualizarlo
                PedidoDetalle detalleExistente = detalleMap.get(detalleDto.getLinea());
                detalleExistente.setCantidad(detalleDto.getCantidad());
                detalleExistente.setArticuloid(articuloDao.findById(detalleDto.getArticulo()).get());
                detallesActualizados.add(detalleExistente);
                detallesParaEliminar.remove(detalleExistente); // No eliminar este detalle, porque aún existe
            } else {
                // Si es un nuevo detalle, agregarlo
                PedidoDetalle nuevoDetalle = new PedidoDetalle(
                        detalleDto.getLinea(),
                        detalleDto.getCantidad(),
                        articuloDao.findById(detalleDto.getArticulo()).get(),
                        pedidoExistente,
                        detalleDto.getPrecio()
                );
                detallesNuevos.add(nuevoDetalle);
            }
        }

        // Eliminar los detalles que ya no están en el nuevo pedido
        detallePedidoDao.deleteAll(detallesParaEliminar);

        // Guardar los nuevos y actualizados detalles
        detallePedidoDao.saveAll(detallesNuevos);
        detallePedidoDao.saveAll(detallesActualizados);

        // Guardar el pedido actualizado
        Pedido pedidoActualizado = pedidoDao.save(pedidoExistente);

        // Retornar el DTO con el pedido y los detalles actualizados
        List<PedidoDetalle> todosLosDetalles = new ArrayList<>(detallesActualizados);
        todosLosDetalles.addAll(detallesNuevos);

        return new PedidoDto(pedidoActualizado, todosLosDetalles);
    }


    /**
     * @param id
     */
    @Override
    public void delete(int id) { pedidoDao.deleteById(id) ;}

    /**
     * Obtiene la existencia actual de un articulo
     * @param codigoArticulo
     * @return obtiene la cantidad actual de articulos disponibles en el inventario
     */
    public int obtenerExistencia(Integer codigoArticulo){
        VwArticulosInventario optionalVista = vwArticulosInventarioDao.findById(codigoArticulo)
                .orElseThrow(() -> new RuntimeException("Articulo no existente para buscar existencia"));
        return optionalVista.getCantidadEnExistenciaActual().intValue();
    }


}
