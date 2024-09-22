package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "pedido_detalle")
public class PedidoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "linea", nullable = false)
    private Integer linea;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "precio_ofertado", nullable = false)
    private BigDecimal precio_ofertado;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "articulo_id", nullable = false)
    private Articulo articuloid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedidoid;

    public PedidoDetalle( Integer linea, Integer cantidad, Articulo articuloid, Pedido pedidoid, BigDecimal precioOferta) {
        this.precio_ofertado = precioOferta;
        this.linea = linea;
        this.cantidad = cantidad;
        this.articuloid = articuloid;
        this.pedidoid = pedidoid;
    }

    public PedidoDetalle() {
    }

    public BigDecimal getPrecio_ofertado() {
        return precio_ofertado;
    }

    public void setPrecio_ofertado(BigDecimal precio_ofertado) {
        this.precio_ofertado = precio_ofertado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticuloid() {
        return articuloid;
    }

    public void setArticuloid(Articulo articuloid) {
        this.articuloid = articuloid;
    }

    public Pedido getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(Pedido pedidoid) {
        this.pedidoid = pedidoid;
    }

}