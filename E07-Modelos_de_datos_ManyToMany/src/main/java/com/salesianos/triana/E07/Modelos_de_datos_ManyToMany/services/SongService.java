package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.services;


import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.Repositorios.SongRepository;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Song;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SongService extends BaseService<Song,Long, SongRepository> {
}
