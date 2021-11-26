package com.salesianostriana.dam.DanielOlivaRealState.dto.interesa;

import com.salesianostriana.dam.DanielOlivaRealState.dto.vivienda.GetViviendaInteresaDto;
import com.salesianostriana.dam.DanielOlivaRealState.model.Interesa;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class InteresaDtoConverter {

    public Interesa createInteresaDto (GetViviendaInteresaDto getViviendaInteresaDto) {
        return Interesa.builder()
                .createdDate(LocalDate.now())
                .mensaje(getViviendaInteresaDto.getMensaje())
                .build();
    }

    public Interesa getInteresaDto (GetInteresaDto interesa) {
        return Interesa.builder()
                .mensaje(interesa.getMensaje())
                .createdDate(LocalDate.now())
                .build();
    }


}
