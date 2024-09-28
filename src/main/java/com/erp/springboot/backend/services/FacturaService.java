package com.erp.springboot.backend.services;
import com.erp.springboot.backend.models.dao.IFacturaDao;
import com.erp.springboot.backend.models.dao.IProveedorDao;
import com.erp.springboot.backend.models.dao.IClienteDao;
import com.erp.springboot.backend.models.dao.IArticuloDao;
import com.erp.springboot.backend.models.dtos.facturas.*;
import com.erp.springboot.backend.models.entidades.*;
import com.erp.springboot.backend.services.interfaces.IFacturaService;
import com.erp.springboot.backend.services.interfaces.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacturaService implements IFacturaService {

    @Autowired
    private IFacturaDao facturaDao;

    @Autowired
    private IProveedorDao proveedorDao;

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IArticuloDao articuloDao;

    @Autowired
    private InventarioService inventarioService;

    @Override
    public Factura CrearCompra(FacturaCompraDto facturaDto) {
        Factura factura = new Factura();

        factura.setNo_factura(facturaDto.getNumero());
        factura.setObservaciones(facturaDto.getObservacion());
        factura.setTipo_factura(false); // False para compras

        // Establecer el proveedor emisor
        Proveedor proveedor = proveedorDao.findById(facturaDto.getIdProveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        factura.setProveedor_id(proveedor);

        factura.setNit_emisor(proveedor.getNit());
        factura.setNombre_emisor(proveedor.getNombres());
        factura.setDireccion_emisor(proveedor.getDireccion());
        factura.setFecha_creacion(new Date().toInstant());

        List<DetalleFactura> detalles = new ArrayList<>();
        BigDecimal montoTotal = BigDecimal.ZERO;

        for (DetalleFacturaCompraDto detalleDto : facturaDto.getDetalles()) {
            DetalleFactura detalle = new DetalleFactura();
            detalle.setCantidad(detalleDto.getCantidad());
            detalle.setPrecioUnitario(detalleDto.getPrecio());

            Articulo producto = articuloDao.findById((long)detalleDto.getArticulo())
                    .orElseThrow(() -> new RuntimeException("Articulo no encontrado"));
            detalle.setArticuloid(producto);
            detalle.setFactura(factura);
            detalle.setNo_linea(detalleDto.getLinea());
            detalles.add(detalle);

            montoTotal = montoTotal.add(detalle.getPrecio_unitario().multiply(BigDecimal.valueOf(detalle.getCantidad())));
        }

        factura.setDetalle_factura(detalles);
        factura.setMonto_total(montoTotal);

        var facturaCreada = facturaDao.save(factura);
        inventarioService.procesarFactura(facturaCreada, true);
        return facturaCreada;
    }

    @Override
    public Factura CrearVenta(FacturaVentaDto facturaDto) {
        Factura factura = new Factura();

        factura.setNo_factura(facturaDto.getNumero());
        factura.setObservaciones(facturaDto.getObservacion());
        factura.setTipo_factura(true); // True para ventas

        // Establecer el cliente receptor
        Cliente cliente = clienteDao.findById((long)facturaDto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        factura.setCliente_id(cliente);

        // Datos del emisor (su empresa)
        factura.setNit_emisor("NIT de su empresa");
        factura.setNombre_emisor("Libreria Fraternidad Cristiana");
        factura.setDireccion_emisor("Ciudad");
        factura.setFecha_creacion(new Date().toInstant());

        List<DetalleFactura> detalles = new ArrayList<>();
        BigDecimal montoTotal = BigDecimal.ZERO;

        for (DetalleFacturaVentaDto detalleDto : facturaDto.getDetalles()) {
            DetalleFactura detalle = new DetalleFactura();
            detalle.setCantidad(detalleDto.getCantidad());
            detalle.setPrecioUnitario(detalleDto.getPrecio());

            Articulo producto = articuloDao.findById((long)detalleDto.getArticulo())
                    .orElseThrow(() -> new RuntimeException("Articulo no encontrado"));
            detalle.setArticuloid(producto);
            detalle.setFactura(factura);
            detalle.setNo_linea(detalleDto.getLinea());
            detalles.add(detalle);

            montoTotal = montoTotal.add(detalle.getPrecio_unitario().multiply(BigDecimal.valueOf(detalle.getCantidad())));
        }

        factura.setDetalle_factura(detalles);
        factura.setMonto_total(montoTotal);
        var facturaCreada = facturaDao.save(factura);
        inventarioService.procesarFactura(facturaCreada, true);
        return facturaCreada;
    }

    @Override
    public Factura obtenerFacturaCompraPorId(int id) {
        var factura = facturaDao.findById((long)id);
        if (factura != null && !factura.getTipo_factura()) {
            return factura;
        }else {
            return null;
        }
    }

    @Override
    public Factura obtenerFacturaVentaPorId(int id) {
        var factura = facturaDao.findById((long)id);
        if (factura != null && factura.getTipo_factura()) {
            return factura;
        }else {
            return null;
        }
    }

    private Factura obtenerFacturaPorId(int id) {
        return facturaDao.findById((long)id);
    }


    @Override
    public List<Factura> listarFacturasCompra() {
        return (List<Factura>) facturaDao.findAllByTipoFactura(false);
    }

    @Override
    public List<Factura> listarFacturasVenta() {
        return (List<Factura>) facturaDao.findAllByTipoFactura(true);
    }

    @Override
    public Factura actualizarFactura(int id, FacturaDto facturaDto) {
        Factura facturaExistente = obtenerFacturaPorId(id);

        facturaExistente.setNo_factura(facturaDto.getNumero());
        facturaExistente.setObservaciones(facturaDto.getObservacion());

        // Actualizar detalles de la factura
        List<DetalleFactura> nuevosDetalles = new ArrayList<>();
        BigDecimal montoTotal = BigDecimal.ZERO;

        for (DetalleFacturaDto detalleDto : facturaDto.getDetalles()) {
            DetalleFactura detalle = new DetalleFactura();
            detalle.setCantidad(detalleDto.getCantidad());
            detalle.setPrecioUnitario(detalleDto.getPrecio());

            Articulo articulo = articuloDao.findById((long)detalleDto.getIdArticulo())
                    .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
            detalle.setArticuloid(articulo);
            detalle.setFactura(facturaExistente);
            nuevosDetalles.add(detalle);

            montoTotal = montoTotal.add(detalle.getPrecio_unitario().multiply(BigDecimal.valueOf(detalle.getCantidad())));
        }

        facturaExistente.setDetalle_factura(nuevosDetalles);
        facturaExistente.setMonto_total(montoTotal);

        return facturaDao.save(facturaExistente);
    }

    @Override
    public void eliminarFactura(int id) {
        Factura factura = obtenerFacturaPorId(id);
        inventarioService.procesarFactura(factura,false);
        facturaDao.delete(factura);
    }


}

