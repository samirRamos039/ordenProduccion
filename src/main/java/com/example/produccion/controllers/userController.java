package com.example.produccion.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.produccion.models.usuarios;
import com.example.produccion.services.usuaservi;

@RestController
@RequestMapping("/usuario")
public class userController {

    @Autowired
    usuaservi userServices;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ArrayList<usuarios> getUser(){
        return userServices.getUsers();
    }

    
    @PostMapping
    public usuarios postUser(@RequestBody usuarios user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userServices.saveUsers(user);

    }
    @PutMapping("actualizar/{id}")
    public usuarios updateUser(@RequestBody usuarios user,@PathVariable int id){
        user.setId(id);
        return userServices.saveUsers(user);

    }
    @DeleteMapping("/{id}")
    public void delUser(@PathVariable("id")int id){
        userServices.delectUser(id);

    }
    
}
