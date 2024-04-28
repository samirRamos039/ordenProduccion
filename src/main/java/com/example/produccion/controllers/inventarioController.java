package com.example.produccion.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.produccion.models.inventario;
import com.example.produccion.services.inventarioService;

public class inventarioController {

    @Autowired
    inventarioService inventarioService;

    @GetMapping
    public ArrayList<inventario> getI(){
        return inventarioService.getInventario();
    }

    @PostMapping
    public inventario postUser(@RequestBody inventario inventa){
        return this.inventarioService.saveInventario(inventa);

    }
    
}