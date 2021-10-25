package com.salesianos.triana.E07.Modelos_de_datos_ManyToMany.modelo;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Artist implements Serializable {


    @Id
    @GeneratedValue

    private Long id;

    @Column(name ="name")
    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @OneToMany (mappedBy = "artist", fetch = FetchType.EAGER)
    private List<Song> songs = new ArrayList<>();

    @ManyToOne
    private Artist artist;




}
