package edu.salesianos.triana.manejoerrores.errores.excepciones;

public class SingleEntityNotFoundException extends EntityNotFoundException{

    public SingleEntityNotFoundException(String id,Class claxx){

        super(String.format("No se ha encontrado una entidad del tipo %s con ID: %s",claxx.getName(),id));

    }
}
