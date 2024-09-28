package com.erp.springboot.backend.models.dtos.facturas;

import java.math.BigDecimal;

public class DetalleFacturaCompraDto {
    private int articulo;
    private int cantidad;
    private BigDecimal precio;
    private int linea;

    public DetalleFacturaCompraDto(int articulo, int cantidad, BigDecimal precio, int linea) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.linea = linea;
    }

    public DetalleFacturaCompraDto() {
    }

    public int getArticulo() {
        return articulo;
    }

    public void setArticulo(int articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
}
