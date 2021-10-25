package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo;


import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;


@NoArgsConstructor
@Embeddable
@Getter @Setter
@Builder
@AllArgsConstructor
public class AddedToPk implements Serializable {

    private Long songId;
    private Long artistId;

}
