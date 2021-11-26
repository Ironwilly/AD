package com.salesianostriana.dam.DanielOlivaRealState.dto.interesado;

import com.salesianostriana.dam.DanielOlivaRealState.dto.interesado.GetInteresadoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.util.UUID;

@Data@NoArgsConstructor@AllArgsConstructor@SuperBuilder
public class GetInteresadoInteresaDto extends GetInteresadoDto {

    private LocalDate createdDate;
    private String mensaje;

    public GetInteresadoInteresaDto(UUID id, String nombre, String apellidos, String direccion, String email, String telefono, String avatar, LocalDate createdDate, String mensaje) {
        super(id, nombre, apellidos, direccion, email, telefono, avatar);
        this.createdDate = createdDate;
        this.mensaje = mensaje;
    }
}
