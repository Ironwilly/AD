package edu.salesianos.triana.manejoerrores.service;


import edu.salesianos.triana.manejoerrores.errores.excepciones.ListEntityNotFoundException;
import edu.salesianos.triana.manejoerrores.errores.excepciones.SingleEntityNotFoundException;
import edu.salesianos.triana.manejoerrores.model.Estacion;
import edu.salesianos.triana.manejoerrores.repo.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionService {

    private final EstacionRepository repository;

    public List<Estacion> findAll() {

        List<Estacion> result = repository.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Estacion.class);
        } else {
            return result;
        }
    }

        public Estacion findById(Long id){

            return repository.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(),Estacion.class));
        }


    public Estacion save(Estacion estacion) {
        return repository.save(estacion);
    }

    public void deleteById(Long id){
        Optional<Estacion> estacionService = repository.findById(id);
        if(estacionService.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),EstacionService.class);

        }else {
            repository.deleteById(id);
        }
    }






}
