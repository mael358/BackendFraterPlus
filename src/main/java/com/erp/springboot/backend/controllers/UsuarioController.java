package com.erp.springboot.backend.controllers;


import com.erp.springboot.backend.models.dtos.Usuarios.UsuarioRequest;
import com.erp.springboot.backend.models.entidades.Usuario;
import com.erp.springboot.backend.services.Usuarios.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.erp.springboot.backend.tool.utils;

import java.util.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = {"*"})
public class UsuarioController {

    private final IUserService userService;

    private utils Utils = new utils();

    @Autowired
    public UsuarioController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> listPageable(
            @RequestParam(required = false) String nombre,
            Pageable pageable){
        List<Usuario> usuarios = new ArrayList<>();
        if (nombre != null) {
            usuarios.addAll(userService.findByNombre(nombre));
        }else{
            usuarios.addAll(userService.findAll());
        }

        return new ResponseEntity<>(Utils.convertirListaAPagina(usuarios,pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get(@PathVariable Long id){
        Optional<Usuario> optionalUser =  userService.findById(id);
        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Usuario user, BindingResult result){
        // Validar errores
        ResponseEntity<?> errors = getErrors(result);
        if (errors != null) return errors;
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UsuarioRequest user, BindingResult result, @PathVariable Long id){
        // Validar errores
        ResponseEntity<?> errors = getErrors(result);
        if (errors != null) return errors;

        Optional<Usuario> optionalUser = userService.update(user, id);
        if (optionalUser.isPresent()){
            return ResponseEntity.ok(optionalUser.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Usuario> optionalUser = userService.findById(id);
        if(optionalUser.isPresent()){
            Usuario userToUpdate = optionalUser.get();
            userToUpdate.setEnabled(false);
            userService.save(userToUpdate);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> getErrors(BindingResult result) {
        if (result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> errors.put(err.getField(), "El campo " + err.getField()
                    + " contiene error. Error: " + err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        return null;
    }
}
