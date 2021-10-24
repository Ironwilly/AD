package com.ud1.E06_Modelos_de_datos.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;


    private String pvp;

    @ManyToOne
    private Categoria categoria;


    public  Producto(String n, String p){

        this.nombre = n;
        this.pvp = p;
    }

    public Producto(String nombre,String pvp,Categoria categoria){

        this.nombre = nombre;
        this.pvp = pvp;
        this.categoria = categoria;
    }





}
