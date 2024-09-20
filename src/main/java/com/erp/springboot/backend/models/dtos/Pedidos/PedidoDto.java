package com.erp.springboot.backend.models.dtos.Pedidos;

import com.erp.springboot.backend.models.entidades.Pedido;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.erp.springboot.backend.models.entidades.PedidoDetalle;

public class PedidoDto {
    private int id;
    private Instant fecha;
    private String cliente;
    private String estado;
    private List<PedidoDetalleDto> detalles;

    public PedidoDto(Pedido _pedido, List<PedidoDetalle> _pendDetailers) {
        this.id = _pedido.getId();
        this.cliente = _pedido.getClienteid().getNombres().concat(" ").concat(_pedido.getClienteid().getApellidos());
        this.estado = _pedido.getEstadoid().getDescripcion();
        this.fecha = _pedido.getFechaCreacion();
        this.detalles = new ArrayList<>();
        for (PedidoDetalle _pedidoDetalle : _pendDetailers) {
            this.detalles.add(new PedidoDetalleDto(_pedidoDetalle));
        }
    }

    public List<PedidoDetalleDto> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PedidoDetalleDto> detalles) {
        this.detalles = detalles;
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

