package com.salesianostriana.dam.DanielOlivaRealState.dto.vivienda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GetViviendaPropietarioDto extends GetViviendaDto{

    private String propietario;

    public GetViviendaPropietarioDto(Long id, String titulo, String provincia, int numBanios, int numHabitaciones, double metrosCuadrados, double precio, String descripcion, String avatar, String propietario) {
        super(id, titulo, provincia, numBanios, numHabitaciones, metrosCuadrados, precio, descripcion, avatar);
        this.propietario = propietario;
    }
}
