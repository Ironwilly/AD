package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
@Setter
public class Song implements Serializable {

    @Id
    @GeneratedValue

    private Long id;


    private String title;

    @ManyToOne
    @JoinColumn(name = "artist", foreignKey = @ForeignKey(name = "FK_SONG_ARTIST"))
    private Artist artist;

    private  String album;

    private  String year;



}
