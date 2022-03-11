package com.salesianos.triana.Miarma.controller;


import com.salesianos.triana.Miarma.Repositorios.PostRepository;
import com.salesianos.triana.Miarma.dto.CreatePostDto;
import com.salesianos.triana.Miarma.models.Post;
import com.salesianos.triana.Miarma.services.impl.PostServiceImpl;
import com.salesianos.triana.Miarma.services.StorageService;
import com.salesianos.triana.Miarma.users.dto.CreateUserDto;
import com.salesianos.triana.Miarma.users.model.User;
import com.salesianos.triana.Miarma.users.repositorios.UserRepository;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;


@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImpl postService;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final StorageService storageService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha creado la publicación",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Post.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha creado la publicación",
                    content = @Content),
    })


    @PostMapping("/post")
    public ResponseEntity<Post> create(@RequestPart("post") CreatePostDto createPostDto, @RequestPart("file")MultipartFile file, @AuthenticationPrincipal User user) throws IOException {

        String name = storageService.store(file);
        String extension = StringUtils.getFilenameExtension(name);
        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        BufferedImage escaledImage = storageService.simpleResizer(originalImage, 1024);
        OutputStream outputStream = Files.newOutputStream(storageService.load(name));
        ImageIO.write(escaledImage,extension,outputStream);



        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(name)
                .toUriString();

        Post post10 = Post.builder()
                .titulo(createPostDto.getTitulo())
                .descripcion(createPostDto.getDescripcion())
                .imagen(uri)
                .user(user)
                .build();


        return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(createPostDto,file,user));
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<Post> edit(@PathVariable Long id, @RequestPart("post") CreatePostDto createPostDto, @RequestPart("file") MultipartFile file, CreateUserDto createUserDto) {
        return ResponseEntity.ok().body(postService.edit(id, createPostDto,file,createUserDto));



    }

    @GetMapping("/post/public")
    public ResponseEntity<?> listado(){
        return ResponseEntity.ok(postService.findAllPublicPosts());
    }

    @GetMapping("/post/all")
    public ResponseEntity<?> listadoCompleto(){
        return ResponseEntity.ok(postService.findAll());
    }


    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> removePostById(@PathVariable Long id,@AuthenticationPrincipal User user)throws  IOException {

            postService.removePostById(id, user);
            return ResponseEntity.noContent().build();
        }
    }









