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

                        new Task("erferfef","ffrfrfrhk"),
                        new Task("wfrwfwe","dfdfddsfdvvvewfwfwef"),
                        new Task("r458rgrgege","wsfudfjsfjds")

                )
        );





    }
}
