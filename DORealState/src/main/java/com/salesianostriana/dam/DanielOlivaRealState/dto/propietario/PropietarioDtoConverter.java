package com.salesianostriana.dam.DanielOlivaRealState.dto.propietario;

import com.salesianostriana.dam.DanielOlivaRealState.dto.vivienda.GetViviendaDto;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class PropietarioDtoConverter {

    public Usuario createPropietarioDtoToPropietario(CreatePropietarioDto p){
        return new Usuario(
                p.getNombre(),
                p.getApellidos(),
                p.getDireccion(),
                p.getEmail(),
                p.getTelefono(),
                p.getAvatar()
        );
    }
    public GetPropietarioDto propietarioToGetPropietarioDto(Usuario p){
        return GetPropietarioDto
                .builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .apellidos(p.getApellidos())
                .direccion(p.getDireccion())
                .email(p.getEmail())
                .telefono(p.getTelefono())
                .avatar(p.getAvatar())
                .build();
    }

    public GetPropietarioViviendaDto propietarioToGetPropietarioViviendaDto (Usuario p) {

        return GetPropietarioViviendaDto
                .builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .apellidos(p.getApellidos())
                .direccion(p.getDireccion())
                .email(p.getEmail())
                .telefono(p.getTelefono())
                .viviendas(p.getListaViviendas().stream().map(v -> new GetViviendaDto(v.getId(),v.getTitulo()
                        ,v.getProvincia(),
                        v.getNumBanios(), v.getNumHabitaciones(),v.getMetrosCuadrados(),v.getPrecio()
                        ,v.getDescripcion(),v.getAvatar())).toList())
                .build();
    }

}
