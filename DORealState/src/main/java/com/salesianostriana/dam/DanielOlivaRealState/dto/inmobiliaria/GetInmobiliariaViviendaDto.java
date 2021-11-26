package com.salesianostriana.dam.DanielOlivaRealState.dto.inmobiliaria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetInmobiliariaViviendaDto {

    private Long id;
    private String nombre, email, telefono;
    private List<String> viviendas;


}
