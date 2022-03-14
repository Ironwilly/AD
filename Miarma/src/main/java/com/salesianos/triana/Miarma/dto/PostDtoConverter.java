package com.salesianos.triana.Miarma.dto;

import com.salesianos.triana.Miarma.models.Post;

import org.springframework.stereotype.Component;

@Component
public class PostDtoConverter {

    public CreatePostDto convertPostToCreatePostDto (Post p){

        return CreatePostDto.builder()
                .id(p.getUser().getId())
                .titulo(p.getTitulo())
                .descripcion(p.getDescripcion())
                .imagen(p.getImagen())
                .isPublic(p.getIsPublic())
                .build();







    }

    public GetPostDto getPostToPostDto(Post publi){

        return  GetPostDto.builder()

                .id(publi.getId())
                .titulo(publi.getTitulo())
                .descripcion(publi.getDescripcion())
                .imagen(publi.getImagen())
                .isPublic(publi.getIsPublic())
                .user(publi.getUser())
                .build();
    }


}
