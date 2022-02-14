package com.salesianos.triana.Miarma.users.dto;


import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class GetUserDto {



    private UUID id;

    private String nombre;

    private String email;

    private String avatar;



}
