package com.salesianostriana.dam.DanielOlivaRealState.controller;

import com.salesianostriana.dam.DanielOlivaRealState.dto.propietario.GetPropietarioViviendaDto;
import com.salesianostriana.dam.DanielOlivaRealState.dto.propietario.PropietarioDtoConverter;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.RolUsuario;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.Usuario;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Tag(name = "Propietario", description = "Controller de los propietarios")
@RequestMapping("/propietario/")
public class PropietarioController {

    private final UsuarioService usuarioService;
    private final PropietarioDtoConverter propietarioDtoConverter;
/*
    @Operation(summary = "Muestra una lista de todos los propietarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado los propietarios",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se han encontrado los propietarios",
                    content = @Content),
    })
    @GetMapping("/")
    public ResponseEntity<List<Usuario>> findAll(){

        List<Usuario> usuarios = usuarioService.loadUserByRol(RolUsuario.PROPIETARIO);

        if(usuarios.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            List<Usuario> lista = usuarios.stream()
                    .collect(Collectors.toList());

            return ResponseEntity.ok().body(lista);
        }
    }
*/

    @Operation(summary = "Muestra un propietario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado el propietario",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetPropietarioViviendaDto.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha encontrado el propietario",
                    content = @Content),
    })
    @GetMapping("{id}")
    public ResponseEntity<List<GetPropietarioViviendaDto>> findOne(@PathVariable UUID id, @AuthenticationPrincipal Usuario usuarioAuth){
        Optional<Usuario> propietario = usuarioService.loadUserById(id);

        if(!usuarioService.loadUserById(id).isEmpty() && !usuarioAuth.getRol().equals(RolUsuario.ADMIN) && !propietario.get().getId().equals(usuarioAuth.getId())){
            return ResponseEntity.notFound().build();
        }
        else{
            List<GetPropietarioViviendaDto> propietarioDTOS= propietario.stream()
                    .map(propietarioDtoConverter::propietarioToGetPropietarioViviendaDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(propietarioDTOS);
        }
    }

    @Operation(summary = "Borra un Propietario creado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Se ha borrado el propietario",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id, @AuthenticationPrincipal Usuario usuarioAuth) {

        Optional<Usuario> propietario = usuarioService.loadUserById(id);

        if(!usuarioService.loadUserById(id).isEmpty() && !usuarioAuth.getRol().equals(RolUsuario.ADMIN) && !propietario.get().getId().equals(usuarioAuth.getId())){
            return ResponseEntity.status(403).build();
        }
        else {
            usuarioService.deleteById(id);

            return ResponseEntity.noContent().build();
        }


    }

}
