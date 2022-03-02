package com.salesianos.triana.Miarma.services.impl;

import com.salesianos.triana.Miarma.Repositorios.PostRepository;
import com.salesianos.triana.Miarma.dto.CreatePostDto;
import com.salesianos.triana.Miarma.dto.GetPostDto;
import com.salesianos.triana.Miarma.dto.PostDtoConverter;
import com.salesianos.triana.Miarma.errors.exceptions.EntityNotFoundException;
import com.salesianos.triana.Miarma.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.Miarma.models.Post;
import com.salesianos.triana.Miarma.services.PostService;
import com.salesianos.triana.Miarma.services.StorageService;
import com.salesianos.triana.Miarma.users.dto.CreateUserDto;
import com.salesianos.triana.Miarma.users.model.User;
import io.jsonwebtoken.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {




    private final StorageService storageService;
    private final PostRepository postRepository;
    private final PostDtoConverter postDtoConverter;


    public PostServiceImpl(StorageService storageService, PostRepository postRepository, PostDtoConverter postDtoConverter) {

        this.storageService = storageService;
        this.postRepository = postRepository;
        this.postDtoConverter = postDtoConverter;
    }


    public List<GetPostDto> findAllPublicPosts(){

        List<Post> postList = postRepository.findAllPublicPosts();

        if (postList.isEmpty()){
            throw new ListEntityNotFoundException(Post.class);
        }else {
            List<GetPostDto> result = postList.stream()
                    .map(postDtoConverter::getPostToPostDto)
                    .collect(Collectors.toList());
            return result;
        }

    }




    @Override
    public Optional<Post> findOne(Long id){
        return postRepository.findById(id);
    }



    @Override
    public Post savePost(CreatePostDto createPostDto, MultipartFile file, User user) {

        String filename = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(filename)
                .toUriString();

        return postRepository.save(Post.builder()
                        .titulo(createPostDto.getTitulo())
                        .descripcion(createPostDto.getDescripcion())
                        .imagen(uri)
                        .user(user)
                        .isPublic(createPostDto.getIsPublic())
                        .user(user)
                        .build());




    }




    @Override
    public Post edit(Long id, CreatePostDto createPostDto, MultipartFile file, CreateUserDto createUserDto){



        String filename = storageService.store(file);


        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(filename)
                .toUriString();

         postRepository.save(Post.builder()


                .titulo(createPostDto.getTitulo())
                .descripcion(createPostDto.getDescripcion())
                .imagen(uri)
                .isPublic(createPostDto.getIsPublic())
                .build());

        Optional<Post> p = postRepository.findById(id);
        if(p.isEmpty()){
            throw new EntityNotFoundException(id, Post.class);
        }
        return p.map(nuevo ->{
            nuevo.setTitulo(createPostDto.getTitulo());
            nuevo.setImagen(createPostDto.getImagen());
            nuevo.setDescripcion(createPostDto.getDescripcion());
            return nuevo;

        }).get();



    }




    public void removePostById(Long id) throws IOException {

       Optional<Post> post = postRepository.findById(id);


            storageService.deleteFile(post.get().getImagen());
            postRepository.delete(post.get());








        }



    }


//}
