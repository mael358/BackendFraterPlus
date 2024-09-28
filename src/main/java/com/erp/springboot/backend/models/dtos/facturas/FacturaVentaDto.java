package com.erp.springboot.backend.models.dtos.facturas;

import java.util.List;

public class FacturaVentaDto {
    private int idCliente;
    private String observacion;
    private String numero;
    private List<DetalleFacturaVentaDto> detalles;

    // Constructores, getters y setters

    public FacturaVentaDto(int idCliente, String observacion, String numero, List<DetalleFacturaVentaDto> detalles) {
        this.idCliente = idCliente;
        this.observacion = observacion;
        this.numero = numero;
        this.detalles = detalles;
    }

    public FacturaVentaDto() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public List<DetalleFacturaVentaDto> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFacturaVentaDto> detalles) {
        this.detalles = detalles;
    }
}
