package com.salesianostriana.dam.DanielOlivaRealState.services;

import com.salesianostriana.dam.DanielOlivaRealState.dto.vivienda.GetViviendaDto;
import com.salesianostriana.dam.DanielOlivaRealState.model.Vivienda;
import com.salesianostriana.dam.DanielOlivaRealState.repos.ViviendaRepository;
import com.salesianostriana.dam.DanielOlivaRealState.services.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViviendaService extends BaseService<Vivienda, Long, ViviendaRepository> {

    public List<GetViviendaDto> listarViviendasDto() {
        return repositorio.todosLasViviendasDto();
    }


}
