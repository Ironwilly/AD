package com.salesianostriana.dam.DanielOlivaRealState.usuarios.controller;

import com.salesianostriana.dam.DanielOlivaRealState.dto.interesado.GetInteresadoDto;
import com.salesianostriana.dam.DanielOlivaRealState.dto.interesado.GetInteresadoViviendaDto;
import com.salesianostriana.dam.DanielOlivaRealState.dto.interesado.InteresadoDtoConverter;
import com.salesianostriana.dam.DanielOlivaRealState.dto.propietario.PropietarioDtoConverter;
import com.salesianostriana.dam.DanielOlivaRealState.model.Vivienda;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.dto.CreateUsuarioDto;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.dto.GetUsuarioDto;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.dto.UsuarioDtoConverter;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.Usuario;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.services.UsuarioService;
import com.salesianostriana.dam.DanielOlivaRealState.util.pagination.PaginationLinksUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Controller de los usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioDtoConverter usuarioDtoConverter;
    private final InteresadoDtoConverter interesadoDtoConverter;
    private final PropietarioDtoConverter propietarioDtoConverter;
    private final PaginationLinksUtils paginationLinksUtils;

    @Operation(summary = "Crea un nuevo usuario propietario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado el nuevo usuario propietario",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetUsuarioDto.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha creado el nuevo usuario propietario",
                    content = @Content),
    })
    @PostMapping("/auth/register/user")
    public ResponseEntity<GetUsuarioDto> nuevoPropietario(@RequestBody CreateUsuarioDto nuevoPropietario) {
        Usuario nuevo = usuarioService.savePropietario(nuevoPropietario);

        if (nuevo == null)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(usuarioDtoConverter.usuarioEntityToGetUsuarioDto(nuevo));

    }

    @Operation(summary = "Crea un nuevo usuario gestor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado el nuevo usuario gestor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetUsuarioDto.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha creado el nuevo usuario gestor",
                    content = @Content),
    })
    @PostMapping("/auth/register/gestor")
    public ResponseEntity<GetUsuarioDto> nuevoGestor(@RequestBody CreateUsuarioDto nuevoGestor) {
        Usuario nuevo = usuarioService.saveGestor(nuevoGestor);

        if (nuevo == null)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(usuarioDtoConverter.usuarioEntityToGetUsuarioDto(nuevo));

    }

    @Operation(summary = "Crea un nuevo usuario admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado el nuevo usuario admin",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetUsuarioDto.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha creado el nuevo usuario admin",
                    content = @Content),
    })
    @PostMapping("/auth/register/admin")
    public ResponseEntity<GetUsuarioDto> nuevoAdmin(@RequestBody CreateUsuarioDto nuevoAdmin) {
        Usuario nuevo = usuarioService.saveAdmin(nuevoAdmin);

        if (nuevo == null)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(usuarioDtoConverter.usuarioEntityToGetUsuarioDto(nuevo));

    }

    // INTERESADOS

    @Operation(summary = "Obtiene todos los interesados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han listado todos los interesados",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetInteresadoDto.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se han listado los interesados",
                    content = @Content),
    })
    @GetMapping("/interesado/")
    public ResponseEntity<List<GetInteresadoDto>> findAllPropietarios(){

        List<Usuario> data = usuarioService.findAll();

        if (data.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            List<GetInteresadoDto> result =
                    data.stream()
                            .map(interesadoDtoConverter::interesadoToGetInteresadoDto)
                            .collect(Collectors.toList());
            return ResponseEntity.ok().body(result);
        }

    }

    @Operation(summary = "Obtiene el interesado que le indicamos por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado el interesado especificado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetInteresadoViviendaDto.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha encontrado el interesado",
                    content = @Content),
    })
    @GetMapping("/interesado/{id}")
    public ResponseEntity<List<GetInteresadoViviendaDto>> findOneInteresado(@PathVariable UUID id){
        Optional<Usuario> data = usuarioService.findById(id);

        if (data.isEmpty()) {

            return ResponseEntity.notFound().build();

        } else {
            List<GetInteresadoViviendaDto> interesadoDto = data
                    .stream().map(interesadoDtoConverter :: interesadoToGetInteresadoViviendaDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(interesadoDto);

        }
    }

}
