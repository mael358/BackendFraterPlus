package com.erp.springboot.backend.controllers;
import com.erp.springboot.backend.models.entidades.Proveedor;
import com.erp.springboot.backend.services.ProveedorService;
import com.erp.springboot.backend.tool.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    private final ProveedorService proveedorService;

    private final utils Utils = new utils();

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public ResponseEntity<Page<Proveedor>> ObtenerProveedores(Pageable pageable, @RequestParam(required = false) String filter) {
        List<Proveedor> proveedores = new ArrayList<>();

        if (filter != null ) {
            proveedores.addAll(proveedorService.findByNombre(filter));
        }else{
            proveedores.addAll(proveedorService.findAll());
        }
        return ResponseEntity.ok(Utils.convertirListaAPagina(proveedores,pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> ObtenerProveedorPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(proveedorService.findById(id));
    }
}
