package com.erp.springboot.backend.repositories;

import com.erp.springboot.backend.models.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<Usuario, Long> {

}
