package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.ApplicationUser;
import com.rhodes.tapbackend.models.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer> {
    void deleteByFollowerAndFollowee(ApplicationUser follower, ApplicationUser followee);
}


