package com.example.produccion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.produccion.models.usuarios;

@Repository
public interface userRepository extends CrudRepository<usuarios, Long>{

    
    
}
