package com.salesianos.triana.E08_Herencia.repositorios;

import com.salesianos.triana.E08_Herencia.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepo extends JpaRepository<Empleado,Long> {
}
