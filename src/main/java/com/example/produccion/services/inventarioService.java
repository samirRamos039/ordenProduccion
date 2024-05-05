package com.example.produccion.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.produccion.models.inventario;
import com.example.produccion.repositories.inventarioRepository;

@Service
public class inventarioService {
    
    @Autowired
    inventarioRepository inventarioRepository;
    
    public ArrayList<inventario> getInventario(){
        return (ArrayList<inventario>) inventarioRepository.findAll();
    }

    public inventario saveInventario(inventario inventa){
        return inventarioRepository.save(inventa);
    }

    public inventario updateUsers(inventario inventa){
        return inventarioRepository.save(inventa);
    }

    public void delectUser(int id){
        inventarioRepository.deleteById(id);
    }
}
