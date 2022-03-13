package com.salesianos.triana.Miarma.services.impl;

import com.salesianos.triana.Miarma.Repositorios.PostRepository;
import com.salesianos.triana.Miarma.dto.CreatePostDto;
import com.salesianos.triana.Miarma.dto.GetPostDto;
import com.salesianos.triana.Miarma.dto.PostDtoConverter;
import com.salesianos.triana.Miarma.errors.exceptions.EntityNotFoundException;
import com.salesianos.triana.Miarma.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.Miarma.errors.exceptions.SingleEntityNotFoundException;
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
    public List<GetPostDto> findAll() {

        List<Post> postList = postRepository.findAll();

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

        Optional<Post> p = postRepository.findById(id);
        String filename = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(filename)
                .toUriString();

        if(p.isPresent()){
            Post postEncontrado = p.get();
            postEncontrado.setId(p.get().getId());
            postEncontrado.setTitulo(p.get().getTitulo());
            postEncontrado.setDescripcion(p.get().getDescripcion());
            postEncontrado.setImagen(uri);
            postEncontrado.setIsPublic(p.get().getIsPublic());

            return postRepository.save(postEncontrado);

        }else {
            throw new SingleEntityNotFoundException (id,Post.class);
        }


    }




    public void removePostById(Long id,User user) throws IOException {

       Optional<Post> post = postRepository.findById(id);


       if(post.isPresent()){
           Post postEncontrado = post.get();

           if(postEncontrado.getUser().getNick().equals(user.getNick())){
               String nombreImagen = StringUtils.cleanPath(postEncontrado.getImagen());
               String[] arrayNombre = nombreImagen.split("/");
               storageService.deleteFile(arrayNombre[arrayNombre.length - 1]);
               postRepository.deleteById(id);

           }
       }else{
           throw new SingleEntityNotFoundException(id,Post.class);
       }
            ;








        }



    }



