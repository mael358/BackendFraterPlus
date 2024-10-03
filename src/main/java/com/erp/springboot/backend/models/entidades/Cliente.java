package com.erp.springboot.backend.models.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombres", nullable = false, length = 150)
    private String nombres;

    @Column(name = "fecha_creacion")
    private Instant fechaCreacion;

    @Column(name = "edad")
    private Integer edad;

    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;

    @Size(max = 40)
    @Column(name = "nit", length = 40)
    private String nit;

    @Size(max = 40)
    @Column(name = "DPI", length = 40)
    private String dpi;

    //Add correo
    @Size(max = 40)
    @Column(name = "correo", length = 40)
    private String correo;

    //Add telefono
    @Size(max = 40)
    @Column(name = "telefono", length = 40)
    private String telefono;

    //Add extension
    @Size(max = 40)
    @Column(name = "extension", length = 40)
    private String extension;



    public Cliente() {
    }

    public Cliente(Long id, String nombres, Instant fechaCreacion, Integer edad, String direccion, String nit, String dpi) {
        this.id = id;
        this.nombres = nombres;
        this.fechaCreacion = fechaCreacion;
        this.edad = edad;
        this.direccion = direccion;
        this.nit = nit;
        this.dpi = dpi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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

    public @Size(max = 40) String getCorreo() {
        return correo;
    }

    public void setCorreo(@Size(max = 40) String correo) {
        this.correo = correo;
    }

    public @Size(max = 40) String getTelefono() {
        return telefono;
    }

    public void setTelefono(@Size(max = 40) String telefono) {
        this.telefono = telefono;
    }

    public @Size(max = 40) String getExtension() {
        return extension;
    }

    public void setExtension(@Size(max = 40) String extension) {
        this.extension = extension;
    }
}