package com.salesianos.triana.Miarma.models;


import com.salesianos.triana.Miarma.users.model.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;

    @Lob
    private String descripcion;

    private String imagen;

    private Boolean isPublic;


    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    public Post(String titulo, String descripcion, String imagen, Boolean isPublic) {

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.isPublic = isPublic;
    }

    public void addUser (User u){

        this.user = u;
        u.getPosts().add(this);
    }

    public void removeUser(User u) {
        u.getPosts().remove(this);
        this.user = null;
    }



}
