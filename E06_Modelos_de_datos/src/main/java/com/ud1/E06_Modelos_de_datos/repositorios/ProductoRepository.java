package com.ud1.E06_Modelos_de_datos.repositorios;

import com.ud1.E06_Modelos_de_datos.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto, Long> {
}
