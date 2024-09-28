package com.erp.springboot.backend.services.interfaces;

import com.erp.springboot.backend.models.dao.IProveedorDao;
import com.erp.springboot.backend.models.entidades.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IProveedorService {

    Proveedor findById(Integer id);

    List<Proveedor> findAll();

    List<Proveedor> findByNombre(String nombre);

    void save(Proveedor proveedor);

    void update(Proveedor proveedor);

    void delete(Integer id) throws Exception;

    List<Proveedor> findByNombresOrDireccionOrNitOrTelefonoOrCorreoContainingIgnoreCase(String term);
}
