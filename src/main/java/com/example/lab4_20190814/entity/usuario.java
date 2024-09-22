package com.example.lab4_20190814.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "email", length = 100)
    private String email;
}
