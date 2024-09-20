package com.erp.springboot.backend.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.springboot.backend.models.entidades.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

}
