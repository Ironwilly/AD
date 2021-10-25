package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Playlist implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Song> listSongs = new ArrayList<>();

//helpers

    public void addSong(Song s) {
        this.getListSongs().add(s);
    }

    public void removeSong(Song s){
        s.getPlaylists().remove(this);
        this.getListSongs().remove(s);
    }


}


