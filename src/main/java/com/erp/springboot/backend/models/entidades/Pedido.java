package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "fechaCreacion", nullable = false)
    private Instant fechaCreacion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Clienteid", nullable = false)
    private Cliente clienteid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Estadoid", nullable = false)
    private Estado estadoid;

    public Pedido() {
    }

    public Pedido(Integer id, Instant fechaCreacion, Cliente clienteid, Estado estadoid) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.clienteid = clienteid;
        this.estadoid = estadoid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
    }

    public Estado getEstadoid() {
        return estadoid;
    }

    public void setEstadoid(Estado estadoid) {
        this.estadoid = estadoid;
    }

}