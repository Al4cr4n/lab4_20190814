package com.example.lab4_20190814.repository;

import com.example.lab4_20190814.entity.carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoRepository extends JpaRepository<carrito, Integer> {
    List<carrito> findByUsuarioUsuarioId(Integer usuarioId);
}
