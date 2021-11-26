package com.salesianostriana.dam.DanielOlivaRealState.dto.vivienda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GetViviendaInteresaDto {
    private String mensaje;
    private LocalDate createDate;
}
