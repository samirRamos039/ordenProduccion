package com.example.produccion.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.produccion.repositories.userRepository;
import com.example.produccion.models.usuarios;

@Service
public class UserDS implements UserDetailsService {
    
    @Autowired
    private userRepository userRepository;

    @Overrride
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException{
        Optional <usuarios> users = userRepository.findByUsername(nombre);

        if(users.isPresent()){
           var userObj = users.get();
           return User.builder()
                      .username(userObj.getUsername())
                      .password(userObj.getPassword())
                      .roles(getR(userObj))
                      .build();
        } else {
            throw new UsernameNotFoundException(nombre);
        }
    }

    private String[] getR(usuarios myUser){
            if(myUser.getRole()== null){
                return new String[]{"USER"};
            }
        
            return myUser.getRole().split(",");
        }
}