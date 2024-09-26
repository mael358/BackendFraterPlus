package com.erp.springboot.backend.services.interfaces;

import com.erp.springboot.backend.models.entidades.vistas.VwArticulosInventario;

import java.util.List;

public interface IInventarioService {

    List<VwArticulosInventario> findAll();

    List<VwArticulosInventario> findByArticulo(int id);

    List<VwArticulosInventario> findByNombre(String nombre);
}
