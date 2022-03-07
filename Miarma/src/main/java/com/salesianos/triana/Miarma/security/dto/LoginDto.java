package com.salesianos.triana.Miarma.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins= "*")
public class LoginDto {

    private String email;

    private String password;

}