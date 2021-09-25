package com.monumentosDelMundo.UD1.desarollo.de.api.rest;


import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private Long codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private Long latitud;
    private Long longitud;
    private String nombreMonu;
    private String descripcion;
    private String url;

    public Task( Long codigoPais, String nombrePais, String nombreCiudad,
                 Long latitud, Long longitud, String nombreMonu,
                 String descripcion, String url) {

        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.nombreCiudad = nombreCiudad;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombreMonu = nombreMonu;
        this.descripcion = descripcion;
        this.url = url;
    }
}
