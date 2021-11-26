package com.salesianostriana.dam.DanielOlivaRealState.usuarios.dto;

import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoConverter {

    public GetUsuarioDto usuarioEntityToGetUsuarioDto (Usuario usuario) {

        return GetUsuarioDto.builder()
                .avatar(usuario.getAvatar())
                .nombre(usuario.getNombre())
                .apellidos(usuario.getApellidos())
                .email(usuario.getEmail())
                .rol(usuario.getRol().name())
                .build();
    }

}
