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

                        new Task("ES", "Spain","Sevilla",
                                37.3862, -5.9926,"Giralda",
                                "La Giralda es la torre campanario de la Catedral. " +
                                        "En su día fue la torre más alta del mundo con sus 97,5m " +
                                        "de altura, además de ser una de las imágenes más famosas de " +
                                        "la ciudad y de toda Andalucía.",
                                "https://www.mercerhoteles.com/photo/blog/45/1/sevilla-a-los-pies-de-la-giralda.jpg?w=1440"),
                        new Task("ES", "Spain","Granada",
                                -3.5899900, 37.1768900,"Alhambra",
                                "La Alhambra es la ciudad, fortaleza y palacio erigida por los " +
                                        "monarcas de la dinastía Nazarí del Reino de Granada. Es el " +
                                        "símbolo de la ciudad, el monumento más visitado de España y " +
                                        "la obra cumbre del arte musulmán en Europa.",
                                "https://cdn.getyourguide.com/img/location/60096d829a2cf.jpeg/92.jpg"),
                        new Task("FR", "FRANCIA","París",
                                48.8583701, 2.2944813,"Torre Eifell",
                                "La Torre Eiffel es una construcción de hierro de 300 metros " +
                                        "de altura que fue creada para la Exposición Universal de París " +
                                        "de 1889. Actualmente constituye el símbolo más representativo " +
                                        "de París.",
                                "https://blog-francia.com/wp-content/uploads/2009/05/La-Torre-Eiffel-759x1024.jpg"),
                        new Task("US", "ESTADOS UNIDOS","Keystone",
                43.8791, -103.4591,"Monte Rushmore",
                "Representa los rostros de " +
                        "cuatro presidentes icónicos de los Estados Unidos: George Washington, Thomas Jefferson, Abraham Lincoln, " +
                        "Theodore Roosevelt.",
                                "https://s1.eestatic.com/2020/07/02/mundo/america/eeuu/eeuu_502210961_154951749_1024x576.jpg")

                )



        );


    }


}
