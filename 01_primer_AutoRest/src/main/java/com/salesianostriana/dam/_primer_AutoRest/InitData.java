package com.salesianostriana.dam._primer_AutoRest;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {


    private final TaskRepository repository;




    @PostConstruct
    public void  init(){

        repository.saveAll(
                Arrays.asList(

                        new Task("Prueba 1"," texto de la prueba 1"),
                        new Task("Prueba 2","texto de la prueba 2"),
                        new Task("Prueba 3","texto de la prueba 3")

                )
        );





    }
}
