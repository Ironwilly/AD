package com.salesianos.triana.Miarma.security;


import com.salesianos.triana.Miarma.security.dto.JwtUsuarioResponse;
import com.salesianos.triana.Miarma.security.dto.LoginDto;
import com.salesianos.triana.Miarma.security.jwt.JwtProvider;
import com.salesianos.triana.Miarma.users.dto.GetUserDto;
import com.salesianos.triana.Miarma.users.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @CrossOrigin
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginDto.getEmail(),
                                loginDto.getPassword()
                        )
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);


        String jwt = jwtProvider.generateToken(authentication);


        User user = (User) authentication.getPrincipal();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertUserToJwtUserResponse(user, jwt));

    }



    private JwtUsuarioResponse convertUserToJwtUserResponse(User user, String jwt) {
        return JwtUsuarioResponse.builder()
                .nombre(user.getNombre())
                .apellidos(user.getApellidos())
                .email(user.getEmail())
                .nick(user.getNick())
                .fechNac(user.getFechNaci())
                .avatar(user.getAvatar())
                .token(jwt)
                .build();
    }

    private GetUserDto convertUserToGetUserDto(User user,String jwt){
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



    @GetMapping("/me")
    public ResponseEntity<?> misDatos(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(convertUserToGetUserDto(user, null));
    }


}