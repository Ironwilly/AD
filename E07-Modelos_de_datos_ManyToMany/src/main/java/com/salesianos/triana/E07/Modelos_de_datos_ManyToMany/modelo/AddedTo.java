package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo;


import lombok.*;


import javax.persistence.*;

import java.io.Serializable;


@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder


public class AddedTo implements Serializable {


    @Builder.Default
    @EmbeddedId
    private AddedToPk id = new AddedToPk();


    @ManyToMany
    @MapsId("songId")
    @JoinColumn(name ="songId")
    private Song song;

    @ManyToMany
    @MapsId("artistId")
    @JoinColumn(name = "artistId")
    private Playlist playlist;

    private String datetime;

    private String order;




}
