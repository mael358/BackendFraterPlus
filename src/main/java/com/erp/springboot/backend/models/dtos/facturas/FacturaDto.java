package com.erp.springboot.backend.models.dtos.facturas;

import java.util.List;

public class FacturaDto {
    private String observacion;
    private String numero;
    private List<DetalleFacturaDto> detalles;

    // Constructores, getters y setters
    public FacturaDto() {
    }

    public FacturaDto(String observacion, String numero, List<DetalleFacturaDto> detalles) {
        this.observacion = observacion;
        this.numero = numero;
        this.detalles = detalles;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<DetalleFacturaDto> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFacturaDto> detalles) {
        this.detalles = detalles;
    }
}
