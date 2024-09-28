package com.erp.springboot.backend.services.interfaces;

import com.erp.springboot.backend.models.dtos.facturas.FacturaCompraDto;
import com.erp.springboot.backend.models.dtos.facturas.FacturaDto;
import com.erp.springboot.backend.models.dtos.facturas.FacturaVentaDto;
import com.erp.springboot.backend.models.entidades.Factura;

import java.util.List;

public interface IFacturaService {

    Factura CrearCompra(FacturaCompraDto facturaDto);

    Factura CrearVenta(FacturaVentaDto facturaDto);

    Factura obtenerFacturaPorId(int id);

    List<Factura> listarFacturasCompra();

    List<Factura> listarFacturasVenta();

    Factura actualizarFactura(int id, FacturaDto facturaDto);

    void eliminarFactura(int id);
}

