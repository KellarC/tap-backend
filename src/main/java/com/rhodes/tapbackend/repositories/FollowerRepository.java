package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {
    @Query(value="SELECT id FROM followers WHERE follower = :follower AND followee = :followee", nativeQuery = true)
    Optional<Integer> findExistingFollow(@Param("follower") String follower, @Param("followee") String followee);

    @Query(value="SELECT follower FROM followers WHERE followee = :username", nativeQuery = true)
    List<String> findFollowers(@Param("username") String username);

    @Query(value="SELECT followee FROM followers WHERE follower = :username", nativeQuery = true)
    List<String> findFollowing(@Param("username") String username);
}