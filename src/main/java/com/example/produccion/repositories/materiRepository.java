package com.example.produccion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.produccion.models.materiaP;

@Repository
public interface materiRepository extends CrudRepository<materiaP, Integer>{
    
}
