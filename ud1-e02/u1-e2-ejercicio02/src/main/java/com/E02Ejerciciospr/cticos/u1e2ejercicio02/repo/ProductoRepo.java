package com.E02Ejerciciospr.cticos.u1e2ejercicio02.repo;

import com.E02Ejerciciospr.cticos.u1e2ejercicio02.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepo extends JpaRepository <Producto, Long> {
}
