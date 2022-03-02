package com.salesianos.triana.Miarma.Repositorios;

import com.salesianos.triana.Miarma.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post,Long> {


    @Query (value = """
            SELECT * FROM Post WHERE is_public = true
            """, nativeQuery = true)
    List<Post> findAllPublicPosts ();

}
