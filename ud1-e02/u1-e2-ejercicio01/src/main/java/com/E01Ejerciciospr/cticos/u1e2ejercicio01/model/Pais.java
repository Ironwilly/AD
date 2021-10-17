package com.E01Ejerciciospr.cticos.u1e2ejercicio01.model;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "country")
@NoArgsConstructor
public class Pais {


    @Id
    @GeneratedValue
    private Long id;


    @Column(length = 128,nullable = false,name="name")

    private String nombre;
}
