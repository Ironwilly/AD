package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.Repositorios;

import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
}
