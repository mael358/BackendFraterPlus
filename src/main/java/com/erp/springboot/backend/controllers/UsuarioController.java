package com.erp.springboot.backend.controllers;


import com.erp.springboot.backend.models.entidades.Usuario;
import com.erp.springboot.backend.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final IUserService userService;

    @Autowired
    public UsuarioController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> list(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Usuario> get(@PathVariable Long id){
        Optional<Usuario> optionalUser =  userService.findById(id);
        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario user){
        user.setId(id);
        Optional<Usuario> optionalUser = userService.findById(id);
        if(optionalUser.isPresent()){
            Usuario userToUpdate = optionalUser.get();
            userToUpdate.setNombre(user.getNombre());
            userToUpdate.setApellido(user.getApellido());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setEnabled(user.getEnabled());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setUsername(user.getUsername());
            return ResponseEntity.ok(userService.save(userToUpdate));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }





}
