package com.erp.springboot.backend.models.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_rol", nullable = false)
    private Usuario usuarioid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rolid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Usuario usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Rol getRolid() {
        return rolid;
    }

    public void setRolid(Rol rolid) {
        this.rolid = rolid;
    }

}