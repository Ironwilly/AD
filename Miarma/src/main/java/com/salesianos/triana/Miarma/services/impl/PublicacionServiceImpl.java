package com.salesianos.triana.Miarma.services.impl;

import com.salesianos.triana.Miarma.Repositorios.PublicacionRepository;
import com.salesianos.triana.Miarma.dto.CreatePublicacionDto;
import com.salesianos.triana.Miarma.dto.GetPublicacionDto;
import com.salesianos.triana.Miarma.dto.PublicacionDtoConverter;
import com.salesianos.triana.Miarma.errors.exceptions.EntityNotFoundException;
import com.salesianos.triana.Miarma.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.Miarma.models.Publicacion;
import com.salesianos.triana.Miarma.services.PublicacionService;
import com.salesianos.triana.Miarma.services.StorageService;
import com.salesianos.triana.Miarma.users.dto.CreateUserDto;
import com.salesianos.triana.Miarma.users.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicacionServiceImpl implements PublicacionService {




    private final StorageService storageService;
    private final PublicacionRepository publicacionRepository;
    private final PublicacionDtoConverter publicacionDtoConverter;


    public PublicacionServiceImpl(StorageService storageService, PublicacionRepository publicacionRepository, PublicacionDtoConverter publicacionDtoConverter) {

        this.storageService = storageService;
        this.publicacionRepository = publicacionRepository;
        this.publicacionDtoConverter = publicacionDtoConverter;
    }

    @Override
    public List<GetPublicacionDto> findAllPublicPublicaciones(){

        List<Publicacion> publicacionList = publicacionRepository.findAllPublicPublicaciones();

        if (publicacionList.isEmpty()){
            throw new ListEntityNotFoundException(Publicacion.class);
        }else {
            List<GetPublicacionDto> result = publicacionList.stream()
                    .map(publicacionDtoConverter::getPublicacionToPublicacionDto)
                    .collect(Collectors.toList());
            return result;
        }

    }

    @Override
    public Optional<Publicacion> findOne(Long id){
        return publicacionRepository.findById(id);
    }

    @Override
    public Publicacion savePublicacion(CreatePublicacionDto createPublicacionDto, MultipartFile file, User user) {

        String filename = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(filename)
                .toUriString();

        return publicacionRepository.save(Publicacion.builder()
                        .titulo(createPublicacionDto.getTitulo())
                        .descripcion(createPublicacionDto.getDescripcion())
                        .imagen(uri)
                        .user(user)
                        .isPublic(createPublicacionDto.getIsPublic())
                        .user(user)
                        .build());




    }




    @Override
    public void deleteFile(String filename) {

    }


    @Override
    public Publicacion edit(Long id, CreatePublicacionDto createPublicacionDto, MultipartFile file,CreateUserDto createUserDto){



        String filename = storageService.store(file);


        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(filename)
                .toUriString();

         publicacionRepository.save(Publicacion.builder()


                .titulo(createPublicacionDto.getTitulo())
                .descripcion(createPublicacionDto.getDescripcion())
                .imagen(uri)
                .isPublic(createPublicacionDto.getIsPublic())
                .build());

        Optional<Publicacion> p = publicacionRepository.findById(id);
        if(p.isEmpty()){
            throw new EntityNotFoundException(id,Publicacion.class);
        }
        return p.map(nuevo ->{
            nuevo.setTitulo(createPublicacionDto.getTitulo());
            nuevo.setImagen(createPublicacionDto.getImagen());
            nuevo.setDescripcion(createPublicacionDto.getDescripcion());
            return nuevo;

        }).get();



    }




}
