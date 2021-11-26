package com.salesianostriana.dam.DanielOlivaRealState.dto.interesado;

import com.salesianostriana.dam.DanielOlivaRealState.dto.interesa.GetInteresaDto;
import com.salesianostriana.dam.DanielOlivaRealState.model.Interesa;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class InteresadoDtoConverter {

    public Usuario createInteresadoDtoToInteresado(CreateInteresadoInteresaDto i){
        return new Usuario(
                i.getNombre(),
                i.getApellidos(),
                i.getDireccion(),
                i.getEmail(),
                i.getTelefono(),
                i.getAvatar()
        );
    }

    public GetInteresadoDto interesadoToGetInteresadoDto(Usuario i){
        return GetInteresadoDto
                .builder()
                .id(i.getId())
                .nombre(i.getNombre())
                .apellidos(i.getApellidos())
                .direccion(i.getDireccion())
                .email(i.getEmail())
                .telefono(i.getTelefono())
                .avatar(i.getAvatar())
                .build();
    }

    public GetInteresadoInteresaDto interesadoToGetInteresadoInteresaDto(Usuario interesado, Interesa interesa){

        return GetInteresadoInteresaDto
                .builder()
                .id(interesado.getId())
                .nombre(interesado.getNombre())
                .apellidos(interesado.getApellidos())
                .direccion(interesado.getDireccion())
                .email(interesado.getEmail())
                .telefono(interesado.getTelefono())
                .avatar(interesado.getAvatar())
                .createdDate(interesa.getCreatedDate())
                .mensaje(interesa.getMensaje())
                .build();

    }

    public GetInteresadoViviendaDto interesadoToGetInteresadoViviendaDto (Usuario interesado){



        return GetInteresadoViviendaDto
                .builder()
                .id(interesado.getId())
                .nombre(interesado.getNombre())
                .apellidos(interesado.getApellidos())
                .email(interesado.getEmail())
                .telefono(interesado.getTelefono())
                .direccion(interesado.getDireccion())
                .vivienda(interesado.getInteresas().stream().map(v -> new GetInteresaDto(v.getMensaje(),v.getCreatedDate(),v.getVivienda().getTitulo(),
                        v.getVivienda().getProvincia(),v.getVivienda().getNumBanios(),
                        v.getVivienda().getNumHabitaciones(),v.getVivienda().getPrecio(),
                        v.getVivienda().getDescripcion(),v.getVivienda().getAvatar())).toList())
                .build();
    }

}
