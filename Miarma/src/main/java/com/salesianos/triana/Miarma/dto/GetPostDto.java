package com.salesianos.triana.Miarma.dto;


import com.salesianos.triana.Miarma.users.dto.GetUserDto;
import lombok.*;


import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPostDto {

    private Long id;

    private String titulo;

    private String descripcion;

    private String imagen;

    private Boolean isPublic;

    private String userNick;

    private String avatar;

}
