package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombres", nullable = false, length = 150)
    private String nombres;


    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;

    @Size(max = 40)
    @NotNull
    @Column(name = "nit", nullable = false, length = 40)
    private String nit;

    @Size(max = 40)
    @Column(name = "DPI", length = 40)
    private String dpi;

    @Size(max = 30)
    @Column(name = "telefono", length = 30)
    private String telefono;

    @Size(max = 10)
    @Column(name = "extension", length = 10)
    private String extension;

    @Size(max = 150)
    @Column(name = "correo", length = 150)
    private String correo;

    public @Size(max = 30) String getTelefono() {
        return telefono;
    }

    public void setTelefono(@Size(max = 30) String telefono) {
        this.telefono = telefono;
    }

    public @Size(max = 10) String getExtension() {
        return extension;
    }

    public void setExtension(@Size(max = 10) String extension) {
        this.extension = extension;
    }

    public @Size(max = 150) String getCorreo() {
        return correo;
    }

    public void setCorreo(@Size(max = 150) String correo) {
        this.correo = correo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

}