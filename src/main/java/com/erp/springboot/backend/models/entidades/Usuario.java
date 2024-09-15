package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 150)
    @NotBlank
    private String nombre;

    @Size(max = 100)
    @NotNull
    @Column(name = "username", nullable = false, length = 100)
    @NotBlank
    private String username;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @NotNull
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = false;

    @Size(max = 150)
    @NotNull
    @Column(name = "apellido", nullable = false, length = 150)
    @NotBlank
    private String apellido;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    @NotBlank
    @Email
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}