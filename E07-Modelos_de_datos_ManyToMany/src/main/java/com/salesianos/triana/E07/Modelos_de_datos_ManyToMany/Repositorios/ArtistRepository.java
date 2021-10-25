package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.Repositorios;

import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist,Long> {



}
