package com.monumentosDelMundo.UD1.desarollo.de.api.rest;


/*
Para este ejercicio, se pide implementar una API REST sobre Monumentos del mundo.
De cada Monumento queremos saber los siguientes datos:
Su ID (un número entero)
El código de país (según el código ISO 3166-1 alfa 2).
El nombre del país.
El nombre de la ciudad.
Su localización (latitud, longitud).
El nombre del monumento
Un descripción del mismo
La URL de una foto.

 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data  // crea getter ,setter....
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

    //@Lob  se usa para que se pueda poner un texto más grande que 255 carácteres
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
