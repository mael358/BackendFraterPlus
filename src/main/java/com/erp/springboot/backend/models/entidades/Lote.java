package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
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
    private Articulo articulo_id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "compra_id", nullable = false)
    private Compra compra_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Instant fechaVencimiento) {
        this.fecha_vencimiento = fechaVencimiento;
    }

    public Integer getCantidad_inicial() {
        return cantidad_inicial;
    }

    public void setCantidad_inicial(Integer cantidadInicial) {
        this.cantidad_inicial = cantidadInicial;
    }

    public Integer getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(Integer cantidadDisponible) {
        this.cantidad_disponible = cantidadDisponible;
    }

    public Articulo getArticulo_id() {
        return articulo_id;
    }

    public void setArticulo_id(Articulo articuloid) {
        this.articulo_id = articuloid;
    }

    public Compra getCompra_id() {
        return compra_id;
    }

    public void setCompra_id(Compra compra) {
        this.compra_id = compra;
    }

}