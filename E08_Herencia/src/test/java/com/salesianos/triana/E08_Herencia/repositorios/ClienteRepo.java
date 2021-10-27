package com.salesianos.triana.E08_Herencia.repositorios;

import com.salesianos.triana.E08_Herencia.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente,Long> {
}
