package com.salesianos.triana.Miarma.users.dto;



import com.salesianos.triana.Miarma.users.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDtoConverter {

    public GetUserDto userToGetUserDto(User user){

        List<String> tituloPublicacion = new ArrayList<>();
        for (int i=0; i<user.getPublicaciones().size();i++){
            tituloPublicacion.add(user.getPublicaciones().get(i).getTitulo());
        }

        return GetUserDto.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .fechNac(user.getFechNaci())
                .nick(user.getNick())
                .isPrivado(user.getIsPrivado())


                .build();
    }

    public CreateUserDto editUser(User user){
        return CreateUserDto.builder()

                .nombre(user.getNombre())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .fechNac(user.getFechNaci())
                .nick(user.getNick())
                .build();
    }




}
