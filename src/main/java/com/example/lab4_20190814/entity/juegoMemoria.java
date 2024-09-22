package com.example.lab4_20190814.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "juegomemoria")
public class juegoMemoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "juego_id", nullable = false)
    private Integer juegoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuario usuario;  // Relación con la entidad Usuario

    @Column(name = "puntaje")
    private Integer puntaje;

    @Column(name = "fecha_juego")
    private LocalDateTime fechaJuego;
}
