package com.E02Ejerciciospr.cticos.u1e2ejercicio02.model;


import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Producto {


    @Id
    @GeneratedValue

    private Long id;


    @Column (length = 255,nullable = false,name ="name")

    private String nombre;

    @Column(nullable = false, name ="price")

    private Double precio;

    @Column(name="image")

    private String imagen;

    @Column(name="description")

    private String descripcion;

}
