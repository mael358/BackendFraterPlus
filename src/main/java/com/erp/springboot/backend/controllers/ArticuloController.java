package com.erp.springboot.backend.controllers;


import com.erp.springboot.backend.models.dao.IArticuloDao;
import com.erp.springboot.backend.models.entidades.Articulo;
import com.erp.springboot.backend.services.interfaces.ArticuloService;
import com.erp.springboot.backend.tool.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200", "https://clientes-crm-demo.web.app", "*"})
@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    private final ArticuloService productService;

    private final IArticuloDao articuloDao;

    private final utils Utils = new utils();

    @Autowired
    public ArticuloController(ArticuloService productService, IArticuloDao articuloDao) {
        this.productService = productService;
        this.articuloDao = articuloDao;
    }

    @GetMapping()
    public ResponseEntity<Page<Articulo>> list(Pageable pageable){
        var listado = productService.findAll();
        return ResponseEntity.ok(Utils.convertirListaAPagina(listado, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> get(@PathVariable Long id){
        Optional<Articulo> optionalProduct =  productService.findById(id);
        return optionalProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Articulo> save(@RequestBody Articulo product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articulo> update(@PathVariable Long id, @RequestBody Articulo product){
        product.setId(id);
        Optional<Articulo> optionalProduct = productService.findById(id);
        if(optionalProduct.isPresent()){
            Articulo productToUpdate = optionalProduct.get();
            productToUpdate.setNombre(product.getNombre());
            productToUpdate.setValor_costo(product.getValor_costo());
            return ResponseEntity.ok(productService.save(productToUpdate));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Articulo product = new Articulo();
        product.setId(id);
        Optional<Articulo> optionalProduct = productService.delete(product);
        if(optionalProduct.isPresent()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filtrar-articulo/{term}")
    public List<Articulo> filtrarProductos(@PathVariable String term){
        return articuloDao.findByNombreOrDescripcionContainingIgnoreCase(term);
    }
}
