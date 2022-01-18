package edu.salesianos.triana.manejoerrores.errores.excepciones;

public class ListEntityNotFoundException extends EntityNotFoundException{

    public ListEntityNotFoundException(Class claxx) {

        super(String.format("No se han encontado elementos del tipo %s", claxx.getName()));
    }
}
