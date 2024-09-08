package com.erp.springboot.backend.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.erp.springboot.backend.models.entidades.Cliente;
import com.erp.springboot.backend.models.entidades.Factura;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(int id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(int id);

	public Factura findFacturaById(Long id);

	public Factura saveFactura(Factura factura);

	public void deleteFacturaById(Long id);

	public List<String> findAllMunicipios(int id);

}
