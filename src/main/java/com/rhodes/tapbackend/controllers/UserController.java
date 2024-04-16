package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.models.*;
import com.rhodes.tapbackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/change-username")
    public ResponseEntity<?> changeUsername(@RequestBody ChangeUsernameDTO changeUsernameDTO) {
        userService.changeUsername(changeUsernameDTO.getOldUsername(), changeUsernameDTO.getNewUsername());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        userService.changePassword(changePasswordDTO.getUsername(), changePasswordDTO.getNewPassword());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/change-email")
    public ResponseEntity<?> changeEmail(@RequestBody ChangeEmailDTO changeEmailDTO) {
        userService.changeEmail(changeEmailDTO.getUsername(), changeEmailDTO.getNewEmail());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete-account")
    public ResponseEntity<?> deleteAccount(@RequestBody DeleteAccountDTO deleteAccountDTO) {
        boolean deleted = userService.deleteAccount(deleteAccountDTO.getUsername());
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/follow-user")
    public ResponseEntity<?> followUser(@RequestBody FollowUnfollowUserDTO followUnfollowUserDTO) {
        boolean follow = userService.followUser(followUnfollowUserDTO.getFollower(), followUnfollowUserDTO.getFollowee());
        if (follow) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/unfollow-user")
    public ResponseEntity<?> unfollowUser(@RequestBody FollowUnfollowUserDTO followUnfollowUserDTO) {
        boolean unfollow = userService.unfollowUser(followUnfollowUserDTO.getFollower(), followUnfollowUserDTO.getFollowee());
        if (unfollow) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/view-followers")
    public List<String> viewFollowers(@RequestBody ViewFollowersFollowingDTO viewFollowersFollowingDTO) {
        return userService.viewFollowers(viewFollowersFollowingDTO.getUsername());
    }

    @GetMapping("/view-following")
    public List<String> viewFollowing(@RequestBody ViewFollowersFollowingDTO viewFollowersFollowingDTO) {
        return userService.viewFollowing(viewFollowersFollowingDTO.getUsername());
    }
}