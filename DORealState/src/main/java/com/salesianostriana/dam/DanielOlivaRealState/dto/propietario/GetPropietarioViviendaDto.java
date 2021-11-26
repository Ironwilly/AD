package com.salesianostriana.dam.DanielOlivaRealState.dto.propietario;

import com.salesianostriana.dam.DanielOlivaRealState.dto.vivienda.GetViviendaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPropietarioViviendaDto {

    private UUID id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private List<GetViviendaDto> viviendas;
}
