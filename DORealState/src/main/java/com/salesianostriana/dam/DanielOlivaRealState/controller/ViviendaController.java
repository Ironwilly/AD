package com.salesianostriana.dam.DanielOlivaRealState.controller;

import com.salesianostriana.dam.DanielOlivaRealState.dto.interesa.GetInteresaDto;
import com.salesianostriana.dam.DanielOlivaRealState.dto.interesa.InteresaDtoConverter;
import com.salesianostriana.dam.DanielOlivaRealState.dto.vivienda.GetViviendaDto;
import com.salesianostriana.dam.DanielOlivaRealState.dto.vivienda.GetViviendaIdDto;
import com.salesianostriana.dam.DanielOlivaRealState.dto.vivienda.ViviendaDtoConverter;
import com.salesianostriana.dam.DanielOlivaRealState.model.Inmobiliaria;
import com.salesianostriana.dam.DanielOlivaRealState.model.Interesa;
import com.salesianostriana.dam.DanielOlivaRealState.repos.InmobiliariaRepository;
import com.salesianostriana.dam.DanielOlivaRealState.repos.ViviendaRepository;
import com.salesianostriana.dam.DanielOlivaRealState.model.Vivienda;
import com.salesianostriana.dam.DanielOlivaRealState.services.InmobiliariaService;
import com.salesianostriana.dam.DanielOlivaRealState.services.InteresaService;
import com.salesianostriana.dam.DanielOlivaRealState.services.ViviendaService;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.RolUsuario;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.Usuario;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.repos.UsuarioRepository;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "Vivienda", description = "Controller de las viviendas")
@RequestMapping("/vivienda/")
public class ViviendaController {

    private final InmobiliariaRepository inmobiliariaRepository;
    private final ViviendaRepository viviendaRepository;
    private final ViviendaService viviendaService;
    private final ViviendaDtoConverter dtoConverter;
    private final UsuarioService usuarioService;
    private final InmobiliariaService inmobiliariaService;
    private final UsuarioRepository usuarioRepository;
    private final InteresaDtoConverter interesaDtoConverter;
    private final InteresaService interesaService;
    private final ViviendaDtoConverter viviendaDtoConverter;

