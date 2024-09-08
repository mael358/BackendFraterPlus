package com.erp.springboot.backend.services;


import com.erp.springboot.backend.models.entidades.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    void delete(Long id);
}
