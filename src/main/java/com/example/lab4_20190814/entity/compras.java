package com.example.lab4_20190814.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "compras")
public class compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id", nullable = false)
    private Integer compraId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flor_id", nullable = false)
    private flores flor;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;
}
