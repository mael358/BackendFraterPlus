package com.erp.springboot.backend.models.dtos.facturas;

import java.math.BigDecimal;

public class DetalleFacturaDto {
    private int idArticulo;
    private int cantidad;
    private BigDecimal precio;
    private int linea;

    // Constructores, getters y setters
    public DetalleFacturaDto() {
    }

    public DetalleFacturaDto(int idProducto, int cantidad, BigDecimal precio, int linea) {
        this.idArticulo = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
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
