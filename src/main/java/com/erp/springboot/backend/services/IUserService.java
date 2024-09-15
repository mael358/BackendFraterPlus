package com.erp.springboot.backend.services;


import com.erp.springboot.backend.models.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Page<Usuario> findAll(Pageable pageable);

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    void delete(Long id);

    List<Usuario> findByEnabledTrue();
}
