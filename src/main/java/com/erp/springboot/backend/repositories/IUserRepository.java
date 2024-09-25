package com.erp.springboot.backend.repositories;

import com.erp.springboot.backend.models.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findByEnabledTrue();

    Page<Usuario> findAll(Pageable pageable);

    Optional<Usuario> findByUsername(String name);

    List<Usuario> findByNombreContainsIgnoreCase(String nombre);
}
