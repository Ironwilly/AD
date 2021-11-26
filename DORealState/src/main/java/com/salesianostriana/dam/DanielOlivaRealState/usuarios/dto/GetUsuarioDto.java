package com.salesianostriana.dam.DanielOlivaRealState.usuarios.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUsuarioDto {

    private String avatar;
    private String nombre;
    private String apellidos;
    private String email;
    private String rol;

}
