package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter @Setter

public class Song implements Serializable {

    @Id
    @GeneratedValue

    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "artist_id", foreignKey = @ForeignKey(name = "FK_SONG_ARTIST"))
    private Artist artist;

    private  String album;

    private  String year;

    @ManyToMany(mappedBy = "listSongs",fetch = FetchType.EAGER)
    private List<Playlist> playlists = new ArrayList<>();


    //helpers

    public void addArtist(Artist a){
        this.artist = a;
        a.getSongs().add(this);
    }

    public void removeArtist(Artist a){
        a.getSongs().remove(this);
        this.artist = null;
    }


}
