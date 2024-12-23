package com.erp.springboot.backend.controllers;
import com.erp.springboot.backend.models.entidades.Cliente;
import com.erp.springboot.backend.models.entidades.Proveedor;
import com.erp.springboot.backend.services.ProveedorService;
import com.erp.springboot.backend.tool.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"*"})
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

    @GetMapping("/filtrar-proveedores/{term}")
    public List<Proveedor> filtrarProductos(@PathVariable String term){
        return proveedorService.findByNombresOrDireccionOrNitOrTelefonoOrCorreoContainingIgnoreCase(term);
    }

    @PostMapping("/crear")
    public ResponseEntity<Proveedor> CrearProveedor(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.save(proveedor));
    }

    @PutMapping("/editar")
    public ResponseEntity<Proveedor> EditarProveedor(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.update(proveedor));
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Proveedor> eliminarProveedores(@RequestParam Integer id) throws Exception {
        proveedorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
