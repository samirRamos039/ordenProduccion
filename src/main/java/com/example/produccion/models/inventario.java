package com.example.produccion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "inventario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class inventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String nombre;
    private int cantidad;
    private float kilos;
    private String descripcion;

    
   

}
