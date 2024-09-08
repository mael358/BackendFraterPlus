package com.erp.springboot.backend.controllers.back_end_spring_rest.repositories;


import com.erp.springboot.backend.controllers.back_end_spring_rest.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
