package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.services;


import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.Repositorios.ArtistRepository;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Artist;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ArtistService extends BaseService<Artist,Long, ArtistRepository> {
}
