package com.erp.springboot.backend.services;

import java.util.List;

import com.erp.springboot.backend.models.dao.IFacturaDao;
import com.erp.springboot.backend.models.entidades.Factura;
import com.erp.springboot.backend.services.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.springboot.backend.models.dao.IClienteDao;
import com.erp.springboot.backend.models.entidades.Cliente;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IFacturaDao facturaDao;

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}
	

	@Override
	@Transactional(readOnly=true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura saveFactura(Factura factura) {
		return facturaDao.save(factura);
	}

	@Override
	@Transactional
	public void deleteFacturaById(Long id) {
		facturaDao.deleteById(id);
	}

	@Override
	public List<Cliente> findByIdOrNombresOrDpiOrNitContainingIgnoreCase(String term) {
		return clienteDao.findByIdOrNombresOrDpiOrNitContainingIgnoreCase(term);
	}

}
