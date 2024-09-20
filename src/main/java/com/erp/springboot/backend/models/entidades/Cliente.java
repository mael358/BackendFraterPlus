package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombres", nullable = false, length = 150)
    private String nombres;

    @Size(max = 150)
    @NotNull
    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Column(name = "fechaNacimiento")
    private Instant fechaNacimiento;

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

    public Cliente() {
    }

    public Cliente(Long id, String nombres, String apellidos, Instant fechaNacimiento, Integer edad, String direccion, String nit, String dpi) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Instant getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Instant fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

}