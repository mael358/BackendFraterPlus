package com.erp.springboot.backend.services;

import com.erp.springboot.backend.models.dao.IVwArticulosInventarioDao;
import com.erp.springboot.backend.models.entidades.vistas.VwArticulosInventario;
import com.erp.springboot.backend.services.interfaces.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService implements IInventarioService {

    @Autowired
    private IVwArticulosInventarioDao iVwArticulosInventarioDao;

    /**
     * @return
     */
    @Override
    public List<VwArticulosInventario> findAll() {
        return (List<VwArticulosInventario>) iVwArticulosInventarioDao.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<VwArticulosInventario> findByArticulo(int id) {
        return (List<VwArticulosInventario>) iVwArticulosInventarioDao.findVwArticulosInventarioById(id);
    }

    /**
     * @param nombre
     * @return
     */
    @Override
    public List<VwArticulosInventario> findByNombre(String nombre) {
        return (List<VwArticulosInventario>) iVwArticulosInventarioDao.findByDescripcionDeArticuloContainingIgnoreCase(nombre);
    }
}
