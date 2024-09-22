package com.erp.springboot.backend.models.dtos.Pedidos;

import com.erp.springboot.backend.models.entidades.PedidoDetalle;

import java.math.BigDecimal;

public class PedidoDetalleDto {
    private int linea;
    private int cantidad;
    private BigDecimal precio;
    private String articulo;

    public PedidoDetalleDto(PedidoDetalle _detalle) {
        this.linea = _detalle.getLinea();
        this.precio = _detalle.getPrecio_ofertado();
        this.cantidad = _detalle.getCantidad();
        this.articulo = _detalle.getArticuloid().getDescripcion();
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }
}
