package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.Repositorios;

import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.AddedTo;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddedToRepository extends JpaRepository<AddedTo, Long>  {
}
