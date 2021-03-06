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
                .isPublic(user.getIsPublic())
                .build();
    }

    public CreateUserDto convertUserToCreateUserDto(User user){
        return CreateUserDto.builder()
                .nombre(user.getNombre())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .fechNac(user.getFechNaci())
                .nick(user.getNick())
                .build();
    }




}
