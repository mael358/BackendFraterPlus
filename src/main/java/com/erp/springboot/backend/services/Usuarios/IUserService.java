package com.erp.springboot.backend.services.Usuarios;


import com.erp.springboot.backend.models.dtos.Usuarios.UsuarioRequest;
import com.erp.springboot.backend.models.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Page<Usuario> findAll(Pageable pageable);

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    Optional<Usuario> update(UsuarioRequest usuario, Long id);

    void delete(Long id);

    List<Usuario> findByEnabledTrue();

    List<Usuario> findAll();

    List<Usuario> findByNombre(String nombre);
}