    @Operation(summary = "Obtiene lista de viviendas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado lista de viviendas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetViviendaDto.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se han encontrado las viviendas",
                    content = @Content),
    })
    @GetMapping("")
    public ResponseEntity<List<GetViviendaDto>> findAll() {

        List<GetViviendaDto> data = viviendaService.listarViviendasDto();

        if (data.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(viviendaService.listarViviendasDto());
        }
    }


    @Operation(summary = "Obtiene una vivienda en base a su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la vivienda",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetViviendaDto.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha encontrado la vivienda",
                    content = @Content),
    })
    @GetMapping("{id}")
    public ResponseEntity<GetViviendaDto> findOne (@PathVariable Long id) {

        Optional<Vivienda> vivienda = viviendaService.findById(id);

        if (vivienda.isEmpty()) {
            return ResponseEntity.notFound().build();

        } else {
            GetViviendaDto viviendaDto = viviendaDtoConverter.viviendaToGetViviendaPropietarioDto(vivienda.get());
            return ResponseEntity.ok().body(viviendaDto);
        }

    }

    @Operation(summary = "Edita una vivienda anteriormente creada, buscando por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha editado la vivienda",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vivienda.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha editado la vivienda",
                    content = @Content),
    })
    @PutMapping("{id}")
    public ResponseEntity<Vivienda> edit (@RequestBody Vivienda v, @PathVariable Long id, @AuthenticationPrincipal Usuario usuarioAuth) {

        if (!usuarioAuth.getRol().equals(RolUsuario.ADMIN) && !viviendaService.findById(id).get().getUsuario().getId().equals(usuarioAuth.getId())) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.of(

                    viviendaService.findById(id).map(m -> {
                        m.setTitulo(v.getTitulo());
                        m.setDescripcion(v.getDescripcion());
                        m.setAvatar(v.getAvatar());
                        m.setCodigoPostal(v.getCodigoPostal());
                        m.setLatlng(v.getLatlng());
                        m.setMetrosCuadrados(v.getMetrosCuadrados());
                        m.setNumBanios(v.getNumBanios());
                        m.setNumHabitaciones(v.getNumHabitaciones());
                        m.setPoblacion(v.getPoblacion());
                        m.setPrecio(v.getPrecio());
                        m.setProvincia(v.getProvincia());
                        m.setDireccion(v.getDireccion());
                        m.setTipoVivienda(v.getTipoVivienda());
                        m.setTienePiscina(v.isTienePiscina());
                        m.setTieneAscensor(v.isTieneAscensor());
                        m.setTieneGaraje(v.isTieneGaraje());
                        viviendaService.save(m);

                        return m;
                    })
            );
        }

    }

    @Operation(summary = "Crea una nueva vivienda a la que se asocia un  propietario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado la nueva vivienda",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vivienda.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha creado la nueva vivienda",
                    content = @Content),
    })
    @PostMapping("")
    public ResponseEntity<Vivienda> createVivienda(@RequestBody Vivienda vivienda, @AuthenticationPrincipal Usuario usuarioAuth) {

        if (vivienda.getTitulo().isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            if (usuarioAuth.getId() != null)

                vivienda.addPropietario(usuarioAuth);
                viviendaService.save(vivienda);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(vivienda);
        }
    }

     @Operation(summary = "Crea una nueva vivienda y añade una inmobiliaria ya existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado la nueva vivienda",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetViviendaIdDto.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha creado la nueva vivienda",
                    content = @Content),
    })
    @PostMapping("{id}/inmobiliaria/{id2}")
     public ResponseEntity<GetViviendaIdDto> createViviendaWithRealEstate(@PathVariable Long id, @PathVariable Long id2, @AuthenticationPrincipal Usuario usuarioAuth) {



         if (!usuarioAuth.getRol().equals(RolUsuario.ADMIN) && !viviendaService.findById(id).get().getUsuario().getId().equals(usuarioAuth.getId())) {
             return ResponseEntity.notFound().build();
         } else {

             Optional<Vivienda> vivienda = viviendaService.findById(id);
             vivienda.get().addInmobiliaria(inmobiliariaRepository.getById(id2));

             usuarioAuth.addInmobiliaria(inmobiliariaRepository.getById(id2));
             usuarioService.save(usuarioAuth);

             viviendaService.save(vivienda.get());

             GetViviendaIdDto viviendaDTO = viviendaDtoConverter.viviendaToGetViviendaDto(vivienda.get());
             return ResponseEntity.status(HttpStatus.CREATED).body(viviendaDTO);
         }
     }

    @Operation(summary = "Se elimina la vivienda y el interés, pero no el interesado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha borrado la vivienda",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400",
                    description = "No se ha borrado la vivienda",
                    content = @Content),
    })
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id, @AuthenticationPrincipal Usuario usuarioAuth) {

        if (!usuarioAuth.getRol().equals(RolUsuario.ADMIN) && !viviendaService.findById(id).get().getUsuario().getId().equals(usuarioAuth.getId())) {
            return ResponseEntity.notFound().build();
        } else {
            viviendaService.deleteById(id);

            return ResponseEntity.noContent().build();
        }

    }

    @Operation(summary = "Crea un nuevo interés entre una vivienda y un interesado ya existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado el interés",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha creado el interés",
                    content = @Content),
    })
    @PostMapping("{id}/meinteresa/")
    public ResponseEntity<Usuario> createInteresa (@RequestBody GetInteresaDto dto, @PathVariable Long id){

        Optional<Vivienda> vivienda=viviendaService.findById(id);

        Usuario interesado= vivienda.get().getUsuario();
        Interesa interesa= interesaDtoConverter.getInteresaDto(dto);
        usuarioService.save(interesado);
        interesa.addToInteresado(interesado);
        interesa.setVivienda(viviendaService.findById(id).get());

        interesaService.save(interesa);
        interesado.getInteresas().add(interesa);

        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioService.save(interesado));


    }

    @Operation(summary = "Elimina el interés entre una vivienda y un interesado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha eliminado el interés",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400",
                    description = "No se ha eliminado el interés",
                    content = @Content),
    })
    @DeleteMapping("{id}/meinteresa/")
    public ResponseEntity<?> deleteInteresaVivienda (@PathVariable Long id, @PathVariable UUID id2) {

        if (viviendaService.findById(id).isEmpty() && usuarioService.findById(id2).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<Interesa> listInteresa = viviendaRepository.getById(id).getInteresas();
            Optional<Vivienda> vivienda = viviendaService.findById(id);
            Usuario interesado = usuarioRepository.getById(id2);

            for (Interesa i: listInteresa) {
                interesaService.delete(i);
                return ResponseEntity.noContent().build();
            }

        }

        return ResponseEntity.badRequest().build();

    }


    @Operation(summary = "Se elimina la inmobiliaria sobre la vivienda especificada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Se ha borrado la inmobiliaria",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    description = "No se ha borrado la inmobiliaria",
                    content = @Content),
    })
    @DeleteMapping("{id}/inmobiliaria")
    public ResponseEntity deleteInmobiliariaFromVivienda(@PathVariable Long id, @AuthenticationPrincipal Usuario usuarioAuth) {
        Boolean comprobacion=false;
        for (Usuario gestor : viviendaService.findById(id).get().getInmobiliaria().getGestores()) {
            if (gestor.getId().equals(usuarioAuth.getId())) {
                comprobacion=true;
            }
        }
        if (!viviendaService.findById(id).isEmpty() && !usuarioAuth.getRol().equals(RolUsuario.ADMIN) &&  !viviendaService.findById(id).get().getUsuario().getId().equals(usuarioAuth.getId()) && !comprobacion) {
            return ResponseEntity.notFound().build();
        } else {
            Inmobiliaria inmobiliaria = viviendaService.findById(id).get().getInmobiliaria();
            viviendaService.findById(id).get().removeInmobiliaria(inmobiliaria);
            viviendaService.save(viviendaService.findById(id).get());
            return ResponseEntity.noContent().build();
        }
    }

}
