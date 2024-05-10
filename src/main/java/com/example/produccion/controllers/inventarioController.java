package com.example.produccion.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.produccion.models.inventario;
import com.example.produccion.services.inventarioService;

@RestController
@RequestMapping("/inventario")
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

    @PutMapping("actualizar/{id}")
    public inventario updateUser(@RequestBody inventario inventa,@PathVariable int id){
        inventa.setId(id);
        return inventarioService.saveInventario(inventa);

    }
    @DeleteMapping("/{id}")
    public void delUser(@PathVariable("id")int id){
        inventarioService.delectUser(id);

    }
    
}
