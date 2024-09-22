package com.example.lab4_20190814.repository;

import com.example.lab4_20190814.entity.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<usuario, Integer> {

    // Este método permite buscar un usuario por su nickname
    usuario findByNickname(String nickname);
}

