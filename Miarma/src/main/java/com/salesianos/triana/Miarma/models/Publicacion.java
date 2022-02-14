package com.salesianos.triana.Miarma.models;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publicacion {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @Lob
    private String descripcion;

    private String imagen;

    private Boolean isPublic;


}
