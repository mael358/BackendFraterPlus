package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 40)
    @NotNull
    @Column(name = "nitEmisor", nullable = false, length = 40)
    private String nitEmisor;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombreEmisor", nullable = false, length = 150)
    private String nombreEmisor;

    @NotNull
    @Column(name = "montoTotal", nullable = false, precision = 19, scale = 4)
    private BigDecimal montoTotal;

    @Size(max = 255)
    @NotNull
    @Column(name = "direccionEmisor", nullable = false)
    private String direccionEmisor;

    @NotNull
    @Column(name = "tipoFactura", nullable = false)
    private Boolean tipoFactura = false;

    @Size(max = 100)
    @Column(name = "departamentoReceptor", length = 100)
    private String departamentoReceptor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Clienteid", nullable = false)
    private Cliente clienteid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Pedidoid", nullable = false)
    private Pedido pedidoid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNitEmisor() {
        return nitEmisor;
    }

    public void setNitEmisor(String nitEmisor) {
        this.nitEmisor = nitEmisor;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDireccionEmisor() {
        return direccionEmisor;
    }

    public void setDireccionEmisor(String direccionEmisor) {
        this.direccionEmisor = direccionEmisor;
    }

    public Boolean getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(Boolean tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public String getDepartamentoReceptor() {
        return departamentoReceptor;
    }

    public void setDepartamentoReceptor(String departamentoReceptor) {
        this.departamentoReceptor = departamentoReceptor;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
    }

    public Pedido getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(Pedido pedidoid) {
        this.pedidoid = pedidoid;
    }

}