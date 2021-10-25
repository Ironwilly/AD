package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo;


import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Embeddable

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor


public class AddedTo {

    private Long song_id;

    private Long artist_id;

}
