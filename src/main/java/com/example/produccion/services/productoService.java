package com.example.produccion.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.produccion.models.producto;
import com.example.produccion.repositories.productoRepository;

@Service
public class productoService {
    
    @Autowired
    productoRepository productoRepository;

    public ArrayList<producto> getProducto(){
        return (ArrayList<producto>) productoRepository.findAll();
    }

    public producto saveProduct(producto produ){
        return productoRepository.save(produ);
    }
   
}
