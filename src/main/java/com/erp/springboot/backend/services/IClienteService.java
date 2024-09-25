package com.erp.springboot.backend.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.erp.springboot.backend.models.entidades.Cliente;
import com.erp.springboot.backend.models.entidades.Factura;
import org.springframework.stereotype.Service;

@Service
public interface IClienteService {
	
	List<Cliente> findAll();
	
	Page<Cliente> findAll(Pageable pageable);
	
	Cliente findById(Long id);
	
	Cliente save(Cliente cliente);
	
	void delete(Long id);

	Factura findFacturaById(Long id);

	Factura saveFactura(Factura factura);

	void deleteFacturaById(Long id);

	List<Cliente> findByIdOrNombresOrDpiOrNitContainingIgnoreCase(String term);

}
