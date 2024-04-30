package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value="SELECT post_id FROM posts WHERE poster = :username", nativeQuery = true)
    List<Integer> findAllIdsByUsername(@Param("username") String username);

    @Query(value="SELECT * FROM posts WHERE poster = :username", nativeQuery = true)
    List<Post> findAllPostsByUser(@Param("username") String username);
}
