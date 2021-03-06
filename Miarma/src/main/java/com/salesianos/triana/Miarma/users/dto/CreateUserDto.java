package com.salesianos.triana.Miarma.users.dto;


import com.salesianos.triana.Miarma.models.Post;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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

    private String isPublic;

    private String telefono;

    private String avatar;

    private String password;

    private String password2;


    private List<Post> publicaciones;


}
