package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
public class MovimientoLote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "tipoMovimiento", nullable = false)
    private Boolean tipoMovimiento = false;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "fechaMovimiento", nullable = false)
    private Instant fechaMovimiento;

    @Column(name = "referenciaDetalleFactura")
    private Integer referenciaDetalleFactura;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "loteid", nullable = false)
    private Lote loteid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Boolean tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Instant getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Instant fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Integer getReferenciaDetalleFactura() {
        return referenciaDetalleFactura;
    }

    public void setReferenciaDetalleFactura(Integer referenciaDetalleFactura) {
        this.referenciaDetalleFactura = referenciaDetalleFactura;
    }

    public Lote getLoteid() {
        return loteid;
    }

    public void setLoteid(Lote loteid) {
        this.loteid = loteid;
    }

}