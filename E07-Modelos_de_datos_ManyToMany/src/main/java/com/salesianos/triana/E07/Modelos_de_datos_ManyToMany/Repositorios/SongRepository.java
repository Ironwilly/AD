package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.Repositorios;

import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Artist;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByArtist(Artist artist);
}
