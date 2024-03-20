package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.models.ApplicationUser;
import com.rhodes.tapbackend.models.Follow;
import com.rhodes.tapbackend.repositories.FollowRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    public Follow follow(ApplicationUser follower, ApplicationUser followee) {
        return followRepository.save(new Follow(follower, followee));
    }

    public void unfollow(ApplicationUser follower, ApplicationUser followee) {
        followRepository.deleteByFollowerAndFollowee(follower, followee);
    }
}
