package edu.salesianos.triana.manejoerrores.dto;


import edu.salesianos.triana.manejoerrores.model.Estacion;
import org.springframework.stereotype.Component;

@Component
public class EstacionServiceConverter {

    public Estacion created(EstacionServiceDTO estacion){

        return new Estacion(
                estacion.getNombre(),
                estacion.getMarca(),
                estacion.getUbicacion(),
                estacion.isTieneAutolavado(),
                estacion.getPrecioGasolina95Octanos(),
                estacion.getPrecioGasoilEspecial(),
                estacion.getPrecioGasolina98(),
                estacion.getServicios(),
                estacion.getFechaApertura()
        );

    }
}
