package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "movimiento_lote")
public class MovimientoLote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "tipo_movimiento", nullable = false)
    private Boolean tipo_movimiento = false;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "fecha_movimiento", nullable = false)
    private Instant fecha_movimiento;

    @Column(name = "referencia_detalle_factura")
    private Integer ReferenciaDetalleFactura;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lote_id", nullable = false)
    private Lote lote_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(Boolean tipoMovimiento) {
        this.tipo_movimiento = tipoMovimiento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Instant getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(Instant fechaMovimiento) {
        this.fecha_movimiento = fechaMovimiento;
    }

    public Integer getReferencia_detalle_factura() {
        return ReferenciaDetalleFactura;
    }

    public void setReferencia_detalle_factura(Integer referenciaDetalleFactura) {
        this.ReferenciaDetalleFactura = referenciaDetalleFactura;
    }

    public Lote getLote_id() {
        return lote_id;
    }

    public void setLote_id(Lote loteid) {
        this.lote_id = loteid;
    }

}