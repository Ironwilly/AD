package com.salesianos.triana.Miarma.services.impl;

import com.salesianos.triana.Miarma.Repositorios.PostRepository;
import com.salesianos.triana.Miarma.dto.CreatePostDto;
import com.salesianos.triana.Miarma.dto.GetPostDto;
import com.salesianos.triana.Miarma.dto.PostDtoConverter;
import com.salesianos.triana.Miarma.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.Miarma.errors.exceptions.SingleEntityNotFoundException;
import com.salesianos.triana.Miarma.models.Post;
import com.salesianos.triana.Miarma.services.PostService;
import com.salesianos.triana.Miarma.services.StorageService;
import com.salesianos.triana.Miarma.users.dto.CreateUserDto;
import com.salesianos.triana.Miarma.users.model.User;
import com.salesianos.triana.Miarma.users.repositorios.UserRepository;
import io.jsonwebtoken.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
    public GetPostDto findOne(Long id, User user){

        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()){
            throw new SingleEntityNotFoundException(id, Post.class);
        }else{
            return postDtoConverter.getPostToPostDto(post.get());





        }


    }
/*
    @Override
    public List<GetPostDto> findPostByNick(String nick, User user) {


        List<Post> postList1 = postRepository.findPostByNick(user.getNick());

        if(postList1.isEmpty()){
            return Collections.EMPTY_LIST;
        }else {
            return postList1.stream().map(postDtoConverter::getPostToPostDto).collect(Collectors.toList());
        }



    }
    */


    @Override
    public CreatePostDto savePost(CreatePostDto createPostDto, MultipartFile file, User user) {

        String filename = storageService.store(file);
        String extension = StringUtils.getFilenameExtension(filename);


        if (extension.equals("avi") || extension.equals("mpg") || extension.equals("mp4") || extension.equals("mkv") || extension.equals("flv") || extension.equals("wmv") || extension.equals("divx") || extension.equals("h.264") || extension.equals("xvid") || extension.equals("rm")) {


            String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(filename)
                    .toUriString();

            Post p = postRepository.save(Post.builder()

                    .titulo(createPostDto.getTitulo())
                    .descripcion(createPostDto.getDescripcion())
                    .imagen(uri)
                    .user(user)
                    .isPublic(createPostDto.getIsPublic())
                    .build());

            return postDtoConverter.convertPostToCreatePostDto(Post.builder()
                    .titulo(p.getTitulo())
                    .descripcion(p.getDescripcion())
                    .imagen(p.getImagen())
                    .isPublic(p.getIsPublic())
                    .build());


        }else {

            String filenameScale = storageService.storeScale(file);

            String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(filename)
                    .toUriString();

            String uriScale = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(filenameScale)
                    .toUriString();

            Post post = postRepository.save(Post.builder()

                    .titulo(createPostDto.getTitulo())
                    .descripcion(createPostDto.getDescripcion())
                    .imagen(uri)
                    .imagen(uriScale)
                    .user(user)
                    .isPublic(createPostDto.getIsPublic())
                    .build());

            return postDtoConverter.convertPostToCreatePostDto(Post.builder()
                    .titulo(post.getTitulo())
                    .descripcion(post.getDescripcion())
                    .imagen(post.getImagen())
                    .isPublic(post.getIsPublic())
                    .user(post.getUser())
                    .build());

        }

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

    @Override
    public void removePostById(Long id,User user) throws IOException {

       Optional<Post> data = postRepository.findById(id);


       if(data.isEmpty()){

           throw new SingleEntityNotFoundException(id,Post.class);



           }
       else{
           String name = StringUtils.cleanPath(String.valueOf(data.get().getImagen())).replace("http://localhost:8080/download/", "")
                   .replace("%20", " ");

           Path pa = storageService.load(name);

           String filename = StringUtils.cleanPath(String.valueOf(pa)).replace("http://localhost:8080/download/", "")
                   .replace("%20", " ");

           Path path = Paths.get(filename);
           storageService.deleteFile(path.toString());
           postRepository.deleteById(id);
       }

       }



    }



