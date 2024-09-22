package com.example.lab4_20190814.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "flores")
public class flores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flor_id", nullable = false)
    private Long florId;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "imagen", length = 255)
    private String imagen;

    @Column(name = "precio", precision = 10, scale = 2)
    private Integer precio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "color", columnDefinition = "ENUM('Rojo', 'Amarillo', 'Blanco')")
    private String color;

    @Column(name = "tipo", columnDefinition = "ENUM('Rosa', 'Girasol', 'Lirio')")
    private String tipo;

    @Column(name = "ocasion", columnDefinition = "ENUM('Cumpleaños', 'Aniversario', 'Otro')")
    private String ocasion;

    @Column(name = "stock")
    private Integer stock;



}
