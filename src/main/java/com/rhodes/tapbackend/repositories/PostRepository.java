package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.Post;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Modifying
    @Query(value="DELETE from posts WHERE poster = :username", nativeQuery = true)
    void deleteAllByUsername(@Param("username") String username);
}
