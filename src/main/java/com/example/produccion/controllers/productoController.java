package com.example.produccion.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.produccion.models.producto;
import com.example.produccion.services.productoService;

@RestController
@RequestMapping("/producto")
public class productoController {

    @Autowired
    productoService productoService;

    @GetMapping
    public ArrayList<producto> getUser(){
        return productoService.getProducto();
    }

    @PostMapping
    public producto postUser(@RequestBody producto produ){
        return this.productoService.saveProduct(produ);

    }
    
}
