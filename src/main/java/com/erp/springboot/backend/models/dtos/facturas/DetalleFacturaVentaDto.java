package com.erp.springboot.backend.models.dtos.facturas;

import java.math.BigDecimal;

public class DetalleFacturaVentaDto {
    private int articulo;
    private int cantidad;
    private BigDecimal precio;
    private int linea;

    // Constructores, getters y setters
    public DetalleFacturaVentaDto() {
    }

    public DetalleFacturaVentaDto(int idProducto, int cantidad, BigDecimal precio, int linea) {
        this.articulo = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getArticulo() {
        return articulo;
    }

    public void setArticulo(int articulo) {
        this.articulo = articulo;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
