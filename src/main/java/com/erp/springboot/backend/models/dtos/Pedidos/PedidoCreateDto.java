package com.erp.springboot.backend.models.dtos.Pedidos;

import java.time.Instant;
import java.util.List;

public class PedidoCreateDto {
    private int cliente;
    private int estado;
    private List<PedidoDetalleCreateDto> detalles;

    public PedidoCreateDto() {
    }

    public PedidoCreateDto(Instant fechaCreacion, int cliente, int estado, List<PedidoDetalleCreateDto> detalles) {
        this.cliente = cliente;
        this.estado = estado;
        this.detalles = detalles;
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
