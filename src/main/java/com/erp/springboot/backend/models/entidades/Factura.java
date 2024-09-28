package com.erp.springboot.backend.models.entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "no_factura", nullable = false)
    private String no_factura;

    @Size(max = 40)
    @NotNull
    @Column(name = "nit_emisor", nullable = false, length = 40)
    private String nit_emisor;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombre_emisor", nullable = false, length = 150)
    private String nombre_emisor;

    @NotNull
    @Column(name = "monto_total", nullable = false, precision = 19, scale = 4)
    private BigDecimal monto_total;

    @Column(name = "fecha_creacion", nullable = false)
    private Instant fecha_creacion;

    @Size(max = 255)
    @NotNull
    @Column(name = "direccion_emisor", nullable = false)
    private String direccion_emisor;

    @NotNull
    @Column(name = "tipo_factura", nullable = false)
    private Boolean tipo_factura = false;

    @JsonIgnore
    @Size(max = 100)
    @Column(name = "departamento_receptor", length = 100)
    private String departamento_receptor;

    @Size(max = 255)
    @NotNull
    @Column(name = "observaciones",nullable = false)
    private String observaciones;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido_id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor_id;

    @JsonManagedReference
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalle_factura;

    public List<DetalleFactura> getDetalle_factura() {
        return detalle_factura;
    }

    public void setDetalle_factura(List<DetalleFactura> detalle_factura) {
        this.detalle_factura = detalle_factura;
    }

    public Instant getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(@NotNull Instant fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public @Size(max = 255) @NotNull String getNo_factura() {
        return no_factura;
    }

    public void setNo_factura(@Size(max = 255) @NotNull String no_factura) {
        this.no_factura = no_factura;
    }

    public @Size(max = 40) @NotNull String getNit_emisor() {
        return nit_emisor;
    }

    public void setNit_emisor(@Size(max = 40) @NotNull String nit_emisor) {
        this.nit_emisor = nit_emisor;
    }

    public @Size(max = 255) @NotNull String getDireccion_emisor() {
        return direccion_emisor;
    }

    public void setDireccion_emisor(@Size(max = 255) @NotNull String direccion_emisor) {
        this.direccion_emisor = direccion_emisor;
    }

    public @NotNull Boolean getTipo_factura() {
        return tipo_factura;
    }

    public void setTipo_factura(@NotNull Boolean tipo_factura) {
        this.tipo_factura = tipo_factura;
    }

    public Proveedor getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(Proveedor proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNitEmisor() {
        return nit_emisor;
    }

    public void setNitEmisor(String nitEmisor) {
        this.nit_emisor = nitEmisor;
    }

    public String getNombre_emisor() {
        return nombre_emisor;
    }

    public void setNombre_emisor(String nombreEmisor) {
        this.nombre_emisor = nombreEmisor;
    }

    public BigDecimal getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(BigDecimal montoTotal) {
        this.monto_total = montoTotal;
    }

    public String getDireccionEmisor() {
        return direccion_emisor;
    }

    public void setDireccionEmisor(String direccionEmisor) {
        this.direccion_emisor = direccionEmisor;
    }

    public Boolean getTipoFactura() {
        return tipo_factura;
    }

    public void setTipoFactura(Boolean tipoFactura) {
        this.tipo_factura = tipoFactura;
    }

    public String getDepartamento_receptor() {
        return departamento_receptor;
    }

    public void setDepartamento_receptor(String departamentoReceptor) {
        this.departamento_receptor = departamentoReceptor;
    }

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente clienteid) {
        this.cliente_id = clienteid;
    }

    public Pedido getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Pedido pedidoid) {
        this.pedido_id = pedidoid;
    }

}