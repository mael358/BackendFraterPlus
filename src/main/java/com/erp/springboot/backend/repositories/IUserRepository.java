package com.erp.springboot.backend.repositories;

import com.erp.springboot.backend.models.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findByEnabledTrue();

    Page<Usuario> findAll(Pageable pageable);
}
