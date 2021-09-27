package com.monumentosDelMundo.UD1.desarollo.de.api.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //transforma en controlador REST
@RequestMapping ("/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository repository;

    @GetMapping("/monumento")

    public List<Task> findAll(){

        return repository.findAll();
    }

    @GetMapping("/monumento/{id}")

    public Task findOne(@PathVariable("id") Long id){

        return repository.findById(id).orElse(null);

    }

    @PostMapping("/monumento")

    public ResponseEntity<Task> create(@RequestBody Task task){

    return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(task)); //TAMBIEN SE PUEDE PONER EN VEZ DE HTTPSTATUS... EL NUMERO DE PETICION QUE SE QUIERA.... EJ: 201

    }

    @PutMapping("/monumento/{id}")

    public Task edit(@RequestBody Task task,@PathVariable Long id){

        Task antigua = repository.findById(id).orElse(task);
        antigua.setCodigoPais(task.getCodigoPais());
        antigua.setCodigoPais((task.getCodigoPais()));
        antigua.setNombrePais(task.getNombrePais());
        antigua.setNombreCiudad(task.getNombreCiudad());
        antigua.setLatitud(task.getLatitud());
        antigua.setLongitud(task.getLongitud());
        antigua.setNombreMonu(task.getNombreMonu());
        antigua.setUrl(task.getUrl());




        return repository.save(antigua);


    }

    @DeleteMapping("/monumento/{id}")

        public ResponseEntity<?> delete(@PathVariable("id") Long id){

            repository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
