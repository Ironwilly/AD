package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Artist implements Serializable {


    @Id
    @GeneratedValue

    private Long id;


    private String name;


    @OneToMany (mappedBy = "artist")
    private List<Song> songs;

    @ManyToOne
    private Artist artist;




}
