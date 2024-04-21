package com.example.produccion.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.produccion.models.usuarios;
import com.example.produccion.repositories.userRepository;

@Service
public class usuaservi {

    @Autowired
    userRepository userRepository;

    public ArrayList<usuarios> getUsers(){
        return (ArrayList<usuarios>) userRepository.findAll();
    }

    public usuarios saveUsers(usuarios user){
        return userRepository.save(user);
    }
    
}
