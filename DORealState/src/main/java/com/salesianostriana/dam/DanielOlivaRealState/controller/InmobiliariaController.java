
package com.salesianostriana.dam.DanielOlivaRealState.controller;

import com.salesianostriana.dam.DanielOlivaRealState.dto.inmobiliaria.CreateInmobiliariaDto;
import com.salesianostriana.dam.DanielOlivaRealState.dto.inmobiliaria.GetInmobiliariaDto;
import com.salesianostriana.dam.DanielOlivaRealState.dto.inmobiliaria.GetInmobiliariaViviendaDto;
import com.salesianostriana.dam.DanielOlivaRealState.dto.inmobiliaria.InmobiliariaDtoConverter;
import com.salesianostriana.dam.DanielOlivaRealState.dto.propietario.GetPropietarioViviendaDto;
import com.salesianostriana.dam.DanielOlivaRealState.model.Inmobiliaria;
import com.salesianostriana.dam.DanielOlivaRealState.model.Vivienda;
import com.salesianostriana.dam.DanielOlivaRealState.services.InmobiliariaService;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.dto.CreateUsuarioDto;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.RolUsuario;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inmobiliaria/")
@Tag(name = "Inmobiliaria", description = "Controller de las inmobiliarias")
@RequiredArgsConstructor
public class InmobiliariaController {

    private final InmobiliariaService inmobiliariaService;
    private final InmobiliariaDtoConverter inmobiliariaDtoConverter;
    private final PaginationLinksUtils paginationLinksUtils;
    private final UsuarioService usuarioService;

    @Operation(summary = "Muestra una lista de todas las inmobiliarias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado las inmobiliarias",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetInmobiliariaDto.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se han encontrado las inmobiliarias",
                    content = @Content),
    })
    @GetMapping("")
    public ResponseEntity<Page<GetInmobiliariaDto>> findAll(@PageableDefault(size = 8, page = 0) Pageable pageable, HttpServletRequest request) {

        Page<Inmobiliaria> data = inmobiliariaService.findAll(pageable);

        if (data.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Page<GetInmobiliariaDto> result = data.map(inmobiliariaDtoConverter::inmobiliariaToGetInmobiliariaDto);

            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

            return ResponseEntity.ok().header("link", paginationLinksUtils.createLinkHeader(result, uriBuilder)).body(result);
        }

    }


    @Operation(summary = "Muestra una inmobiliaria y sus viviendas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado la inmobiliaria",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetInmobiliariaViviendaDto.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha encontrado la inmobiliaria",
                    content = @Content),
    })
    @GetMapping("{id}")
    public ResponseEntity<List<GetInmobiliariaViviendaDto>> findOne(@PathVariable Long id) {

        Optional<Inmobiliaria> inmobiliaria = inmobiliariaService.findById(id);

        if (inmobiliaria.isEmpty()) {

            return ResponseEntity.notFound().build();

        } else {

            List<GetInmobiliariaViviendaDto> result =
                    inmobiliaria.stream()
                            .map(inmobiliariaDtoConverter::inmobiliariaToGetInmobiliariaViviendaDto)
                            .collect(Collectors.toList());

            return ResponseEntity.ok().body(result);

        }


    }

    @Operation(summary = "Crea una nueva inmobiliaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han creado la inmobiliaria",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Inmobiliaria.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha creado la inmobiliaria",
                    content = @Content),
    })
    @PostMapping("")
    public ResponseEntity<Inmobiliaria> create(@RequestBody CreateInmobiliariaDto dto) {
        if (dto.getNombre().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {

            Inmobiliaria nueva = inmobiliariaDtoConverter.createInmpbiliariaDtoToInmobiliaria(dto);

            return ResponseEntity.status(HttpStatus.CREATED).body(inmobiliariaService.save(nueva));

        }

    }

    @Operation(summary = "Borra una inmobiliaria en base a su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Se ha borrado la inmobiliaria",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha borrado la inmobiliaria",
                    content = @Content),
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteInmobiliaria(@PathVariable Long id) {

        if(inmobiliariaService.findById(id).isEmpty() ){
            return ResponseEntity.notFound().build();
        }else {
            Optional<Inmobiliaria> inmobiliaria=inmobiliariaService.findById(id);

            for (Vivienda vivienda : inmobiliaria.get().getViviendas()) {
                vivienda.setInmobiliaria(null);
            }

            for (Usuario gestor : inmobiliaria.get().getGestores()) {
                gestor.setInmobiliaria(null);
            }

            inmobiliariaService.deleteById(id);

            return ResponseEntity.noContent().build();
        }

    }

    @Operation(summary = "Crea un nuevo gestor a la inmobiliaria indicada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado el gestor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Inmobiliaria.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha creado el gestor",
                    content = @Content),
    })
    @PostMapping("{id}/gestor")
    public ResponseEntity<Inmobiliaria> createInmobiliariaWithGestor (@PathVariable Long id, @RequestBody CreateUsuarioDto gestorDto, @AuthenticationPrincipal Usuario usuarioAuth) {

        Optional<Inmobiliaria> inmobiliaria = inmobiliariaService.findById(id);

        Boolean comprobacion = false;
        for (Usuario gestor : inmobiliaria.get().getGestores()) {
            if (gestor.getId().equals(usuarioAuth.getId())) {
                comprobacion = true;
            }
        }

        if (!usuarioAuth.getRol().equals(RolUsuario.ADMIN) && !comprobacion) {
            return ResponseEntity.notFound().build();
        } else {
            usuarioService.saveGestorWithoutId(gestorDto,inmobiliaria.get());
            inmobiliariaDtoConverter.inmobiliariaToGetInmobiliariaDto(inmobiliaria.get());

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(inmobiliariaService.save(inmobiliaria.get()));

        }

    }

    @Operation(summary = "Muestra una lista de los gestores de una inmobiliaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado los gestores de la inmobiliaria",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Inmobiliaria.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se han encontrado los gestores la inmobiliaria",
                    content = @Content),
    })
    @GetMapping("{id}/gestor")
    public ResponseEntity<Inmobiliaria> getGestoresOfInmobiliaria(@PathVariable Long id, @AuthenticationPrincipal Usuario usuarioAuth){
        Optional<Inmobiliaria> inmobiliaria = inmobiliariaService.findById(id);

        Boolean comprobacion = false;
        for (Usuario gestor : inmobiliaria.get().getGestores()) {
            if (gestor.getId().equals(usuarioAuth.getId())) {
                comprobacion = true;
            }
        }

        if(!usuarioAuth.getRol().equals(RolUsuario.ADMIN) && !comprobacion) {
            return ResponseEntity.status(403).build();
        }else {
            return ResponseEntity.ok().body(inmobiliaria.get());
        }

    }

    @Operation(summary = "Elimina un gestor de una inmobiliaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha eliminado el gestor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Inmobiliaria.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha eliminado el gestor",
                    content = @Content),
    })
    @DeleteMapping("{id}/gestor/{id}")
    public ResponseEntity delete(@PathVariable UUID id, @AuthenticationPrincipal Usuario usuarioAuth){

        Optional<Usuario> gestor = usuarioService.loadUserById(id);

        if (!usuarioAuth.getRol().equals(RolUsuario.ADMIN) && gestor.get().getId().equals(usuarioAuth.getId())) {
            return ResponseEntity.status(403).build();
        }else {
            Inmobiliaria inmobiliaria = gestor.get().getInmobiliaria();
            gestor.get().removeInmobiliaria(inmobiliaria);
            usuarioService.save(gestor.get());
            return ResponseEntity.noContent().build();
        }
    }

}

