package com.monumentosDelMundo.UD1.desarollo.de.api.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {

    private final TaskRepository repository;


    @PostConstruct

    public void init(){


        repository.saveAll(
                Arrays.asList(

                    new Task("35345", "ereterge", "efwfwff",
                            "34353", "5474", "egrehtrththt",
                            "tjtjtjt", "reherrhre")


                )


        );
    }


}
