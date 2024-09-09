package com.erp.springboot.backend.controllers;

import com.erp.springboot.backend.models.dtos.PedidoDto;
import com.erp.springboot.backend.models.entidades.Pedido;
import com.erp.springboot.backend.models.entidades.Usuario;
import com.erp.springboot.backend.services.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

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

    @GetMapping
    public ResponseEntity<List<PedidoDto>> ObtenerPedidos(){
        return  ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAll());
    }

    @PostMapping
    public ResponseEntity<PedidoDto> CrearPedido(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedido));
    }

    @PutMapping
    public ResponseEntity<PedidoDto> ActualizarPedido(@RequestBody Pedido pedido){
        Optional<PedidoDto> pedidoOptional = Optional.ofNullable(pedidoService.findById(pedido.getId()));
        if(pedidoOptional.isPresent()){
            pedidoService.save(pedido);
            return ResponseEntity.status(HttpStatus.OK).body(new PedidoDto(pedido));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Pedido> EliminarPedido(@RequestBody Pedido pedido){
        pedidoService.delete(pedido.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
