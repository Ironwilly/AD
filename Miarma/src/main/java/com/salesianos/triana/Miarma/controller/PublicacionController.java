package com.salesianos.triana.Miarma.controller;


import com.salesianos.triana.Miarma.dto.CreatePublicacionDto;
import com.salesianos.triana.Miarma.dto.PublicacionDtoConverter;
import com.salesianos.triana.Miarma.models.Publicacion;
import com.salesianos.triana.Miarma.services.impl.PublicacionServiceImpl;
import com.salesianos.triana.Miarma.services.StorageService;
import com.salesianos.triana.Miarma.users.dto.CreateUserDto;
import com.salesianos.triana.Miarma.users.model.User;
import com.salesianos.triana.Miarma.users.services.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class PublicacionController {

    private final PublicacionServiceImpl publicacionService;
    private final UserService userService;
    private final StorageService storageService;
    private final PublicacionDtoConverter publicacionDtoConverter;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha creado la publicación",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Publicacion.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha creado la publicación",
                    content = @Content),
    })

    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestPart("publicacion") CreatePublicacionDto newPublicacion, @RequestPart("file") MultipartFile file, User user) {

        Publicacion publicacionSaved = publicacionService.savePublicacion(newPublicacion,file,user);




        if (publicacionSaved == null)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(publicacionDtoConverter.getPublicacionToPublicacionDto(publicacionSaved));


    }

    @PutMapping("/post/{id}")
    public ResponseEntity<Publicacion> edit(@PathVariable Long id,@RequestPart("publicacion") CreatePublicacionDto createPublicacionDto,@RequestPart("file") MultipartFile file, CreateUserDto createUserDto) {
        return ResponseEntity.ok().body(publicacionService.edit(id, createPublicacionDto,file,createUserDto));


    }
/*
    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        publicacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

 */


}
