package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "lote")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fecha_vencimiento")
    private Instant fecha_vencimiento;

    @NotNull
    @Column(name = "cantidad_inicial", nullable = false)
    private Integer cantidad_inicial;

    @NotNull
    @Column(name = "cantidad_disponible", nullable = false)
    private Integer cantidad_disponible;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "articulo_id", nullable = false)
    private Articulo articuloid;

    @Column(name = "compra_id")
    private int compra_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Instant fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public @NotNull Integer getCantidad_inicial() {
        return cantidad_inicial;
    }

    public void setCantidad_inicial(@NotNull Integer cantidad_inicial) {
        this.cantidad_inicial = cantidad_inicial;
    }

    public @NotNull Integer getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(@NotNull Integer cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public @NotNull Articulo getArticuloid() {
        return articuloid;
    }

    public void setArticuloid(@NotNull Articulo articuloid) {
        this.articuloid = articuloid;
    }

    public int getCompra_id() {
        return compra_id;
    }

    public void setCompra_id(int compra_id) {
        this.compra_id = compra_id;
    }
}