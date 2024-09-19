package com.erp.springboot.backend.repositories;

import java.util.Optional;

import com.erp.springboot.backend.models.entidades.Rol;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Rol, Long>{

    Optional<Rol> findByNombre(String name);

}
