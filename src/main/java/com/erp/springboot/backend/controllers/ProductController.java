package com.erp.springboot.backend.controllers;


import com.erp.springboot.backend.models.entidades.Articulo;
import com.erp.springboot.backend.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articulos")
public class ProductController {

    private final ArticuloService productService;

    @Autowired
    public ProductController(ArticuloService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Articulo>> list(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
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
            productToUpdate.setValorCosto(product.getValorCosto());
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
}
