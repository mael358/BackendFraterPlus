package com.erp.springboot.backend.controllers;
import com.erp.springboot.backend.models.dtos.Pedidos.PedidoCreateDto;
import com.erp.springboot.backend.models.dtos.Pedidos.PedidoDto;
import com.erp.springboot.backend.models.entidades.Pedido;
import com.erp.springboot.backend.services.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.erp.springboot.backend.tool.utils;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private utils Utils = new utils();
    private final IPedidoService pedidoService;

    @Autowired
    public PedidoController(IPedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> ObtenerPedido(@PathVariable int id){
        Optional<PedidoDto> pedidoOptional = Optional.ofNullable(pedidoService.findById(id));
        return pedidoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/busqueda")
    public ResponseEntity<Page<PedidoDto>> obtenerPedidos(
            @RequestParam(required = false) String nombres,
            @RequestParam(required = false) Integer estado,
            Pageable pageable) {

        List<PedidoDto> pedidos;

        if ((nombres == null || nombres.isEmpty()) && estado == null) {
            // Ningún parámetro proporcionado, retornar todos
            pedidos = pedidoService.findAll();
        } else if ((nombres != null && !nombres.isEmpty()) && estado != null) {
            // Ambos parámetros proporcionados, obtener intersección
            List<PedidoDto> pedidosPorNombre = pedidoService.findAllByNombre(nombres);
            List<PedidoDto> pedidosPorEstado = pedidoService.findAllByEstado(estado);

            // Obtener intersección basada en el ID
            Set<Integer> idsPorEstado = pedidosPorEstado.stream()
                    .map(PedidoDto::getId)
                    .collect(Collectors.toSet());

            pedidos = pedidosPorNombre.stream()
                    .filter(pedido -> idsPorEstado.contains(pedido.getId()))
                    .collect(Collectors.toList());
        } else if (nombres != null && !nombres.isEmpty()) {
            // Solo 'nombres' proporcionado
            pedidos = pedidoService.findAllByNombre(nombres);
        } else {
            // Solo 'id' proporcionado
            pedidos = pedidoService.findAllByEstado(estado);
        }

        // lista a una página
        Page<PedidoDto> pagina = Utils.convertirListaAPagina(pedidos, pageable);

        return ResponseEntity.ok(pagina);
    }


    @GetMapping
    public ResponseEntity<List<PedidoDto>> ObtenerPedidos(){
        return  ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAll());
    }

    @PostMapping
    public ResponseEntity<PedidoDto> CrearPedido(@RequestBody PedidoCreateDto pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> ActualizarPedido(@PathVariable int id, @RequestBody PedidoCreateDto pedido){
        Optional<PedidoDto> pedidoOptional = Optional.ofNullable(pedidoService.findById(id));
        if(pedidoOptional.isPresent()){
            pedidoService.save(pedido);
            return ResponseEntity.status(HttpStatus.OK).body(pedidoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> AnularPedido(@PathVariable int id){
        pedidoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
