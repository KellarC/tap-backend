package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {
}