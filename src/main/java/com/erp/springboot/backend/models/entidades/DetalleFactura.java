package com.erp.springboot.backend.models.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_Factura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "precio_unitario", nullable = false, precision = 19, scale = 4)
    private BigDecimal precio_unitario;

    @NotNull
    @Column(name = "no_linea", nullable = false)
    private Integer no_linea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "articulo_id", nullable = false)
    private Articulo articuloid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "factura_id", nullable = false)
    @JsonBackReference
    private Factura factura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precio_unitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precio_unitario = precioUnitario;
    }

    public Integer getNoLinea() {
        return no_linea;
    }

    public void setNoLinea(Integer noLinea) {
        this.no_linea = noLinea;
    }

    public @NotNull BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(@NotNull BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public @NotNull Integer getNo_linea() {
        return no_linea;
    }

    public void setNo_linea(@NotNull Integer no_linea) {
        this.no_linea = no_linea;
    }

    public @NotNull Articulo getArticuloid() {
        return articuloid;
    }

    public void setArticuloid(@NotNull Articulo articuloid) {
        this.articuloid = articuloid;
    }

    public @NotNull Factura getFactura() {
        return factura;
    }

    public void setFactura(@NotNull Factura factura) {
        this.factura = factura;
    }
}