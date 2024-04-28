package com.example.produccion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.produccion.models.producto;

@Repository
public interface productoRepository extends CrudRepository<producto, Integer>{

    
} 
