package edu.salesianos.triana.manejoerrores.controller;

import edu.salesianos.triana.manejoerrores.model.Estacion;
import edu.salesianos.triana.manejoerrores.service.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/estacion")
public class EstacionController {

    private final EstacionService estacionService;

    @GetMapping("/")
    public List<Estacion> mostrarTodas() {
        return estacionService.findAll();
    }

    @GetMapping("/{id}")
    public Estacion mostrarPorId(@PathVariable Long id) {
        return estacionService.findById(id);
    }

    @PostMapping("/")
    public Estacion crear(@Valid @RequestBody Estacion estacion) {
        return estacionService.save(estacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        estacionService.deleteById(id);
        return ResponseEntity.noContent().build();

    }


}
