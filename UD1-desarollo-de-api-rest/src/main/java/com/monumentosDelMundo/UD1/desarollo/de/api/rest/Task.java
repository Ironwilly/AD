package com.monumentosDelMundo.UD1.desarollo.de.api.rest;


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
    private String codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private Double latitud;
    private Double longitud;
    private String nombreMonu;
    private String descripcion;
    private String url;


    public Task(String codigoPais, String nombrePais, String nombreCiudad,
                Double latitud, Double longitud, String nombreMonu,
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
