package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.models.ApplicationUser;
import com.rhodes.tapbackend.models.Follower;
import com.rhodes.tapbackend.models.Leaderboard;
import com.rhodes.tapbackend.models.Post;
import com.rhodes.tapbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowerRepository followerRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    @Autowired
    private FountainReviewRepository fountainReviewRepository;

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
            //postRepository.deleteAllByUsername(user.getUsername());
            //leaderboardRepository.deleteAllById(Collections.singleton(user.getUsername()));
            //followerRepository.deleteAllByUsername(user.getUsername());
            userRepository.deleteById(user.getUserId());
            return true; // deleted
        } else {
            return false; // user not found
        }
    }

    public boolean followUser(String follower_name, String followee_name) {
        // prevent duplicates
        if (followerRepository.findExistingFollow(follower_name, followee_name).isPresent()) {
            return false;
        }
        // ensure both users exist
        Optional<ApplicationUser> optionalFollower = userRepository.findByUsername(follower_name);
        Optional<ApplicationUser> optionalFollowee = userRepository.findByUsername(followee_name);
        if (!(optionalFollower.isPresent() || optionalFollowee.isPresent())) {
            return false;
        } else {
            // extract users from optionals and save new row in table
            ApplicationUser follower = optionalFollower.get();
            ApplicationUser followee = optionalFollowee.get();
            followerRepository.save(new Follower(0, follower, followee));
            return true;
        }
    }

    public boolean unfollowUser(String follower_name, String followee_name) {
        //confirm relationship exists
        Optional<Integer> relationshipId = followerRepository.findExistingFollow(follower_name, followee_name);
        if (relationshipId.isEmpty()) {
            return false;
        } else {
            // ensure both users exist
            Optional<ApplicationUser> optionalFollower = userRepository.findByUsername(follower_name);
            Optional<ApplicationUser> optionalFollowee = userRepository.findByUsername(followee_name);
            if (!(optionalFollower.isPresent() || optionalFollowee.isPresent())) {
                return false;
            }
            followerRepository.deleteById(relationshipId.get());
            return true;
        }
    }

    public List<String> viewFollowers(String username) {
        return followerRepository.findFollowers(username);
    }

    public List<String> viewFollowing(String username) {
        return followerRepository.findFollowing(username);
    }

    public Post createPost(String poster, String message, LocalDate localDate) {
        Optional<Leaderboard> exists = leaderboardRepository.findById(poster);
        if (exists.isEmpty()) {
            leaderboardRepository.save(new Leaderboard(poster, 25, 0));
        } else {
            Leaderboard row = exists.get();
            row.setPoints(row.getPoints() + 25);
            leaderboardRepository.save(row);
        }
        return postRepository.save(new Post(0, poster, message, localDate));
    }

    public boolean deletePost(Integer post_id, String requester) {
        //confirm post exists
        Optional<Post> post= postRepository.findById(post_id);
        if (post.isEmpty()) {
            return false;
        } else {
            // check if user deleting the post is the one who created it
            if (!post.get().getPoster().equals(requester)) {
                return false;
            } else {
                postRepository.deleteById(post_id);
                return true;
            }
        }
    }

    public void submitWater(String username, float ozOfWater) {
        //check if user is already in table
        Optional<Leaderboard> exists = leaderboardRepository.findById(username);
        if (exists.isEmpty()) {
            leaderboardRepository.save(new Leaderboard(username, (ozOfWater * 10), ozOfWater));
        } else {
            Leaderboard row = exists.get();
            row.setOzOfWater(row.getOzOfWater() + ozOfWater);
            row.setPoints(row.getPoints() + (ozOfWater * 10));
            leaderboardRepository.save(row);
        }
    }

    public List<Leaderboard> viewLeaderboard() {
        return leaderboardRepository.getLeaderboardDescending();
    }
}
