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

    @GetMapping("/busqueda/{nombres}/{id}")
    public ResponseEntity<Page<PedidoDto>> ObtenerPedidosPorNombre(@PathVariable String nombres,@PathVariable Integer id, Pageable pageable){
        Optional<List<PedidoDto>> pedidoDtoOptional = Optional.ofNullable(pedidoService.findAllByNombre(nombres));
        Optional<List<PedidoDto>> pedidoDtoOptionalEstado = Optional.ofNullable(pedidoService.findAllByEstado(id));
        List<PedidoDto> pedidoDtos = pedidoDtoOptional.orElse(new ArrayList<>());
        pedidoDtos.addAll(pedidoDtoOptionalEstado.orElse(new ArrayList<>()));
        if ( (nombres==null||nombres=="") && id == null ){
            pedidoDtos.addAll(pedidoService.findAll());
        }
        return ResponseEntity.ok( Utils.convertirListaAPagina(pedidoDtoOptional.get(), pageable));
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

    @DeleteMapping
    public ResponseEntity<Pedido> EliminarPedido(@RequestBody Pedido pedido){
        pedidoService.delete(pedido.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
