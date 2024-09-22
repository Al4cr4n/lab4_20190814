package com.example.lab4_20190814.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carrito")
public class carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrito_id", nullable = false)
    private Integer carritoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flor_id", nullable = false)
    private flores flor;

    @Column(name = "cantidad")
    private Integer cantidad;
}
