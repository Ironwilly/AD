package com.salesianostriana.dam.DanielOlivaRealState.dto.interesado;

import com.salesianostriana.dam.DanielOlivaRealState.dto.interesa.GetInteresaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetInteresadoViviendaDto {

    private UUID id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private List <GetInteresaDto> vivienda;

}
