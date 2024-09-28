package com.erp.springboot.backend.controllers;
import java.util.List;
import com.erp.springboot.backend.models.dtos.facturas.FacturaCompraDto;
import com.erp.springboot.backend.models.dtos.facturas.FacturaDto;
import com.erp.springboot.backend.models.dtos.facturas.FacturaVentaDto;
import com.erp.springboot.backend.models.entidades.Factura;
import com.erp.springboot.backend.services.FacturaService;
import com.erp.springboot.backend.services.interfaces.IClienteService;
import com.erp.springboot.backend.tool.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FacturaRestController {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private FacturaService facturaService;

    private utils Utils = new utils();

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Factura show(@PathVariable Long id){
        return clienteService.findFacturaById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.deleteFacturaById(id);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura factura){
        return clienteService.saveFactura(factura);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("/facturas/compra")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Factura> crearCompra(@RequestBody FacturaCompraDto facturaDto) {
        Factura factura = facturaService.CrearCompra(facturaDto);
        return ResponseEntity.ok(factura);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("/facturas/venta")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Factura> crearVenta(@RequestBody FacturaVentaDto facturaDto) {
        Factura factura = facturaService.CrearVenta(facturaDto);
        return ResponseEntity.ok(factura);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/facturas/compra/{id}")
    public ResponseEntity<Factura> obtenerFacturaCompraPorId(@PathVariable int id) {
        Factura factura = facturaService.obtenerFacturaCompraPorId(id);
        return ResponseEntity.ok(factura);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/facturas/venta/{id}")
    public ResponseEntity<Factura> obtenerFacturaVentaPorId(@PathVariable int id) {
        Factura factura = facturaService.obtenerFacturaVentaPorId(id);
        return ResponseEntity.ok(factura);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/facturas/compra")
    public ResponseEntity<Page<Factura>> listarFacturasCompra(Pageable pageable) {
        List<Factura> facturas = facturaService.listarFacturasCompra();
        return ResponseEntity.ok(Utils.convertirListaAPagina(facturas,pageable));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/facturas/venta")
    public ResponseEntity<Page<Factura>> listarFacturasVenta(Pageable pageable) {
        List<Factura> facturas = facturaService.listarFacturasVenta();
        return ResponseEntity.ok(Utils.convertirListaAPagina(facturas,pageable));
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/facturas/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable int id, @RequestBody FacturaDto facturaDto) {
        Factura facturaActualizada = facturaService.actualizarFactura(id, facturaDto);
        return ResponseEntity.ok(facturaActualizada);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/facturas/anular/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable int id) {
        facturaService.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }

}
