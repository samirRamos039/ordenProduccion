package com.example.produccion.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.produccion.models.materiaP;
import com.example.produccion.repositories.materiRepository;

@Service
public class materiService {
    
    @Autowired
    materiRepository materiRepository;

    public ArrayList<materiaP> getMaterip(){
        return (ArrayList<materiaP>) materiRepository.findAll();

    }

    public materiaP saveMateria(materiaP materia){
        return materiRepository.save(materia);
    }
    
}
