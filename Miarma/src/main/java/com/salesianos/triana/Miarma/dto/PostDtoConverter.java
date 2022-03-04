package com.salesianos.triana.Miarma.dto;

import com.salesianos.triana.Miarma.models.Post;

import org.springframework.stereotype.Component;

@Component
public class PostDtoConverter {

    public Post createPostDto(CreatePostDto c){

        return new Post(
                c.getTitulo(),
                c.getDescripcion(),
                c.getImagen(),
                c.getIsPublic()


        );


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
