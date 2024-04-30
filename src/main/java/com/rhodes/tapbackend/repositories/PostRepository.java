package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value="SELECT post_id from posts WHERE poster = :username", nativeQuery = true)
    List<Integer> findAllByUsername(@Param("username") String username);
}
