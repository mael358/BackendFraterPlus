package com.erp.springboot.backend.models.dtos.facturas;

import java.util.List;

public class FacturaCompraDto {
    private int idProveedor;
    private String observacion;
    private String numero;
    private List<DetalleFacturaCompraDto> detalles;

    public FacturaCompraDto(int idProveedor, String observacion, String numero, List<DetalleFacturaCompraDto> detalles) {
        this.idProveedor = idProveedor;
        this.observacion = observacion;
        this.numero = numero;
        this.detalles = detalles;
    }

    public FacturaCompraDto() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public List<DetalleFacturaCompraDto> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFacturaCompraDto> detalles) {
        this.detalles = detalles;
    }
}
