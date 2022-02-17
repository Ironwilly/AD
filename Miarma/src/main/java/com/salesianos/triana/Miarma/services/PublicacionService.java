package com.salesianos.triana.Miarma.services;

import com.salesianos.triana.Miarma.Repositorios.PublicacionRepository;
import com.salesianos.triana.Miarma.dto.CreatePublicacionDto;
import com.salesianos.triana.Miarma.dto.PublicacionDtoConverter;
import com.salesianos.triana.Miarma.models.Publicacion;
import com.salesianos.triana.Miarma.services.base.BaseService;
import com.salesianos.triana.Miarma.users.model.Roles;
import com.salesianos.triana.Miarma.users.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService extends BaseService<Publicacion,Long, PublicacionRepository> {




    private final StorageService storageService;
    private final PublicacionRepository publicacionRepository;

    public PublicacionService(PublicacionDtoConverter publicacionDtoConverter, StorageService storageService, PublicacionRepository publicacionRepository) {

        this.storageService = storageService;
        this.publicacionRepository = publicacionRepository;
    }


    public List<Publicacion> listarPublicaciones(){
        return repositorio.findAll();
    }

    public Optional<Publicacion> findOne(Long id){
        return repositorio.findById(id);
    }

    public Publicacion savePublicacion(CreatePublicacionDto createPublicacionDto, MultipartFile file) {

        String filename = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(filename)
                .toUriString();

        return publicacionRepository.save(Publicacion.builder()


                        .titulo(createPublicacionDto.getTitulo())
                        .descripcion(createPublicacionDto.getDescripcion())
                        .imagen(uri)
                        .isPublic(createPublicacionDto.getIsPublic())
                        .build());









    }
}
