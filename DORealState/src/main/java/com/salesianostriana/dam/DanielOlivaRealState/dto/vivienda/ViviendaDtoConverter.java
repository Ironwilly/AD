package com.salesianostriana.dam.DanielOlivaRealState.dto.vivienda;

import com.salesianostriana.dam.DanielOlivaRealState.model.Vivienda;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component@RequiredArgsConstructor
public class ViviendaDtoConverter {


    private final UsuarioService propietarioService;

    public Vivienda createViviendaDtoToVivienda(CreateViviendaDto v){

        return Vivienda.builder()
                .titulo(v.getTitulo())
                .provincia(v.getProvincia())
                .tipoVivienda(v.getTipoVivienda())
                .numBanios(v.getNumBanios())
                .numHabitaciones(v.getNumHabitaciones())
                .metrosCuadrados(v.getMetrosCuadrados())
                .precio(v.getPrecio())
                .descripcion(v.getDescripcion())
                .codigoPostal(v.getCodigoPostal())
                .latlng(v.getLatlng())
                .poblacion(v.getPoblacion())
                .tienePiscina(v.isTienePiscina())
                .tieneAscensor(v.isTieneAscensor())
                .tieneGaraje(v.isTieneGaraje())
                .usuario(propietarioService.findById(v.getPropietarioId()).get())
                .build();
    }


    public GetViviendaIdDto viviendaToGetViviendaDto (Vivienda v) {

        return GetViviendaIdDto
                .builder()
                .id(v.getId())
                .titulo(v.getTitulo())
                .provincia(v.getProvincia())
                .tipoVivienda(v.getTipoVivienda())
                .numBanios(v.getNumBanios())
                .numHabitaciones(v.getNumHabitaciones())
                .metrosCuadrados(v.getMetrosCuadrados())
                .precio(v.getPrecio())
                .descripcion(v.getDescripcion())
                .avatar(v.getAvatar())
                .direccion(v.getDireccion())
                .codigoPostal(v.getCodigoPostal())
                .latlng(v.getLatlng())
                .poblacion(v.getPoblacion())
                .tienePiscina(v.isTienePiscina())
                .tieneGaraje(v.isTieneGaraje())
                .propietarioId(v.getUsuario().getId())
                .build();


    }

    public GetViviendaPropietarioDto viviendaToGetViviendaPropietarioDto(Vivienda v){

        return GetViviendaPropietarioDto.builder()
                .id(v.getId())
                .titulo(v.getTitulo())
                .descripcion(v.getDescripcion())
                .provincia(v.getProvincia())
                .numHabitaciones(v.getNumHabitaciones())
                .numBanios(v.getNumBanios())
                .metrosCuadrados(v.getMetrosCuadrados())
                .avatar(v.getAvatar())
                .propietario(v.getUsuario().getNombre())
                .build();

    }

    public PutViviendaDto editViviendaDtoToVivienda (Vivienda v) {
        return new PutViviendaDto(
                v.getTitulo(),
                v.getProvincia(),
                v.getTipoVivienda(),
                v.getNumBanios(),
                v.getNumHabitaciones(),
                v.getMetrosCuadrados(),
                v.getPrecio(),
                v.getDescripcion(),
                v.getAvatar(),
                v.getDireccion(),
                v.getCodigoPostal(),
                v.getLatlng(),
                v.getPoblacion(),
                v.isTienePiscina(),
                v.isTieneAscensor(),
                v.isTieneGaraje(),
                v.getUsuario().getId()

        );
    }
}
