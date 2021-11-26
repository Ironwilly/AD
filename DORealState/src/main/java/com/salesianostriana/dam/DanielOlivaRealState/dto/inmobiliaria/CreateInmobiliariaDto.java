package com.salesianostriana.dam.DanielOlivaRealState.dto.inmobiliaria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInmobiliariaDto {

    private String nombre, email, telefono;

}
