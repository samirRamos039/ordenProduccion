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
import com.example.produccion.models.materiaP;
import com.example.produccion.services.materiService;


@RestController
@RequestMapping("/materiaPrima")
public class materiaController {


    @Autowired
    materiService materiService;

    @GetMapping
    public ArrayList<materiaP> getMateria(){
        return materiService.getMaterip();
    }

    @PostMapping
    public materiaP postMateria(@RequestBody materiaP mate){
        return this.materiService.saveMateria(mate);

    }

    @PutMapping("actualizar/{id}")
    public materiaP updateUser(@RequestBody materiaP materia,@PathVariable int id){
        materia.setId(id);
        return materiService.saveMateria(materia);

    }
    @DeleteMapping("/{id}")
    public void delUser(@PathVariable("id")int id){
        materiService.delectMateria(id);

    }
    
}
