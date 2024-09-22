package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "valor_costo", nullable = false, precision = 19, scale = 4)
    private BigDecimal valor_costo;

    @NotNull
    @Column(name = "valor_venta", nullable = false, precision = 19, scale = 4)
    private BigDecimal valor_venta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValor_costo() {
        return valor_costo;
    }

    public void setValor_costo(BigDecimal valorCosto) {
        this.valor_costo = valorCosto;
    }

    public BigDecimal getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(BigDecimal valorVenta) {
        this.valor_venta = valorVenta;
    }

}