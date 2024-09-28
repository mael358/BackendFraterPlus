package com.erp.springboot.backend.services;

import com.erp.springboot.backend.models.dao.IArticuloDao;
import com.erp.springboot.backend.models.dao.ILoteDao;
import com.erp.springboot.backend.models.dao.IMovimientoLoteDao;
import com.erp.springboot.backend.models.dao.IVwArticulosInventarioDao;
import com.erp.springboot.backend.models.entidades.DetalleFactura;
import com.erp.springboot.backend.models.entidades.Factura;
import com.erp.springboot.backend.models.entidades.Lote;
import com.erp.springboot.backend.models.entidades.MovimientoLote;
import com.erp.springboot.backend.models.entidades.vistas.VwArticulosInventario;
import com.erp.springboot.backend.services.interfaces.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class InventarioService implements IInventarioService {

    @Autowired
    private ILoteDao loteDao;

    @Autowired
    private IMovimientoLoteDao movimientoLoteDao;

    @Autowired
    private IArticuloDao articuloDao;

    @Autowired
    private IVwArticulosInventarioDao iVwArticulosInventarioDao;

    /**
     * @return
     */
    @Override
    public List<VwArticulosInventario> findAll() {
        return (List<VwArticulosInventario>) iVwArticulosInventarioDao.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<VwArticulosInventario> findByArticulo(int id) {
        return (List<VwArticulosInventario>) iVwArticulosInventarioDao.findVwArticulosInventarioById(id);
    }

    /**
     * @param nombre
     * @return
     */
    @Override
    public List<VwArticulosInventario> findByNombre(String nombre) {
        return (List<VwArticulosInventario>) iVwArticulosInventarioDao.findByDescripcionDeArticuloContainingIgnoreCase(nombre);
    }


    @Transactional
    public void procesarFactura(Factura factura, boolean esCreacion) {
        if (esCreacion) {
            if (!factura.getTipoFactura()) { // Asumiendo getTipoFactura()
                // Es una factura de compra
                crearLoteYMovimientosEntrada(factura);
            } else {
                // Es una factura de venta
                crearMovimientosSalida(factura);
            }
        } else {
            // Es una eliminación
            if (!factura.getTipoFactura()) {
                // Revertir creación de lote y movimientos de entrada
                eliminarLoteYMovimientosEntrada(factura);
            } else {
                // Revertir movimientos de salida
                eliminarMovimientosSalida(factura);
            }
        }
    }

    private void crearLoteYMovimientosEntrada(Factura factura) {
        for (DetalleFactura detalle : factura.getDetalle_factura()) {
            // Crear o actualizar el lote para cada artículo
            Lote lote = loteDao.findByArticuloid_Id(detalle.getArticuloid().getId());
            if (lote == null) {
                lote = new Lote();
                lote.setArticuloid(detalle.getArticuloid());
                lote.setCantidad_inicial(0);
                lote.setCantidad_disponible(0);
                lote.setFecha_vencimiento(null); // Asignar si tienes esta información
                lote.setCompra_id(factura.getId());
            }

            // Actualizar cantidades
            lote.setCantidad_inicial(lote.getCantidad_inicial() + detalle.getCantidad());
            lote.setCantidad_disponible(lote.getCantidad_disponible() + detalle.getCantidad());
            loteDao.save(lote);

            // Crear MovimientoLote de entrada
            MovimientoLote movimiento = new MovimientoLote();
            movimiento.setTipo_movimiento(true); // true para entrada
            movimiento.setCantidad(detalle.getCantidad());
            movimiento.setFecha_movimiento(Instant.now());
            movimiento.setReferencia_detalle_factura(detalle.getId());
            movimiento.setLote_id(lote);

            movimientoLoteDao.save(movimiento);
        }
    }

    private void crearMovimientosSalida(Factura factura) {
        for (DetalleFactura detalle : factura.getDetalle_factura()) {
            // Obtener el lote correspondiente al artículo
            Lote lote = loteDao.findByArticuloid_Id(detalle.getArticuloid().getId());
            if (lote == null || lote.getCantidad_disponible() < detalle.getCantidad()) {
                throw new RuntimeException("No hay suficiente stock para el artículo: " + detalle.getArticuloid().getNombre());
            }

            // Restar la cantidad del lote
            lote.setCantidad_disponible(lote.getCantidad_disponible() - detalle.getCantidad());
            loteDao.save(lote);

            // Crear MovimientoLote de salida
            MovimientoLote movimiento = new MovimientoLote();
            movimiento.setTipo_movimiento(false); // false para salida
            movimiento.setCantidad(detalle.getCantidad());
            movimiento.setFecha_movimiento(Instant.now());
            movimiento.setReferencia_detalle_factura(detalle.getId());
            movimiento.setLote_id(lote);

            movimientoLoteDao.save(movimiento);
        }
    }

    private void eliminarLoteYMovimientosEntrada(Factura factura) {
        for (DetalleFactura detalle : factura.getDetalle_factura()) {
            // Obtener el lote correspondiente al artículo
            Lote lote = loteDao.findByArticuloid_Id(detalle.getArticuloid().getId());
            if (lote != null) {
                // Revertir cantidades
                lote.setCantidad_inicial(lote.getCantidad_inicial() - detalle.getCantidad());
                lote.setCantidad_disponible(lote.getCantidad_disponible() - detalle.getCantidad());

                // Si las cantidades llegan a cero, eliminar el lote
                if (lote.getCantidad_inicial() <= 0) {
                    loteDao.delete(lote);
                } else {
                    loteDao.save(lote);
                }

                // Eliminar movimiento de entrada
                MovimientoLote movimiento = movimientoLoteDao.findByReferenciaDetalleFactura(detalle.getId());
                if (movimiento != null) {
                    movimientoLoteDao.delete(movimiento);
                }
            }
        }
    }

    private void eliminarMovimientosSalida(Factura factura) {
        for (DetalleFactura detalle : factura.getDetalle_factura()) {
            // Obtener el movimiento correspondiente
            MovimientoLote movimiento = movimientoLoteDao.findByReferenciaDetalleFactura(detalle.getId());
            if (movimiento != null) {
                // Devolver la cantidad al lote
                Lote lote = movimiento.getLote_id();
                lote.setCantidad_disponible(lote.getCantidad_disponible() + movimiento.getCantidad());
                loteDao.save(lote);

                // Eliminar el movimiento
                movimientoLoteDao.delete(movimiento);
            }
        }
    }


}
