package com.erp.springboot.backend.models.dtos.Pedidos;

public class PedidoDetalleCreateDto {
    private long articulo;
    private int cantidad;
    private int linea;

    public PedidoDetalleCreateDto() {
    }

    public PedidoDetalleCreateDto(long articulo, int cantidad, int linea) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.linea = linea;
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
