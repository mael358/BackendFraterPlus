package com.erp.springboot.backend.controllers;
import com.erp.springboot.backend.models.dtos.Pedidos.PedidoDto;
import com.erp.springboot.backend.models.entidades.vistas.VwArticulosInventario;
import com.erp.springboot.backend.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.erp.springboot.backend.tool.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    private final utils Utils = new utils();

    @Autowired
    public InventarioController(InventarioService productService) {
        this.inventarioService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<VwArticulosInventario>> Busqueda(
            @RequestParam(required = false)String nombre,
            @RequestParam(required = false)Integer articuloid,
            Pageable pageable) {
        List<VwArticulosInventario> articulos = new ArrayList<>();

        if (articuloid != null && nombre != null) {
            List<VwArticulosInventario> listaNombre = inventarioService.findByNombre(nombre);
            List<VwArticulosInventario> listaArticulo = inventarioService.findByArticulo(articuloid);

            // Obtener intersección basada en el ID
            Set<Integer> idsPorArticulo = listaNombre.stream()
                    .map(VwArticulosInventario::getId)
                    .collect(Collectors.toSet());

            articulos = listaArticulo.stream()
                    .filter(pedido -> idsPorArticulo.contains(pedido.getId()))
                    .collect(Collectors.toList());

        } else if (articuloid != null) {
            articulos = inventarioService.findByArticulo(articuloid);
        } else if (nombre != null) {
            articulos = inventarioService.findByNombre(nombre);
        }else{
            articulos = inventarioService.findAll();
        }

        return ResponseEntity.ok(Utils.convertirListaAPagina(articulos,pageable));
    }
}