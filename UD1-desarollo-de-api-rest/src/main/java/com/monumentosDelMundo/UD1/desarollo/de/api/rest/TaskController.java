package com.monumentosDelMundo.UD1.desarollo.de.api.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository repository;

    @GetMapping("/monumento")

    public List<Task> findAll(){

        return repository.findAll();
    }

    @GetMapping("/monumento/{id}")

    public Task findOne(@PathVariable("id") int id){

        return repository.findById(id).orElse(null);

    }

    @PostMapping("/monumento")

    public ResponseEntity<Task> create(@RequestBody Task task){

    return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(task));
    }

    @PutMapping("/monumento/{id}")

    public Task edit(@RequestBody Task task,@PathVariable Long id){

        Task antigua = repository.findById(id).orElse(task);
        antigua.setId(task.getCodigoPais());
        antigua.setId(task.getNombrePais());
        antigua.setId(task.getNombreCiudad());
        antigua.setId(task.getLatitud());
        antigua.setId(task.getLongitud());
        antigua.setId(task.getNombreMonu());
        antigua.setId(task.getDescripcion());
        antigua.setId(task.getUrl());


        return repository.save(antigua);


    }

    @DeleteMapping("/monumento/{id}")

        public ResponseEntity<?> delete(@PathVariable("id") int id){

            repository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
