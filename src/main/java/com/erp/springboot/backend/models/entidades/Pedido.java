package com.erp.springboot.backend.models.entidades;
import com.erp.springboot.backend.models.dtos.Pedidos.PedidoCreateDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente clienteid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estadoid;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoDetalle> detalles = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(PedidoCreateDto pedidoCreateDto, Cliente clienteid, Estado estadoid) {
        this.fechaCreacion = Instant.now();
        this.clienteid = clienteid;
        this.estadoid = estadoid;
    }

    public Pedido( Instant fechaCreacion, Cliente clienteid, Estado estadoid) {
        this.fechaCreacion = fechaCreacion;
        this.clienteid = clienteid;
        this.estadoid = estadoid;
    }

    public List<PedidoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PedidoDetalle> detalles) {
        this.detalles = detalles;
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