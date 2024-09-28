package com.erp.springboot.backend.services;
import com.erp.springboot.backend.models.dao.IProveedorDao;
import com.erp.springboot.backend.models.entidades.Proveedor;
import com.erp.springboot.backend.services.interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorDao proveedorDao;

    /**
     * @param id
     * @return
     */
    @Override
    public Proveedor findById(Integer id) {
        return proveedorDao.findById(id).isPresent()?proveedorDao.findById(id).get():null;
    }

    /**
     * @return
     */
    @Override
    public List<Proveedor> findAll() {
        return (List<Proveedor>) proveedorDao.findAll();
    }

    /**
     * @param nombre
     * @return
     */
    @Override
    public List<Proveedor> findByNombre(String nombre) {
        return proveedorDao.findByNombresContainsIgnoreCase(nombre);
    }

    /**
     * @param proveedor
     */
    @Override
    public void save(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    /**
     * @param proveedor
     */
    @Override
    public void update(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Integer id) throws Exception {
        Proveedor proveedor = proveedorDao.findById(id).isPresent()?proveedorDao.findById(id).get():null;
        if (proveedor != null) {
            proveedorDao.delete(proveedor);
        }
        throw new Exception( "Proveedor no encontrado");
    }

    @Override
    public List<Proveedor> findByNombresOrDireccionOrNitOrTelefonoOrCorreoContainingIgnoreCase(String term) {
        return proveedorDao.findByNombresOrDireccionOrNitOrTelefonoOrCorreoContainingIgnoreCase(term);
    }
}
