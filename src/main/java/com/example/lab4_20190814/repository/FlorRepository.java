package com.example.lab4_20190814.repository;

import com.example.lab4_20190814.entity.flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<flores, Long> {
}