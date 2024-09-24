package com.erp.springboot.backend.models.dtos.Pedidos;

import com.erp.springboot.backend.models.entidades.PedidoDetalle;

import java.math.BigDecimal;

public class PedidoDetalleDto {
    private int linea;
    private int cantidad;
    private BigDecimal precio;
    private String articulo;
    private Integer cantidadDisponible;
    private long articuloId;

    public PedidoDetalleDto(PedidoDetalle _detalle) {
        this.linea = _detalle.getLinea();
        this.precio = _detalle.getPrecio_ofertado();
        this.cantidad = _detalle.getCantidad();
        this.articulo = _detalle.getArticuloid().getDescripcion();
        this.articuloId = _detalle.getArticuloid().getId();
    }

    public long getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(long articuloId) {
        this.articuloId = articuloId;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
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
