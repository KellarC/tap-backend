package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.models.ApplicationUser;
import com.rhodes.tapbackend.models.Follower;
import com.rhodes.tapbackend.repositories.FollowerRepository;
import com.rhodes.tapbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowerRepository followerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }

    public void changeUsername(String oldUsername, String newUsername) {
        ApplicationUser user = userRepository.findByUsername(oldUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setUsername(newUsername);
        userRepository.save(user);
    }

    public void changePassword(String username, String newPassword) {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    public void changeEmail(String username, String newEmail) {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setEmail(newEmail);
        userRepository.save(user);
    }

    public boolean deleteAccount(String username) {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElse(null); // null = does not exist
        if (user != null) {
            userRepository.delete(user);
            return true; // deleted
        } else {
            return false; // user not found
        }
    }

    public boolean followUser(Integer followerId, Integer followeeId) {
        Optional<ApplicationUser> optionalFollower = userRepository.findById(followerId);
        Optional<ApplicationUser> optionalFollowee = userRepository.findById(followeeId);

        if (!(optionalFollower.isPresent() || optionalFollowee.isPresent())) {
            return false;
        } else {
            ApplicationUser follower = optionalFollower.get();
            ApplicationUser followee = optionalFollowee.get();
            followerRepository.save(new Follower(0, follower, followee));
            return true;
        }
    }
}
