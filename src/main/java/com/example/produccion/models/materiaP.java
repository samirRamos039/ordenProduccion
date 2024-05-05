package com.example.produccion.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "materiaPrima")
@Getter
@Setter
@AllArgsConstructor
public class materiaP {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private float ancho;
    private float calibre;
    private float kilos;
    private int cantidad;
    
    
    
}
