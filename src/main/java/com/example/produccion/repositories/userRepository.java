package com.example.produccion.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.produccion.models.usuarios;

@Repository
public interface userRepository extends CrudRepository<usuarios, Integer>{

    Optional<usuarios> findByUsername(String username);
    
    
}
