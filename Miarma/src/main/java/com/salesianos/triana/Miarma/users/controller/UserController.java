package com.salesianos.triana.Miarma.users.controller;



import com.salesianos.triana.Miarma.dto.FileResponse;
import com.salesianos.triana.Miarma.services.StorageService;
import com.salesianos.triana.Miarma.users.dto.CreateUserDto;
import com.salesianos.triana.Miarma.users.dto.GetUserDto;
import com.salesianos.triana.Miarma.users.dto.UserDtoConverter;
import com.salesianos.triana.Miarma.users.model.User;
import com.salesianos.triana.Miarma.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserDtoConverter userDtoConverter;
    private final StorageService storageService;


    @PostMapping("/auth/registrer")
    public ResponseEntity<?> create(@RequestPart("user") CreateUserDto newUser,@RequestPart("file") MultipartFile file) {

        User userSaved = userService.saveUser(newUser,file);




        if (userSaved == null)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(userDtoConverter.userToGetUserDto(userSaved));


    }
}
