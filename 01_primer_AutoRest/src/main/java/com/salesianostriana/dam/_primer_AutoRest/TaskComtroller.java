package com.salesianostriana.dam._primer_AutoRest;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController //equivalente a @controller + @responsebody
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskComtroller {


    private final TaskRepository repository;

    @GetMapping("/")
    public List<Task> findAll() {

        return repository.findAll();


    }

    @PostMapping("/")
    public ResponseEntity<Task> create(@RequestBody Task task) {

        //return repository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(task));

    }

    @GetMapping("/{id}")
    public Task findOne(@PathVariable("id") Long id) {

        return repository.findById(id).orElse(null);


    }

    @PutMapping("/{id}")
    public Task edit(@RequestBody Task task, @PathVariable Long id) {

        Task antigua = repository.findById(id).orElse(task);
        antigua.setText(task.getText());
        antigua.setTitle(task.getTitle());

        return repository.save(antigua);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

