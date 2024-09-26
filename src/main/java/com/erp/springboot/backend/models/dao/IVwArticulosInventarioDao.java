package com.erp.springboot.backend.models.dao;

import com.erp.springboot.backend.models.entidades.Articulo;
import com.erp.springboot.backend.models.entidades.vistas.VwArticulosInventario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVwArticulosInventarioDao extends CrudRepository<VwArticulosInventario,Integer> {

    public List<VwArticulosInventario> findByDescripcionDeArticuloContainingIgnoreCase(String term);

    public List<VwArticulosInventario> findVwArticulosInventarioById(Integer id);
}
