package com.erp.springboot.backend.models.entidades.vistas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "VW_ARTICULOS_INVENTARIO")
public class VwArticulosInventario {
    @Id
    @Column(name = "id_de_articulo")
    private int id;

    @Size(max = 255)
    @Column(name = "descripcion_de_articulo")
    private String descripcionDeArticulo;

    @Column(name = "cantidad_en_existencia_actual", precision = 32)
    private BigDecimal cantidadEnExistenciaActual;

    @Column(name = "fecha_de_creacion_del_lote_mas_antiguo")
    private Instant fechaDeCreacionDelLoteMasAntiguo;

    @Column(name = "ultimo_movimiento_de_lote")
    private Instant ultimoMovimientoDeLote;

    @Column(name = "tipo_de_movimiento_de_lote", columnDefinition = "int UNSIGNED")
    private Long tipoDeMovimientoDeLote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionDeArticulo() {
        return descripcionDeArticulo;
    }

    public BigDecimal getCantidadEnExistenciaActual() {
        return cantidadEnExistenciaActual;
    }

    public Instant getFechaDeCreacionDelLoteMasAntiguo() {
        return fechaDeCreacionDelLoteMasAntiguo;
    }

    public Instant getUltimoMovimientoDeLote() {
        return ultimoMovimientoDeLote;
    }

    public Long getTipoDeMovimientoDeLote() {
        return tipoDeMovimientoDeLote;
    }

    protected VwArticulosInventario() {
    }
}