package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "Detalle_Factura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "precioUnitario", nullable = false, precision = 19, scale = 4)
    private BigDecimal precioUnitario;

    @NotNull
    @Column(name = "noLinea", nullable = false)
    private Integer noLinea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Articuloid", nullable = false)
    private Articulo articuloid;

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
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getNoLinea() {
        return noLinea;
    }

    public void setNoLinea(Integer noLinea) {
        this.noLinea = noLinea;
    }

    public Articulo getArticuloid() {
        return articuloid;
    }

    public void setArticuloid(Articulo articuloid) {
        this.articuloid = articuloid;
    }

}