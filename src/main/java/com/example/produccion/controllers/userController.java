package com.example.produccion.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.produccion.models.usuarios;
import com.example.produccion.services.usuaservi;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    usuaservi userServices;

    @GetMapping
    public ArrayList<usuarios> getUser(){
        return userServices.getUsers();
    }

    @PostMapping
    public usuarios postUser(@RequestBody usuarios user){
        return this.userServices.saveUsers(user);

    }
    
}
