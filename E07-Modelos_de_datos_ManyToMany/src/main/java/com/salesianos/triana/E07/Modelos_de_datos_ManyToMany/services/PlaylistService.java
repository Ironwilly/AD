package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.services;


import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.Repositorios.PlaylistRepository;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Playlist;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService extends BaseService<Playlist,Long,PlaylistRepository> {
}
