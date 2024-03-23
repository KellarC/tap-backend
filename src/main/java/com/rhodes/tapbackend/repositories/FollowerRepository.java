package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {
    @Query(value="SELECT follower_id FROM followers WHERE followee_id = :user_id", nativeQuery = true)
    List<Integer> findFollowers(@Param("user_id") Integer user_id);
}