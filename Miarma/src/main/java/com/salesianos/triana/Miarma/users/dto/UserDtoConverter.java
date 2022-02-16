package com.salesianos.triana.Miarma.users.dto;



import com.salesianos.triana.Miarma.users.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public GetUserDto userToGetUserDto(User user){

        return GetUserDto.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .fechNac(user.getFechNaci())
                .nick(user.getNick())

                .build();
    }





    public CreateUserDto userToCreateUser(User user){


        return CreateUserDto.builder()
                .nombre(user.getNombre())
                .apellidos(user.getApellidos())
                .direccion(user.getDireccion())
                .telefono(user.getTelefono())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .password(user.getPassword())
                .password2(user.getPassword())
                .build();
    }


}
