package com.erp.springboot.backend.models.dtos;

import com.erp.springboot.backend.models.entidades.Pedido;

import java.time.Instant;

public class PedidoDto {
    private int id;
    private Instant fecha;
    private String cliente;
    private String estado;

    public PedidoDto(Pedido _pedido) {
        this.id = _pedido.getId();
        this.cliente = _pedido.getClienteid().getNombres().concat(" ").concat(_pedido.getClienteid().getApellidos());
        this.estado = _pedido.getEstadoid().getDescripcion();
        this.fecha = _pedido.getFechaCreacion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
