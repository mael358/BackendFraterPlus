package com.erp.springboot.backend.models.dtos.Pedidos;

import java.time.Instant;
import java.util.List;

public class PedidoCreateDto {
    private int cliente;
    private int estado;
    private String observaciones;
    private List<PedidoDetalleCreateDto> detalles;

    public PedidoCreateDto() {
    }

    public PedidoCreateDto(Instant fechaCreacion, int cliente, int estado,String observaciones, List<PedidoDetalleCreateDto> detalles) {
        this.observaciones = observaciones;
        this.cliente = cliente;
        this.estado = estado;
        this.detalles = detalles;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<PedidoDetalleCreateDto> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PedidoDetalleCreateDto> detalles) {
        this.detalles = detalles;
    }
}
