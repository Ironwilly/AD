package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Artist;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Playlist;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo.Song;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.services.AddedToService;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.services.ArtistService;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.services.PlaylistService;
import com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final SongService songService;
    private final ArtistService artistService;
    private final PlaylistService playlistService;
    private final AddedToService addedToService;

    @PostConstruct

    public void test(){

        Artist artist = Artist.builder()
                .name("Metallica")
                .build();

        artistService.edit(artist);


        Song song = Song.builder()
                .title("Fade to black")
                .artist(artist)
                .build();

        songService.save(song);
        song.addArtist(artist);


        Playlist playlist = Playlist.builder()
                .name("Grandes éxitos del thrash metal")
                .build();

        playlistService.save(playlist);
        playlist.addSong(song);

        playlistService.edit(playlist);

        System.out.printf(playlist.getName(),playlist.getListSongs(),playlist.getDescription());





    }

}
