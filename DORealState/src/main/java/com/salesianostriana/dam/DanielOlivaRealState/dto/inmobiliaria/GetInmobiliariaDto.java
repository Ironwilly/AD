package com.salesianostriana.dam.DanielOlivaRealState.dto.inmobiliaria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetInmobiliariaDto {


    private Long id;
    private String nombre, email, telefono;

}