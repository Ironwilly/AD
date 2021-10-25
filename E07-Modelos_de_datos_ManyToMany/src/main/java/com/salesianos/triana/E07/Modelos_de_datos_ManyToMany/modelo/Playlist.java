package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Playlist implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private  String descripcion;
}
