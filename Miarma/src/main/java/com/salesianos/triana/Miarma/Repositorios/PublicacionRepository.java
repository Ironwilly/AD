package com.salesianos.triana.Miarma.Repositorios;

import com.salesianos.triana.Miarma.models.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PublicacionRepository extends JpaRepository<Publicacion,Long> {


    //List<Publicacion> findAll (Publicacion publicacion);
}
