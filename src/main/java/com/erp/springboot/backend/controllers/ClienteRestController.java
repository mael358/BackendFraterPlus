package com.erp.springboot.backend.controllers;

import com.erp.springboot.backend.models.entidades.Cliente;
import com.erp.springboot.backend.services.IClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200", "https://clientes-crm-demo.web.app"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    private final IClienteService clienteService;

    @Autowired
    public ClienteRestController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public List<Cliente> index(){

        return clienteService.findAll();
    }

    @GetMapping("/clientes/page/{page}")
    public Page<Cliente> index(@PathVariable Integer page){
        Pageable pageable = PageRequest.of(page, 4);
        return clienteService.findAll(pageable);
    }

    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Cliente cliente = null;
        Map<String, Object> response = new HashMap<>();
        try {
            cliente = clienteService.findById(id);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(cliente == null) {
            response.put("mensaje", "El cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos :(")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    //@Secured("ROLE_ADMIN")
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {

        Cliente nuevoCliente = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '"+ err.getField() + "' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            nuevoCliente = clienteService.save(cliente);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ".concat(cliente.getNombres()).concat(" ha sido creado con exito!"));
        response.put("cliente", nuevoCliente);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //@Secured("ROLE_ADMIN")
    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {
        Cliente clienteActual = clienteService.findById(id);

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '"+ err.getField() + "' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if(clienteActual == null) {
            response.put("mensaje", "Error, nose pudo editar el cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos :(")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        Cliente clienteUpdated = null;
        try {
            clienteActual.setNombres(cliente.getNombres());
            // TODO: Agregar correo
            clienteActual.setFechaNacimiento(cliente.getFechaNacimiento());
            // TODO: Agregar direccion

            clienteUpdated = clienteService.save(clienteActual);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el update a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ".concat(clienteUpdated.getNombres()).concat(" ha sido actualizado con éxito!"));
        response.put("cliente", clienteUpdated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //@Secured("ROLE_ADMIN")
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            clienteService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el delete a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido eliminado con éxito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
