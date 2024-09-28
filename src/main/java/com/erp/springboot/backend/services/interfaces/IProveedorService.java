package com.erp.springboot.backend.services.interfaces;

import com.erp.springboot.backend.models.dao.IProveedorDao;
import com.erp.springboot.backend.models.entidades.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IProveedorService {

    Proveedor findById(Integer id);

    List<Proveedor> findAll();

    List<Proveedor> findByNombre(String nombre);

    Proveedor save(Proveedor proveedor);

    Proveedor update(Proveedor proveedor);

    void delete(Integer id) throws Exception;

    List<Proveedor> findByNombresOrDireccionOrNitOrTelefonoOrCorreoContainingIgnoreCase(String term);
}
