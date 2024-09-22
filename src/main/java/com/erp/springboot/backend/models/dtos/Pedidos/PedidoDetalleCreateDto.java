package com.erp.springboot.backend.models.dtos.Pedidos;

import java.math.BigDecimal;

public class PedidoDetalleCreateDto {
    private long articulo;
    private int cantidad;
    private int linea;
    private BigDecimal precio;

    public PedidoDetalleCreateDto() {
    }

    public PedidoDetalleCreateDto(long articulo, int cantidad, int linea, BigDecimal precioOfertado) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.linea = linea;
        this.precio = precioOfertado;
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

    public long getArticulo() {
        return articulo;
    }

    public void setArticulo(long articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
