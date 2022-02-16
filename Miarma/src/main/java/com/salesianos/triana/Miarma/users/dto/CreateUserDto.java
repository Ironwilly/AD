package com.salesianos.triana.Miarma.users.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateUserDto {

    private String nombre;

    private String apellidos;

    private String nick;

    private LocalDate fechNac;

    private String direccion;

    private String email;

    private String isPrivado;

    private String telefono;

    private String avatar;

    private String password;

    private String password2;
}
