package com.erp.springboot.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.erp.springboot.backend.models.entidades.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Integer> {

	@Query("select distinct c.municipio from Cliente c where c.id = ?1")
	public List<String> findAllMunicipios(int id);
}
