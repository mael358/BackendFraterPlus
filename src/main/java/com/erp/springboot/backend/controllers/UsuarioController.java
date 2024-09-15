package com.erp.springboot.backend.controllers;


import com.erp.springboot.backend.models.entidades.Usuario;
import com.erp.springboot.backend.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UsuarioController {

    private final IUserService userService;

    @Autowired
    public UsuarioController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> list(){
        return new ResponseEntity<>(userService.findByEnabledTrue(), HttpStatus.OK);
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<Page<Usuario>> listPageable(@PathVariable Integer page){
        Pageable pageable = PageRequest.of(page, 4);
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
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
    public ResponseEntity<?> update(@RequestBody @Valid Usuario user, BindingResult result, @PathVariable Long id){
        // Validar errores
        ResponseEntity<?> errors = getErrors(result);
        if (errors != null) return errors;

        user.setId(id);
        Optional<Usuario> optionalUser = userService.findById(id);
        if(optionalUser.isPresent()){
            Usuario userToUpdate = optionalUser.get();
            userToUpdate.setNombre(user.getNombre());
            userToUpdate.setApellido(user.getApellido());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setUsername(user.getUsername());
            return ResponseEntity.ok(userService.save(userToUpdate));
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
