package com.example.produccion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.produccion.models.inventario;

@Repository
public interface inventarioRepository extends CrudRepository<inventario, Integer> {
    
}
